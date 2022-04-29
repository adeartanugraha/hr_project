package com.dimata.demo.hr_project.forms;

import java.time.LocalDateTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.TimeDeserialize;
import com.dimata.demo.hr_project.enums.StatusAbsent;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataAbsentForm implements RecordAdapter<DataAbsent>{
    private Long id;
    // private DataUser idUser;
    private Long idUser;
    private String idToken;
    private Boolean isLate;
    private StatusAbsent status;
    private Long idSchedule;

    @JsonDeserialize(converter = TimeDeserialize.class)
     private LocalDateTime timeScheduleIn;

    
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime usedAt;
    
    
   
    @Override
    public DataAbsent convertNewRecord() {
            
        
        return DataAbsent.Builder.createNewRecord(idUser,idSchedule)
            .id(id)
            .isLate(isLate)
            .status(status)
            .timeScheduleIn(timeScheduleIn)
            .idToken(idToken)
            .build();
    }
    @Override
    public DataAbsent convertToRecord() {
        return DataAbsent.Builder.emptyBuilder()
            .id(id)
            .idToken(idToken)
            .idUser(idUser)
            .idSchedule(idSchedule)
            .isLate(isLate)
            .timeScheduleIn(timeScheduleIn)
            .build();
    }
}
