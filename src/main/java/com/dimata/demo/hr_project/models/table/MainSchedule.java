package com.dimata.demo.hr_project.models.table;

import java.time.LocalDate;
import java.util.Objects;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.DateSerialize;
import com.dimata.demo.hr_project.enums.WorkStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class MainSchedule implements UpdateAvailable<MainSchedule>, Persistable<Long>{
    
    public static final String TABLE_NAME = "main_schedule";
    public static final String ID_COL = "id_mainschedule";
    public static final String ID_SCHEDULE_COL = "id_schedule";
    public static final String ID_INDUSTRY_COL = "id_industry";
    public static final String ID_USER_COL = "id_user";
    public static final String STATUS_COL = "status";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private Long idSchedule;
        private Long idIndustry;
        private Long idUser;
        private WorkStatus status;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord(WorkStatus status) {
            return new Builder().newRecord(true)
                .status(Objects.requireNonNull(status, "Status diperlukan"));
        }

        public static Builder updateBuilder(MainSchedule oldRecord, MainSchedule newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .idSchedule(changeItOrNot(newRecord.getIdSchedule(), oldRecord.getIdSchedule()))
                .idIndustry(changeItOrNot(newRecord.getIdIndustry(), oldRecord.getIdIndustry()))
                .idUser(changeItOrNot(newRecord.getIdUser(), oldRecord.getIdUser()))
                .status(changeItOrNot(newRecord.getStatus(), oldRecord.getStatus()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public MainSchedule build() {
            MainSchedule result = new MainSchedule();
            
            result.setIdIndustry(idIndustry);
            result.setIdSchedule(idSchedule);
            result.setIdUser(idUser);
            result.setStatus(status);
            result.setId(id);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Long idSchedule;
    private Long idIndustry;
    private Long idUser;
    private Integer status;
    @Transient
    @JsonIgnore
    private Long insertId;

    public void setStatus(WorkStatus status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public WorkStatus getStatus() {
        if (status != null) {
            return WorkStatus.getStatus(this.status);
        }
        return null;
    }

    public static MainSchedule fromRow(Row row) {
        var result = new MainSchedule();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setIdSchedule(ManipulateUtil.parseRow(row, ID_SCHEDULE_COL, Long.class));
        result.setIdIndustry(ManipulateUtil.parseRow(row, ID_INDUSTRY_COL, Long.class));
        result.setIdUser(ManipulateUtil.parseRow(row, ID_USER_COL, Long.class));
        result.setStatus(WorkStatus.getStatus(ManipulateUtil.parseRow(row, STATUS_COL, Integer.class)));
        
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
    public MainSchedule update(MainSchedule newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
