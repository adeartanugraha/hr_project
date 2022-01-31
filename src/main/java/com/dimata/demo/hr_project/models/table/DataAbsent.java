package com.dimata.demo.hr_project.models.table;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.TimeSerialize;
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

public class DataAbsent implements Persistable<Long>, UpdateAvailable<DataAbsent> {
    public static final String TABLE_NAME = "data_absent";
    public static final String ID_COL = "id_absent";
    public static final String ID_USER_COL = "id_user";
    public static final String ID_INDUSTRY_COL = "id_schedule";
    public static final String CHECK_IN_TIME_COL = "check_in_time";
    public static final String CHECK_OUT_TIME_COL = "check_out_time";
    public static final String IS_LATE_COL = "is_late";


    // @OneToOne
    // @JoinColumn(name="time_in", nullable = false)
    // @JsonDeserialize(converter = OnlyTimeDeserialize.class)
    // private LocalTime schedule;
    // LocalDateTime a = LocalDateTime.of(LocalDate.now(),schedule);


    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private Long idUser;
        private Long idSchedule; 
        private Boolean isLate; 
        private LocalDateTime checkInTime;
        private LocalDateTime checkOutTime;


        @Setter(AccessLevel.PRIVATE)
        private boolean newRecord = false;


        

        

        public static Builder createNewRecord(Long idUser, Long idSchedule, LocalDateTime checkInTime) {
            return new Builder().newRecord(true)
                .idUser(Objects.requireNonNull(idUser, "id user tidak boleh kosong"))
                .idSchedule(Objects.requireNonNull(idSchedule, "id industry tidak boleh kosong"));
        }

        public static Builder updateBuilder(DataAbsent oldRecord, DataAbsent newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .idUser(changeItOrNot(newRecord.getIdUser(), oldRecord.getIdUser()))
                .isLate(changeItOrNot(newRecord.getIsLate(), oldRecord.getIsLate()))
                .idSchedule(changeItOrNot(newRecord.getIdSchedule(), oldRecord.getIdSchedule()))
                .checkOutTime(changeItOrNot(newRecord.getCheckOutTime(), oldRecord.getCheckOutTime()))
                .checkInTime(oldRecord.getCheckInTime());
               
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataAbsent build() {
            DataAbsent result = new DataAbsent();
            result.setId(id);
            result.setIdUser(idUser);
            result.setIsLate(isLate);
            result.setIdSchedule(idSchedule);
            result.setCheckInTime(checkInTime);
            result.setCheckOutTime(checkOutTime);
            
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Long idUser;
    private Long idSchedule;
    private Boolean isLate;
    
    @JsonSerialize(converter = TimeSerialize.class)
    private LocalDateTime checkInTime ;
    @JsonSerialize(converter = TimeSerialize.class)
    private LocalDateTime checkOutTime;

    @Transient
    @JsonIgnore
    private Long insertId;


  


    public static DataAbsent fromRow(Row row) {
        var result = new DataAbsent();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setIdUser(ManipulateUtil.parseRow(row, ID_USER_COL, Long.class));
        result.setIsLate(ManipulateUtil.parseRow(row, IS_LATE_COL, Boolean.class));
        result.setIdSchedule(ManipulateUtil.parseRow(row, ID_INDUSTRY_COL, Long.class));
        result.setCheckInTime(ManipulateUtil.parseRow(row, CHECK_IN_TIME_COL, LocalDateTime.class));
        result.setCheckOutTime(ManipulateUtil.parseRow(row, CHECK_OUT_TIME_COL, LocalDateTime.class));
        return result;
    }

    

    @Override
    public boolean isNew() {
        if (id == null && insertId == null) {
            id = new GenerateUtil().generateOID();
            checkInTime = LocalDateTime.now();
            
            // isLate = checkInTime.isAfter(a);
            return true;
        } else if (id == null) {
            id = insertId;
            checkInTime = LocalDateTime.now();
            return true;
        }
        return false;
    }
    
    

    @Override
    public DataAbsent update(DataAbsent newData) {
        checkOutTime = LocalDateTime.now();
        return Builder.updateBuilder(this, newData).build();
    }
}
