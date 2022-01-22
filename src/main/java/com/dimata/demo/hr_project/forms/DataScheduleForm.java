package com.dimata.demo.hr_project.forms;


import java.time.LocalTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.OnlyTimeDeserialize;
import com.dimata.demo.hr_project.enums.DayOfWeek;
import com.dimata.demo.hr_project.enums.IsOff;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataScheduleForm implements RecordAdapter<DataSchedule> {

    private Long id;
    private Long idIndustry;
    private DayOfWeek day;
    private IsOff isoff;
    @JsonDeserialize(converter = OnlyTimeDeserialize.class)
    private LocalTime timeIn;
    @JsonDeserialize(converter = OnlyTimeDeserialize.class)
    private LocalTime timeOut;
    @Override
    public DataSchedule convertNewRecord() {
        return DataSchedule.Builder.createNewRecord(day, timeIn, timeOut, idIndustry, isoff)
            .id(id)
            .build();
    }
    @Override
    public DataSchedule convertToRecord() {
        return DataSchedule.Builder.emptyBuilder()
            .idIndustry(idIndustry)
            .day(day)
            .timeIn(timeIn)
            .timeOut(timeOut)
            .isoff(isoff)
            .id(id)
            .build();
    }
}
