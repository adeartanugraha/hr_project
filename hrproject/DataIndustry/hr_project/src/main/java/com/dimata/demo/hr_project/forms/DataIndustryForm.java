package com.dimata.demo.hr_project.forms;


import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataIndustryForm implements RecordAdapter<DataIndustry> {

    private Long id;
    private String nameIndustry;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public DataIndustry convertNewRecord() {
        return DataIndustry.Builder.createNewRecord(nameIndustry)
            .id(id)
            .build();
    }
    @Override
    public DataIndustry convertToRecord() {
        return DataIndustry.Builder.emptyBuilder()
            .nameIndustry(nameIndustry)
            .id(id)
            .build();
    }
}
