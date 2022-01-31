package com.dimata.demo.hr_project.models.table;


import java.util.Objects;
import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.core.util.jackson.DateSerialize;
import com.dimata.demo.hr_project.enums.IsActive;
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

public class DataToken implements Persistable<Long>, UpdateAvailable<DataToken> {
    public static final String TABLE_NAME = "data_token";
    public static final String ID_COL = "token_code";
    public static final String IS_ACTIVE_COL = "is_active";
    
    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private IsActive isActive;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(IsActive isActive) {
            return new Builder().newRecord(true)
                .isActive(Objects.requireNonNull(isActive, "is active tidak boleh kosong"));
        }

        public static Builder updateBuilder(DataToken oldRecord, DataToken newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .isActive(changeItOrNot(newRecord.getIsActive(), oldRecord.getIsActive()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataToken build() {
            DataToken result = new DataToken();
            result.setId(id);
            result.setIsActive(isActive);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Integer isActive;

    
    @Transient
    @JsonIgnore
    private Long insertId;

    public void setIsActive(IsActive isactive) {
        if (isactive!= null) {
            this.isActive= isactive.getCode();
        }
    }

    public IsActive getIsActive() {
        if (isActive != null) {
            return IsActive.getIsActive(this.isActive);
        }
        return null;
    }

    public static DataToken fromRow(Row row) {
        var result = new DataToken();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setIsActive(IsActive.getIsActive(ManipulateUtil.parseRow(row, IS_ACTIVE_COL, Integer.class)));
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
    public DataToken update(DataToken newData) {
        return Builder.updateBuilder(this, newData).build();
    }
}
