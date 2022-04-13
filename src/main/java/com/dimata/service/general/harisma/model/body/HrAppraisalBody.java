package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAppraisal;
import lombok.Data;
import org.hibernate.type.TextType;

import java.math.BigDecimal;

@Data
public class HrAppraisalBody {
    private Long hrAppraisalId;
    private TextType empComment;
    private TextType assComment;
    private Double rating;
    private Long hrAppMainId;
    private Long assFormItemId;
    private TextType answer1;
    private TextType answer2;
    private TextType answer3;
    private TextType answer4;
    private TextType answer5;
    private TextType answer6;
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
        output.setHrAppMainId(ent.hrAppMain);
        output.setAssFormItemId(ent.hrAssFormItem);
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
