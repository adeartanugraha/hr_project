package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAssFormSection;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HrAssFormSectionBody {
    private Long idHrAssFormSection;
    private String section;
    private String description;
    private String sectionL2;
    private String descriptionL2;
    private Long idAssFormMain;
    private Integer orderNumber;
    private Integer typeSection;
    private Integer page;
    private BigDecimal weightPoint;
    private Long idPointEvaluation;
    private Long idPredicateEvaluation;

    public static HrAssFormSectionBody fromFormSection(HrAssFormSection ent) {
        var output = new HrAssFormSectionBody();
        output.setIdHrAssFormSection(ent.id);
        output.setSection(ent.section);
        output.setDescription(ent.description);
        output.setSectionL2(ent.sectionL2);
        output.setDescriptionL2(ent.descriptionL2);
        output.setIdAssFormMain(ent.idAssFormMain);
        output.setOrderNumber(ent.orderNumber);
        output.setTypeSection(ent.typeSection);
        output.setPage(ent.page);
        output.setWeightPoint(ent.weightPoint);
        output.setIdPointEvaluation(ent.idPointEvaluation);
        output.setIdPredicateEvaluation(ent.idPredicateEvaluation);
        return output;
    }
}
