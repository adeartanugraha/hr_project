package com.dimata.demo.hr_project.models.table;

import java.util.Objects;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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
public class DataIndustry implements UpdateAvailable<DataIndustry>, Persistable<Long>{
    
    public static final String TABLE_NAME = "data_industry";
    public static final String ID_COL = "id_industry";
    public static final String NAME_INDUSTRY_COL = "name_industry";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String nameIndustry;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String nameIndustry) {
            return new Builder().newRecord(true)
                .nameIndustry(Objects.requireNonNull(nameIndustry, "Nama Industry tidak boleh kosong"));
        }

        public static Builder updateBuilder(DataIndustry oldRecord, DataIndustry newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .nameIndustry(changeItOrNot(newRecord.getNameIndustry(), oldRecord.getNameIndustry()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataIndustry build() {
            DataIndustry result = new DataIndustry();
            
            result.setId(id);
            result.setNameIndustry(nameIndustry);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String nameIndustry;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static DataIndustry fromRow(Row row) {
        var result = new DataIndustry();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setNameIndustry(ManipulateUtil.parseRow(row, NAME_INDUSTRY_COL, String.class));

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
    public DataIndustry update(DataIndustry newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
