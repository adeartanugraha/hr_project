package com.dimata.demo.hr_project.models.output;

import java.time.LocalTime;

import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.OnlyTimeSerialize;
import com.dimata.demo.hr_project.enums.WorkStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSchedule {
    private Long id;
    private Long idSchedule;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeIn;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeOut;
    private Long idIndustry;
    private Long idUser;
    private Integer status;

    public void setStatus(WorkStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public WorkStatus getStatus() {
        if (status != null) {
            return WorkStatus.getStatus(this.status);
        }
        return null;
    }

    public static UserSchedule fromRow(Row row) {
        var result = new UserSchedule();
        result.setId(ManipulateUtil.parseRow(row, "id_mainschedule", Long.class));
        result.setIdSchedule(ManipulateUtil.parseRow(row, "id_schedule", Long.class));
        result.setTimeIn(ManipulateUtil.parseRow(row, "time_in", LocalTime.class));
        result.setTimeOut(ManipulateUtil.parseRow(row, "time_out", LocalTime.class));
        result.setIdIndustry(ManipulateUtil.parseRow(row, "id_industry", Long.class));
        result.setIdUser(ManipulateUtil.parseRow(row, "id_user", Long.class));
        result.setStatus(WorkStatus.getStatus(ManipulateUtil.parseRow(row, "status", Integer.class)));
        
        return result;
    }

}