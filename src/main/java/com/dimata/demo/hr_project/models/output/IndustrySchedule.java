package com.dimata.demo.hr_project.models.output;

import java.time.LocalTime;

import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.OnlyTimeSerialize;
import com.dimata.demo.hr_project.enums.DayOfWeeks;
import com.dimata.demo.hr_project.enums.IsOff;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndustrySchedule {
    private Long id;
    private Long idIndustry;
    private Integer day;
    private Integer isoff;
    private String nameIndustry;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeIn;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeOut;

    public void setDay(DayOfWeeks day) {
        if (day != null) {
            this.day = day.getCode();
        }
    }

    public DayOfWeeks getDay() {
        if (day != null) {
            return DayOfWeeks.getDay(this.day);
        }
        return null;
    }
    
    public void setIsoff(IsOff isoff) {
        if (isoff != null) {
            this.isoff = isoff.getCode();
        }
    }

    public IsOff getIsoff() {
        if (isoff != null) {
            return IsOff.getIsOff(this.isoff);
        }
        return null;
    }

    public static IndustrySchedule fromRow(Row row) {
        var result = new IndustrySchedule();
        result.setId(ManipulateUtil.parseRow(row, "id_schedule", Long.class));
        result.setIdIndustry(ManipulateUtil.parseRow(row, "id_industry", Long.class));
        result.setNameIndustry(ManipulateUtil.parseRow(row, "name_industry", String.class));
        result.setDay(DayOfWeeks.getDay(ManipulateUtil.parseRow(row, "day", Integer.class)));
        result.setTimeIn(ManipulateUtil.parseRow(row, "time_in", LocalTime.class));
        result.setTimeOut(ManipulateUtil.parseRow(row, "time_out", LocalTime.class));
        result.setIsoff(IsOff.getIsOff(ManipulateUtil.parseRow(row, "isoff", Integer.class)));
        
        return result;
    }
}
