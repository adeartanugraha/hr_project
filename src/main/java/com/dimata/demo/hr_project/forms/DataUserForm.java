package com.dimata.demo.hr_project.forms;

// import java.time.LocalDate;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataUserForm implements RecordAdapter<DataUser>{
    private Long id;
    private String username;
    private String password;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public DataUser convertNewRecord() {
        return DataUser.Builder.createNewRecord(username,password)
            .id(id)
            .build();
    }
    @Override
    public DataUser convertToRecord() {
        return DataUser.Builder.emptyBuilder()
            .id(id)
            .username(username)
            .password(password)
            .build();
    }
}
