package com.dimata.demo.hr_project.models.table;


import java.time.LocalDateTime;

import java.util.Objects;


import static com.dimata.demo.hr_project.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.demo.hr_project.core.api.UpdateAvailable;
import com.dimata.demo.hr_project.core.util.GenerateUtil;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;

import com.dimata.demo.hr_project.core.util.jackson.TimeSerialize;
import com.dimata.demo.hr_project.enums.StatusAbsent;
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
    public static final String ID_SCHEDULE_COL = "id_schedule";
    public static final String ID_TOKEN_COL = "id_token";
    public static final String USED_AT_COL = "used_at";
    public static final String STATUS_COL = "status";
    public static final String IS_LATE_COL = "is_late";

    @Accessors(fluent = true)
    @Setter
    public static class Builder {

        private Long id;
        private Long idUser;
        private Long idSchedule; 
        private String idToken; 
        private Boolean isLate; 
        private LocalDateTime usedAt;
        private StatusAbsent status;
      
        private LocalDateTime timeScheduleIn;
        


        @Setter(AccessLevel.PRIVATE)
        private Boolean newRecord = false;
        

        

        

        public static Builder createNewRecord(Long idUser, Long idSchedule) {
            return new Builder().newRecord(true)
                .idUser(Objects.requireNonNull(idUser, "id user tidak boleh kosong"))
                .idSchedule(Objects.requireNonNull(idSchedule, "id schedule tidak boleh kosong"));
                
        }

        public static Builder updateBuilder(DataAbsent oldRecord, DataAbsent newRecord) {
            return new Builder()
                .id(oldRecord.getId())
                .idUser(changeItOrNot(newRecord.getIdUser(), oldRecord.getIdUser()))
                .idToken(changeItOrNot(newRecord.getIdToken(), oldRecord.getIdToken()))
                .isLate(changeItOrNot(newRecord.getIsLate(), oldRecord.getIsLate()))
                .idSchedule(changeItOrNot(newRecord.getIdSchedule(), oldRecord.getIdSchedule()))
                .status(changeItOrNot(newRecord.getStatus(),(newRecord.getStatus())))
                .isLate(changeItOrNot(newRecord.getIsLate(),(newRecord.getIsLate())))
                .usedAt(oldRecord.getUsedAt());

               
        }

        public static Builder emptyBuilder() {
            return new Builder();
        }

        public DataAbsent build() {
            DataAbsent result = new DataAbsent();
            result.setId(id);
            result.setIdUser(idUser);
            result.setIdToken(idToken);
            result.setIdSchedule(idSchedule);
            result.setUsedAt(usedAt);
            result.setTimeScheduleIn(timeScheduleIn);
            result.setIsLate(isLate);
            result.setStatus(status);
            return result;
        }
    }

    @Id
    @Column(ID_COL)
    private Long id;
    private Long idUser;
    private Long idSchedule;
    private String idToken; 
    private Integer status;
    private Boolean isLate;
    
    @JsonSerialize(converter = TimeSerialize.class)
    private LocalDateTime usedAt ;
    
    @Transient
    @JsonIgnore
    @JsonSerialize(converter = TimeSerialize.class)
     private LocalDateTime timeScheduleIn;
     


    @Transient
    @JsonIgnore
    private Long insertId;

    public void setStatus(StatusAbsent status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public StatusAbsent getStatus() {
        if (status != null) {
            return StatusAbsent.getStatusAbsent(this.status);
        }
        return null;
    }

    public static DataAbsent fromRow(Row row) {
        var result = new DataAbsent();
        result.setId(ManipulateUtil.parseRow(row, ID_COL, Long.class));
        result.setIdUser(ManipulateUtil.parseRow(row, ID_USER_COL, Long.class));
        result.setIdToken(ManipulateUtil.parseRow(row, ID_TOKEN_COL, String.class));
        result.setIsLate(ManipulateUtil.parseRow(row, IS_LATE_COL, Boolean.class));
        result.setIdSchedule(ManipulateUtil.parseRow(row, ID_SCHEDULE_COL, Long.class));
        result.setUsedAt(ManipulateUtil.parseRow(row, USED_AT_COL, LocalDateTime.class));
        result.setStatus(StatusAbsent.getStatusAbsent(ManipulateUtil.parseRow(row, STATUS_COL, Integer.class)));
        return result;
    }

    

    @Override
    public boolean isNew() {
        usedAt = LocalDateTime.now();
        if (id==null&& insertId==null) {
            id = new GenerateUtil().generateOID();

            if(status==0){
                isLate = usedAt.isAfter(timeScheduleIn);
            }else if(status==1){
                isLate = usedAt.isBefore(timeScheduleIn);  }         
            
            return true;
        } else if (id==null) {
            id = insertId;
           
            if(status==0){
                isLate = usedAt.isAfter(timeScheduleIn);
            }else if(status==1){
                isLate = usedAt.isBefore(timeScheduleIn); }     

            return true;
        }else{
            return false;
            }
    }
    
    
    

    @Override
    public DataAbsent update(DataAbsent newData) {
        return Builder.updateBuilder(this, newData).build();
    }
    
}
