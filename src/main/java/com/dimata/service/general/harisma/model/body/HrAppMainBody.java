package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAppMain;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HrAppMainBody {
    private Long hrAppMainId;
    private Long idEmployee;
    private Long idEmpPosition;
    private Long idEmpDepartment;
    private LocalDate dateAssumedPosition;
    private LocalDate dateJoinedHotel;
    private Long idAssessor;
    private Long idAssPosition;
    private LocalDate dateOfAssessment;
    private LocalDate dateOfLastAssessment;
    private LocalDate dateOfNextAssessment;
    private Long idLevel;
    private Integer totalAss;
    private Double totalScore;
    private Double scoreAverage;
    private Long divisionHead;
    private LocalDate empSignDate;
    private LocalDate assSignDate;
    private LocalDate divSignDate;
    private Long idApproval1;
    private LocalDateTime timeApproval1;
    private Long idApproval2;
    private LocalDateTime timeApproval2;
    private Long idApproval3;
    private LocalDateTime timeApproval3;
    private Long idApproval4;
    private LocalDateTime timeApproval4;
    private Long idApproval5;
    private LocalDateTime timeApproval5;
    private Long idApproval6;
    private LocalDateTime timeApproval6;
    private LocalDate dataPeriodForm;
    private LocalDate dataPeriodTo;

    public static HrAppMainBody formHrMain(HrAppMain ent) {
        var output = new HrAppMainBody();
        output.setHrAppMainId(ent.id);
        output.setIdEmployee(ent.employeeId);
        output.setIdEmpPosition(ent.empPositionId);
        output.setIdEmpDepartment(ent.empDepartmentId);
        output.setDateAssumedPosition(ent.dateAssumedPosition);
        output.setDateJoinedHotel(ent.dateJoinedHotel);
        output.setIdAssessor(ent.assessorId);
        output.setIdAssPosition(ent.assPositionId);
        output.setDateOfAssessment(ent.dateOfAssessment);
        output.setDateOfLastAssessment(ent.dateOfLastAssessment);
        output.setDateOfNextAssessment(ent.dateOfNextAssessment);
        output.setIdLevel(ent.levelId);
        output.setTotalAss(ent.totalAss);
        output.setTotalScore(ent.totalScore);
        output.setScoreAverage(ent.scoreAverage);
        output.setDivisionHead(ent.divisionHead);
        output.setEmpSignDate(ent.empSignDate);
        output.setAssSignDate(ent.assSignDate);
        output.setDivSignDate(ent.divSignDate);
        output.setIdApproval1(ent.approval1Id);
        output.setTimeApproval1(ent.timeApproval1);
        output.setIdApproval1(ent.approval2Id);
        output.setTimeApproval1(ent.timeApproval2);
        output.setIdApproval1(ent.approval3Id);
        output.setTimeApproval1(ent.timeApproval3);
        output.setIdApproval1(ent.approval4Id);
        output.setTimeApproval1(ent.timeApproval4);
        output.setIdApproval1(ent.approval5Id);
        output.setTimeApproval1(ent.timeApproval5);
        output.setIdApproval1(ent.approval6Id);
        output.setTimeApproval1(ent.timeApproval6);
        output.setDataPeriodForm(ent.dataPeriodFrom);
        output.setDataPeriodTo(ent.dataPeriodTo);
        return output;
    }
}
