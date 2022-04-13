package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAppraisal;
import lombok.Data;

@Data
public class HrAppraisalBody {
    private Long hrAppraisalId;
    private String empComment;
    private String assComment;
    private Double rating;
    private Long hrAppMainId;
    private Long assFormItemId;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private Double realization;
    private String evidence;
    private Double point;
    private Double weight;
    private Long kpiId;

    public static HrAppraisalBody fromHrAppraisal(HrAppraisal ent) {
        var output = new HrAppraisalBody();
        output.setHrAppraisalId(ent.id);
        output.setEmpComment(ent.empComment);
        output.setAssComment(ent.assComment);
        output.setRating(ent.rating);
        output.setHrAppMainId(ent.hrAppMain.id);
        output.setAssFormItemId(ent.hrAssFormItem.id);
        output.setAnswer1(ent.answer1);
        output.setAnswer2(ent.answer2);
        output.setAnswer3(ent.answer3);
        output.setAnswer4(ent.answer4);
        output.setAnswer5(ent.answer5);
        output.setAnswer6(ent.answer6);
        output.setRealization(ent.realization);
        output.setEvidence(ent.evidence);
        output.setPoint(ent.point);
        output.setWeight(ent.weight);
        output.setKpiId(ent.kpiId);
        return output;
    }
}
