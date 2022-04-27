package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

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

    public HrAppMain updateAppMain(HrAppMain appMain) {
        appMain.employeeId = changeItOrNot(idEmployee, appMain.employeeId);
        appMain.empPositionId = changeItOrNot(idEmpPosition, appMain.empPositionId);
        appMain.empDepartmentId = changeItOrNot(idEmpDepartment, appMain.empDepartmentId);
        appMain.dateAssumedPosition = changeItOrNot(dateAssumedPosition, appMain.dateAssumedPosition);
        appMain.dateJoinedHotel = changeItOrNot(dateJoinedHotel, appMain.dateJoinedHotel);
        appMain.assessorId = changeItOrNot(idAssessor, appMain.assessorId);
        appMain.assPositionId = changeItOrNot(idAssPosition, appMain.assPositionId);
        appMain.dateOfAssessment = changeItOrNot(dateOfAssessment, appMain.dateOfAssessment);
        appMain.dateOfLastAssessment = changeItOrNot(dateOfLastAssessment, appMain.dateOfLastAssessment);
        appMain.dateOfNextAssessment = changeItOrNot(dateOfNextAssessment, appMain.dateOfNextAssessment);
        appMain.levelId = changeItOrNot(idLevel, appMain.levelId);
        appMain.totalAss = changeItOrNot(totalAss, appMain.totalAss);
        appMain.totalScore = changeItOrNot(totalScore, appMain.totalScore);
        appMain.scoreAverage = changeItOrNot(scoreAverage, appMain.scoreAverage);
        appMain.divisionHead = changeItOrNot(divisionHead, appMain.divisionHead);
        appMain.empSignDate = changeItOrNot(empSignDate, appMain.empSignDate);
        appMain.assSignDate = changeItOrNot(assSignDate, appMain.assSignDate);
        appMain.divSignDate = changeItOrNot(divSignDate, appMain.divSignDate);
        appMain.approval1Id = changeItOrNot(idApproval1, appMain.approval1Id);
        appMain.timeApproval1 = changeItOrNot(timeApproval1, appMain.timeApproval1);
        appMain.approval2Id = changeItOrNot(idApproval2, appMain.approval2Id);
        appMain.timeApproval2 = changeItOrNot(timeApproval2, appMain.timeApproval2);
        appMain.approval3Id = changeItOrNot(idApproval3, appMain.approval3Id);
        appMain.timeApproval3 = changeItOrNot(timeApproval3, appMain.timeApproval3);
        appMain.approval4Id = changeItOrNot(idApproval4, appMain.approval4Id);
        appMain.timeApproval4 = changeItOrNot(timeApproval4, appMain.timeApproval4);
        appMain.approval5Id = changeItOrNot(idApproval5, appMain.approval5Id);
        appMain.timeApproval5 = changeItOrNot(timeApproval5, appMain.timeApproval5);
        appMain.approval6Id = changeItOrNot(idApproval6, appMain.approval6Id);
        appMain.timeApproval6 = changeItOrNot(timeApproval6, appMain.timeApproval6);
        appMain.dataPeriodFrom = changeItOrNot(dataPeriodForm, appMain.dataPeriodFrom);
        appMain.dataPeriodTo = changeItOrNot(dataPeriodTo, appMain.dataPeriodTo);
        return appMain;
    }
}
