package com.dimata.demo.hr_project.forms;


import java.sql.Time;
import java.time.LocalTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.OnlyTimeDeserialize;
import com.dimata.demo.hr_project.core.util.jackson.TimeDeserialize;
import com.dimata.demo.hr_project.enums.DayOfWeek;
import com.dimata.demo.hr_project.models.table.DataWorkhour;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataWorkhourForm implements RecordAdapter<DataWorkhour> {

    private Long id;
    private Long idIndustry;
    private DayOfWeek day;
    @JsonDeserialize(converter = OnlyTimeDeserialize.class)
    private LocalTime timeIn;
    @JsonDeserialize(converter = OnlyTimeDeserialize.class)
    private LocalTime timeOut;
    @Override
    public DataWorkhour convertNewRecord() {
        return DataWorkhour.Builder.createNewRecord(day)
            .idIndustry(idIndustry)
            .id(id)
            .build();
    }
    @Override
    public DataWorkhour convertToRecord() {
        return DataWorkhour.Builder.emptyBuilder()
            .idIndustry(idIndustry)
            .day(day)
            .timeIn(timeIn)
            .timeOut(timeOut)
            .id(id)
            .build();
    }
}
