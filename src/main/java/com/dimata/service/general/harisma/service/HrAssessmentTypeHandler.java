package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssessmentType;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.model.body.HrAssessmentTypeBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAssessmentTypeHandler {
    public List<HrAssessmentTypeBody> getAssessment(long id) {
        return HrAssessmentType.findById(id)
                .stream()
                .map(HrAssessmentTypeBody::formAssessment)
                .collect(Collectors.toList());
    }

    public List<HrAssessmentTypeBody> getAllAssessment() {
        return HrAssessmentType.getAllData()
                .stream()
                .map(HrAssessmentTypeBody::formAssessment)
                .collect(Collectors.toList());
    }

    public HrAssessmentType updateAssessment(HrAssessmentTypeBody body) {
        HrAssessmentType assessment = HrAssessmentType.findById(body.getIdHrAssesmentType());
        if (assessment == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateAssessment(assessment);
        return assessment;
    }

    public HrAssessmentTypeBody createAssessment(HrAssessmentTypeBody body) {
        var hrAssesmmentType = saveNewHrAssessmentType(body);
        return HrAssessmentTypeBody.formAssessment(hrAssesmmentType);
    }

    private HrAssessmentType saveNewHrAssessmentType(HrAssessmentTypeBody body) {
        var hrAssessmentType = new HrAssessmentType();
        hrAssessmentType.id = body.getIdHrAssesmentType();
        hrAssessmentType.assessmentType = body.getAssessmentType();
        hrAssessmentType.description = body.getDescription();
        return hrAssessmentType;
    }
}
