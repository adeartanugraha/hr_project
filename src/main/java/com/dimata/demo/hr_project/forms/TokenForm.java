package com.dimata.demo.hr_project.forms;

import java.time.LocalDateTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.TimeDeserialize;
import com.dimata.demo.hr_project.enums.IsActive;
import com.dimata.demo.hr_project.models.table.Token;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class TokenForm implements RecordAdapter<Token>{
    private String id;
    private IsActive isActive;
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime createdAt;
    
    @Override
    public Token convertNewRecord() {
        return Token.Builder.createNewRecord(isActive)
            .createdAt(createdAt)
            .id(id)
            .build();
    }
    @Override
    public Token convertToRecord() {
        return Token.Builder.emptyBuilder()
            .isActive(isActive)
            .id(id)
            .build();
    }
}
