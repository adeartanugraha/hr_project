package com.dimata.demo.hr_project.models.table;

import java.time.LocalTime;
import java.util.Objects;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.OnlyTimeSerialize;
import com.dimata.demo.hr_project.enums.DayOfWeek;
import com.dimata.demo.hr_project.enums.IsOff;
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
public class DataSchedule implements UpdateAvailable<DataSchedule>, Persistable<Long>{
    
    public static final String TABLE_NAME = "data_schedule";
    public static final String ID_COL = "id_schedule";
    public static final String ID_INDUSTRY_COL = "id_industry";
    public static final String DAY_COL = "day";
    public static final String TIME_IN_COL = "time_in";
    public static final String TIME_OUT_COL = "time_out";
    public static final String ISOFF_COL = "isoff";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private Long idIndustry;
        private DayOfWeek day;
        private LocalTime timeIn;
        private LocalTime timeOut;
        private IsOff isoff;
        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;

        public static Builder createNewRecord( DayOfWeek day) {
            return new Builder().newRecord(true)
                // .timeIn(Objects.requireNonNull(timeIn, "Jam Masuk Tidak Boleh Kosong"))
                // .timeOut(Objects.requireNonNull(timeOut, "Jam Pulang Tidak Boleh Kosong"))
                .day(Objects.requireNonNull(day, "Hari Tidak Boleh Kosong"));
        }

        public static Builder updateBuilder(DataSchedule oldRecord, DataSchedule newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .idIndustry(changeItOrNot(newRecord.getIdIndustry(), oldRecord.getIdIndustry()))
                .day(changeItOrNot(newRecord.getDay(), oldRecord.getDay()))
                .timeIn(changeItOrNot(newRecord.getTimeIn(), oldRecord.getTimeIn()))
                .timeOut(changeItOrNot(newRecord.getTimeOut(), oldRecord.getTimeOut()))
                .isoff(changeItOrNot(newRecord.getIsoff(), oldRecord.getIsoff()));
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataSchedule build() {
            DataSchedule result = new DataSchedule();
            result.setId(id);
            result.setIdIndustry(idIndustry);
            result.setDay(day);
            result.setTimeIn(timeIn);
            result.setTimeOut(timeOut);
            result.setIsoff(isoff);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Long idIndustry;
    private Integer day;
    private Integer isoff;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeIn;
    @JsonSerialize(converter = OnlyTimeSerialize.class)
    private LocalTime timeOut;
    @Transient
    @JsonIgnore
    private Long insertId;

    public void setDay(DayOfWeek day) {
        if (day != null) {
            this.day = day.getCode();
        }
    }

    public DayOfWeek getDay() {
        if (day != null) {
            return DayOfWeek.getDay(this.day);
        }
        return null;
    }
    
    public void setIsoff(IsOff isoff) {
        if (isoff != null) {
            this.isoff = isoff.getCode();
        }
    }

    public IsOff getIsoff() {
        if (isoff != null) {
            return IsOff.getIsOff(this.isoff);
        }
        return null;
    }

    public static DataSchedule fromRow(Row row) {
        var result = new DataSchedule();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setIdIndustry(ManipulateUtil.parseRow(row, ID_INDUSTRY_COL, Long.class));;
        result.setDay(DayOfWeek.getDay(ManipulateUtil.parseRow(row, DAY_COL, Integer.class)));
        result.setTimeIn(ManipulateUtil.parseRow(row, TIME_IN_COL, LocalTime.class));
        result.setTimeOut(ManipulateUtil.parseRow(row, TIME_OUT_COL, LocalTime.class));
        result.setIsoff(IsOff.getIsOff(ManipulateUtil.parseRow(row, ISOFF_COL, Integer.class)));
        
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
    public DataSchedule update(DataSchedule newData) {
        return Builder.updateBuilder(this, newData).build();
    }

    
}
