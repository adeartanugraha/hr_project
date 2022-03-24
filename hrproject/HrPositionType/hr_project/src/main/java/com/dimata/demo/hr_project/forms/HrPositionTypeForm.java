package com.dimata.demo.hr_project.forms;


import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrPositionType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrPositionTypeForm implements RecordAdapter<HrPositionType> {

    private Long id;
    private String type;
    private String description;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrPositionType convertNewRecord() {
        return HrPositionType.Builder.createNewRecord(type)
            .description(description)
            .id(id)
            .build();
    }
    @Override
    public HrPositionType convertToRecord() {
        return HrPositionType.Builder.emptyBuilder()
            .type(type)
            .description(description)
            .id(id)
            .build();
    }
}
