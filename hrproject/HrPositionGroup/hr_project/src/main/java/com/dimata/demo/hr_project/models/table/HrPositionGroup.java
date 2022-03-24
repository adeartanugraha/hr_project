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
public class HrPositionGroup implements UpdateAvailable<HrPositionGroup>, Persistable<Long>{
    
    public static final String TABLE_NAME = "hr_position_group";
    public static final String ID_COL = "POSITION_GROUP_ID";
    public static final String POSITION_GROUP_NAME_COL = "POSITION_GROUP_NAME";
    public static final String DESCRIPTION_COL = "DESCRIPTION";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private String positionGroupName;
        private String description;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(String positionGroupName) {
            return new Builder().newRecord(true)
                .positionGroupName(Objects.requireNonNull(positionGroupName, "Type tidak boleh kosong"));
        }

        public static Builder updateBuilder(HrPositionGroup oldRecord, HrPositionGroup newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .positionGroupName(changeItOrNot(newRecord.getPositionGroupName(), oldRecord.getPositionGroupName()))
                .description(changeItOrNot(newRecord.getDescription(), oldRecord.getDescription()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public HrPositionGroup build() {
            HrPositionGroup result = new HrPositionGroup();
            
            result.setId(id);
            result.setPositionGroupName(positionGroupName);
            result.setDescription(description);

            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private String positionGroupName;
    private String description;
    @Transient
    @JsonIgnore
    private Long insertId;


    public static HrPositionGroup fromRow(Row row) {
        var result = new HrPositionGroup();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setPositionGroupName(ManipulateUtil.parseRow(row, POSITION_GROUP_NAME_COL, String.class));
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
    public HrPositionGroup update(HrPositionGroup newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
