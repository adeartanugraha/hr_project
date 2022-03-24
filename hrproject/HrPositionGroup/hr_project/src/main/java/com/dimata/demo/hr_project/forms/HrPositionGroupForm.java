package com.dimata.demo.hr_project.forms;


import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrPositionGroup;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrPositionGroupForm implements RecordAdapter<HrPositionGroup> {

    private Long id;
    private String positionGroupName;
    private String description;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrPositionGroup convertNewRecord() {
        return HrPositionGroup.Builder.createNewRecord(positionGroupName)
            .description(description)
            .id(id)
            .build();
    }
    @Override
    public HrPositionGroup convertToRecord() {
        return HrPositionGroup.Builder.emptyBuilder()
            .positionGroupName(positionGroupName)
            .description(description)
            .id(id)
            .build();
    }
}
