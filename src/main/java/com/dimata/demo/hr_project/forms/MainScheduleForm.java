package com.dimata.demo.hr_project.forms;

import java.time.LocalDate;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.enums.WorkStatus;
import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MainScheduleForm implements RecordAdapter<MainSchedule> {

    private Long id;
    private Long idSchedule;
    private Long idIndustry;
    private Long idUser;
    private WorkStatus status;
    @Override
    public MainSchedule convertNewRecord() {
        return MainSchedule.Builder.createNewRecord(status)
            .idSchedule(idSchedule)
            .idIndustry(idIndustry)
            .idUser(idUser)
            .id(id)
            .build();
    }
    @Override
    public MainSchedule convertToRecord() {
        return MainSchedule.Builder.emptyBuilder()
            .status(status)
            .idSchedule(idSchedule)
            .idIndustry(idIndustry)
            .idUser(idUser)
            .id(id)
            .build();
    }
}
