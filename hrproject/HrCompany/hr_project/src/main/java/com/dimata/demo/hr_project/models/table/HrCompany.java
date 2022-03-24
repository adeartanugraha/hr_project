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
public class HrCompany implements UpdateAvailable<HrCompany>, Persistable<Long>{
    
    public static final String TABLE_NAME = "hr_company";
    public static final String ID_COL = "COMPANY_ID";
    public static final String COMPANY_COL = "COMPANY";
    public static final String DESCRIPTION_COL = "DESCRIPTION";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String company;
        private String description;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String company) {
            return new Builder().newRecord(true)
                .company(Objects.requireNonNull(company, "Company tidak boleh kosong"));
        }

        public static Builder updateBuilder(HrCompany oldRecord, HrCompany newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .company(changeItOrNot(newRecord.getCompany(), oldRecord.getCompany()))
                .description(changeItOrNot(newRecord.getDescription(), oldRecord.getDescription()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public HrCompany build() {
            HrCompany result = new HrCompany();
            
            result.setId(id);
            result.setCompany(company);
            result.setDescription(description);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String company;
    private String description;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static HrCompany fromRow(Row row) {
        var result = new HrCompany();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setCompany(ManipulateUtil.parseRow(row, COMPANY_COL, String.class));
        result.setDescription(ManipulateUtil.parseRow(row, DESCRIPTION_COL, String.class));

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
    public HrCompany update(HrCompany newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
