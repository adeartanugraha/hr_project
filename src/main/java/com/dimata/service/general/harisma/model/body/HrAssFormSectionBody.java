package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

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

    public HrAssFormSection updateFormSection(HrAssFormSection formSection) {
        formSection.section = changeItOrNot(section, formSection.section);
        formSection.description = changeItOrNot(description, formSection.description);
        formSection.sectionL2 = changeItOrNot(sectionL2, formSection.sectionL2);
        formSection.descriptionL2 = changeItOrNot(descriptionL2, formSection.descriptionL2);
        formSection.idAssFormMain = changeItOrNot(idAssFormMain, formSection.idAssFormMain);
        formSection.orderNumber = changeItOrNot(orderNumber, formSection.orderNumber);
        formSection.typeSection = changeItOrNot(typeSection, formSection.typeSection);
        formSection.page = changeItOrNot(page, formSection.page);
        formSection.weightPoint = changeItOrNot(weightPoint, formSection.weightPoint);
        formSection.idPointEvaluation = changeItOrNot(idPointEvaluation, formSection.idPointEvaluation);
        formSection.idPredicateEvaluation = changeItOrNot(idPredicateEvaluation, formSection.idPointEvaluation);
        return formSection;
    }
}
