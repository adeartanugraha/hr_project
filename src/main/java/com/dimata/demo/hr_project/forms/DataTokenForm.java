package com.dimata.demo.hr_project.forms;

import java.time.LocalDateTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.TimeDeserialize;
import com.dimata.demo.hr_project.enums.IsActive;
import com.dimata.demo.hr_project.models.table.DataToken;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataTokenForm implements RecordAdapter<DataToken>{
    private Long id;
    private IsActive isActive;
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime createdAt;
    
    @Override
    public DataToken convertNewRecord() {
        return DataToken.Builder.createNewRecord(isActive)
            .createdAt(createdAt)
            .id(id)
            .build();
    }
    @Override
    public DataToken convertToRecord() {
        return DataToken.Builder.emptyBuilder()
            .isActive(isActive)
            .id(id)
            .build();
    }
}
