package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.core.rest.CommonParam;
import com.dimata.service.general.harisma.entity.HrAppMain;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAppMainBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppMainHandler {
    public List<HrAppMainBody> getHrAppMain(long id) {
        return HrAppMain.findById(id)
                .stream()
                .map(HrAppMainBody::formHrMain)
                .collect(Collectors.toList());
    }

    public List<HrAppMainBody> getAllHrAppMain() {
        return HrAppMain.getAllData()
                .stream()
                .map(HrAppMainBody::formHrMain)
                .collect(Collectors.toList());
    }

    public HrAppMain updateAppMain(HrAppMainBody body) {
        HrAppMain main = HrAppMain.findById(body.getHrAppMainId());
        if (main == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND, "Data not found");
        }
        body.updateAppMain(main);
        return main;
    }

    public HrAppMainBody createAppMain(HrAppMainBody body) {
        var hrAppMain = saveNewAppMain(body);
        return HrAppMainBody.formHrMain(hrAppMain);
    }

    private HrAppMain saveNewAppMain(HrAppMainBody body) {
        var hrAppMain = new HrAppMain();
        hrAppMain.id = body.getHrAppMainId();
        hrAppMain.employeeId = body.getIdEmployee();
        hrAppMain.empPositionId = body.getIdEmpPosition();
        hrAppMain.empDepartmentId = body.getIdEmpDepartment();
        hrAppMain.dateAssumedPosition = body.getDateAssumedPosition();
        hrAppMain.dateJoinedHotel = body.getDateJoinedHotel();
        hrAppMain.assessorId = body.getIdAssessor();
        hrAppMain.assPositionId = body.getIdAssPosition();
        hrAppMain.dateOfAssessment = body.getDateOfAssessment();
        hrAppMain.dateOfLastAssessment = body.getDateOfLastAssessment();
        hrAppMain.dateOfNextAssessment = body.getDateOfNextAssessment();
        hrAppMain.levelId = body.getIdLevel();
        hrAppMain.totalAss = body.getTotalAss();
        hrAppMain.totalScore = body.getTotalScore();
        hrAppMain.scoreAverage = body.getScoreAverage();
        hrAppMain.divisionHead = body.getDivisionHead();
        hrAppMain.empSignDate = body.getEmpSignDate();
        hrAppMain.assSignDate = body.getAssSignDate();
        hrAppMain.divSignDate = body.getDivSignDate();
        hrAppMain.approval1Id = body.getIdApproval1();
        hrAppMain.timeApproval1 = body.getTimeApproval1();
        hrAppMain.approval2Id = body.getIdApproval2();
        hrAppMain.timeApproval2 = body.getTimeApproval2();
        hrAppMain.approval3Id = body.getIdApproval3();
        hrAppMain.timeApproval3 = body.getTimeApproval3();
        hrAppMain.approval4Id = body.getIdApproval4();
        hrAppMain.timeApproval4 = body.getTimeApproval4();
        hrAppMain.approval5Id = body.getIdApproval5();
        hrAppMain.timeApproval5 = body.getTimeApproval5();
        hrAppMain.approval6Id = body.getIdApproval6();
        hrAppMain.timeApproval6 = body.getTimeApproval6();
        hrAppMain.dataPeriodFrom = body.getDataPeriodForm();
        hrAppMain.dataPeriodTo = body.getDataPeriodTo();
        hrAppMain.persist();
        return hrAppMain;
    }
}
