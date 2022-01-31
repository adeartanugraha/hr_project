package com.dimata.demo.hr_project.forms;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.enums.IsActive;
import com.dimata.demo.hr_project.models.table.DataToken;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataTokenForm implements RecordAdapter<DataToken>{
    private Long id;
    private IsActive isActive;
    
    @Override
    public DataToken convertNewRecord() {
        return DataToken.Builder.createNewRecord(isActive)
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
