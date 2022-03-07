package com.dimata.demo.hr_project.models.output;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    private Long day;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeIn;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeOut;
    private Long idIndustry;
    private Long idUser;
    private String username;
    private String nameIndustry;
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
        result.setDay(ManipulateUtil.parseRow(row, "day", Long.class));
        result.setIdIndustry(ManipulateUtil.parseRow(row, "id_industry", Long.class));
        result.setNameIndustry(ManipulateUtil.parseRow(row, "name_industry", String.class));
        result.setIdUser(ManipulateUtil.parseRow(row, "id_user", Long.class));
        result.setUsername(ManipulateUtil.parseRow(row, "username", String.class));
        result.setStatus(WorkStatus.getStatus(ManipulateUtil.parseRow(row, "status", Integer.class)));
        
        return result;
    }
  

}
