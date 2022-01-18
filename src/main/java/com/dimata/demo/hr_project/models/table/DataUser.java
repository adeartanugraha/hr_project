package com.dimata.demo.hr_project.models.table;


import java.util.Objects;
import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.core.util.jackson.DateSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DataUser implements Persistable<Long>, UpdateAvailable<DataUser> {
    public static final String TABLE_NAME = "data_user";
    public static final String ID_COL = "id_user";
    public static final String USERNAME_COL = "username";
    public static final String PASSWORD_COL = "password";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String username;
        private String password;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String username, String password) {
            return new Builder().newRecord(true)
                .username(Objects.requireNonNull(username, "username tidak boleh kosong"))
                .password(Objects.requireNonNull(password, "password tidak boleh kosong"));
        }

        public static Builder updateBuilder(DataUser oldRecord, DataUser newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .username(changeItOrNot(newRecord.getUsername(), oldRecord.getUsername()))
                .password(changeItOrNot(newRecord.getPassword(), oldRecord.getPassword()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataUser build() {
            DataUser result = new DataUser();
            result.setId(id);
            result.setUsername(username);
            result.setPassword(password);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String username;
    private String password;

    
    @Transient
    @JsonIgnore
    private Long insertId;


    public static DataUser fromRow(Row row) {
        var result = new DataUser();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setUsername(ManipulateUtil.parseRow(row, USERNAME_COL, String.class));
        result.setPassword(ManipulateUtil.parseRow(row, PASSWORD_COL, String.class));
        return result;
    }

    

    @Override
    public boolean isNew() {
        if (id == null && insertId == null) {
            id = new GenerateUtil().generateOID();
            return true;
        } else if (id == null) {
            id = insertId;
            return true;
        }
        return false;
    }

    @Override
    public DataUser update(DataUser newData) {
        return Builder.updateBuilder(this, newData).build();
    }
}
