package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrAssessmentType;
import lombok.Data;

@Data
public class HrAssessmentTypeBody {
    private Long idHrAssesmentType;
    private String assessmentType;
    private String description;

    public static HrAssessmentTypeBody formAssessment(HrAssessmentType ent) {
        var output = new HrAssessmentTypeBody();
        output.setIdHrAssesmentType(ent.id);
        output.setAssessmentType(ent.assessmentType);
        output.setDescription(ent.description);
        return output;
    }

    public HrAssessmentType updateAssessment(HrAssessmentType assessment) {
        assessment.assessmentType = changeItOrNot(assessmentType, assessment.assessmentType);
        assessment.description = changeItOrNot(description, assessment.description);
        return assessment;
    }
}
