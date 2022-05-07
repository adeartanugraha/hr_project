package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrAppMain;
import com.dimata.service.general.harisma.entity.HrAppraisal;
import com.dimata.service.general.harisma.entity.HrAssFormItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HrAppraisalBody {
    private Long hrAppraisalId;
    private String empComment;
    private String  assComment;
    private Double rating;
    private Long hrAppMainId;
    private Long assFormItemId;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private BigDecimal realization;
    private String evidence;
    private BigDecimal point;
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

    public HrAppraisal updateAppraisal(HrAppraisal appraisal) {
        appraisal.empComment = changeItOrNot(empComment, appraisal.empComment);
        appraisal.assComment = changeItOrNot(assComment, appraisal.assComment);
        appraisal.rating = changeItOrNot(rating, appraisal.rating);
        appraisal.hrAppMain.id = changeItOrNot(hrAppMainId, appraisal.hrAppMain.id);
        appraisal.hrAssFormItem.id = changeItOrNot(assFormItemId, appraisal.hrAssFormItem.id);
        appraisal.answer1 = changeItOrNot(answer1, appraisal.answer1);
        appraisal.answer2 = changeItOrNot(answer2, appraisal.answer2);
        appraisal.answer3 = changeItOrNot(answer3, appraisal.answer3);
        appraisal.answer4 = changeItOrNot(answer4, appraisal.answer4);
        appraisal.answer5 = changeItOrNot(answer5, appraisal.answer5);
        appraisal.answer6 = changeItOrNot(answer6, appraisal.answer6);
        appraisal.realization = changeItOrNot(realization, appraisal.realization);
        appraisal.evidence = changeItOrNot(evidence, appraisal.evidence);
        appraisal.point = changeItOrNot(point, appraisal.point);
        appraisal.weight = changeItOrNot(weight, appraisal.weight);
        appraisal.kpiId = changeItOrNot(kpiId, appraisal.kpiId);
        return appraisal;
    }
}
