package com.dimata.demo.hr_project.forms;

import java.time.LocalDateTime;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.TimeDeserialize;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataAbsentForm implements RecordAdapter<DataAbsent>{
    private Long id;
    private Long idUser;
    private Long idToken;
    private Boolean isLate;
    private Long idSchedule;

    @JsonDeserialize(converter = TimeDeserialize.class)
     private LocalDateTime timeScheduleIn;
     @JsonDeserialize(converter = TimeDeserialize.class)
     private LocalDateTime timeScheduleOut;
    
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime checkInTime;
    @JsonDeserialize(converter = TimeDeserialize.class)
     private LocalDateTime checkOutTime;
    

     private Boolean isLate;
    
   
    @Override
    public DataAbsent convertNewRecord() {
            
        
        return DataAbsent.Builder.createNewRecord(idUser,idSchedule)
            .id(id)

            .isLate(isLate)
            .timeScheduleIn(timeScheduleIn)
            .timeScheduleOut(timeScheduleOut)
            .checkInTime(checkInTime)

            .idToken(idToken)

            .build();
    }
    @Override
    public DataAbsent convertToRecord() {
        return DataAbsent.Builder.emptyBuilder()
            .id(id)
            .isLate(isLate)
            .idToken(idToken)
            .idSchedule(idSchedule)
            .isLate(isLate)
            .timeScheduleIn(timeScheduleIn)
            .timeScheduleOut(timeScheduleOut)
            .build();
    }
}
