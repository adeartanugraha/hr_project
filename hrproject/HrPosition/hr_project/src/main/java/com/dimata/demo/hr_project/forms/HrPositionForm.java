package com.dimata.demo.hr_project.forms;


import java.time.LocalDate;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrPosition;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrPositionForm implements RecordAdapter<HrPosition> {

    private Long id;
    private String position;
    private String description;
    private Integer positionLevel;
    private Integer disableAppUnderSupervisor;
    private Integer disableAppDebtScore;
    private Integer disableAppDivScore;
    private Integer allDepartment;
    private Integer dedlineSchBefore;
    private Integer dedlineSchAfter;
    private Integer dedlineSchLeaveBefore;
    private Integer dedlineSchLeaveAfter;
    private Integer headTitle;
    private Integer positionLevelPayrol;
    private String positionKode;
    private Integer flagPositionShowInPayrollInput;
    private Integer ageMin;
    private Integer ageRecommended;
    private Integer ageMax;
    private Integer lengthOfServiceMin;
    private Integer lengthOfServiceRecommended;
    private Integer lengthOfExperienceMin;
    private Integer lengthOfExperienceRecommended;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    private Long levelId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long positionGroupId;
    private Integer tenagaKerja;
    private Integer jenisJabatan;
    private String alias;
    private Long positionTypeId;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrPosition convertNewRecord() {
        return HrPosition.Builder.createNewRecord(position)
            .description(description)
            .positionLevel(positionLevel)
            .disableAppUnderSupervisor(disableAppUnderSupervisor)
            .disableAppDebtScore(disableAppDebtScore)
            .disableAppDivScore(disableAppDivScore)
            .allDepartment(allDepartment)
            .dedlineSchBefore(dedlineSchBefore)
            .dedlineSchAfter(dedlineSchAfter)
            .dedlineSchLeaveBefore(dedlineSchLeaveBefore)
            .dedlineSchLeaveAfter(dedlineSchLeaveAfter)
            .headTitle(headTitle)
            .positionLevelPayrol(positionLevelPayrol)
            .positionKode(positionKode)
            .flagPositionShowInPayrollInput(flagPositionShowInPayrollInput)
            .ageMin(ageMin)
            .ageRecommended(ageRecommended)
            .ageMax(ageMax)
            .lengthOfServiceMin(lengthOfServiceMin)
            .lengthOfServiceRecommended(lengthOfServiceRecommended)
            .lengthOfExperienceMin(lengthOfExperienceMin)
            .lengthOfExperienceRecommended(lengthOfExperienceRecommended)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .levelId(levelId)
            .startDate(startDate)
            .endDate(endDate)
            .positionGroupId(positionGroupId)
            .tenagaKerja(tenagaKerja)
            .jenisJabatan(jenisJabatan)
            .alias(alias)
            .positionTypeId(positionTypeId)
            .id(id)
            .build();
    }
    @Override
    public HrPosition convertToRecord() {
        return HrPosition.Builder.emptyBuilder()
            .position(position)
            .description(description)
            .positionLevel(positionLevel)
            .disableAppUnderSupervisor(disableAppUnderSupervisor)
            .disableAppDebtScore(disableAppDebtScore)
            .disableAppDivScore(disableAppDivScore)
            .allDepartment(allDepartment)
            .dedlineSchBefore(dedlineSchBefore)
            .dedlineSchAfter(dedlineSchAfter)
            .dedlineSchLeaveBefore(dedlineSchLeaveBefore)
            .dedlineSchLeaveAfter(dedlineSchLeaveAfter)
            .headTitle(headTitle)
            .positionLevelPayrol(positionLevelPayrol)
            .positionKode(positionKode)
            .flagPositionShowInPayrollInput(flagPositionShowInPayrollInput)
            .ageMin(ageMin)
            .ageRecommended(ageRecommended)
            .ageMax(ageMax)
            .lengthOfServiceMin(lengthOfServiceMin)
            .lengthOfServiceRecommended(lengthOfServiceRecommended)
            .lengthOfExperienceMin(lengthOfExperienceMin)
            .lengthOfExperienceRecommended(lengthOfExperienceRecommended)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .levelId(levelId)
            .startDate(startDate)
            .endDate(endDate)
            .positionGroupId(positionGroupId)
            .tenagaKerja(tenagaKerja)
            .jenisJabatan(jenisJabatan)
            .alias(alias)
            .positionTypeId(positionTypeId)
            .id(id)
            .build();
    }
}
