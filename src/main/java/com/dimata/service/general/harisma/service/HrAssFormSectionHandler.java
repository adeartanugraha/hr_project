package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormSection;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAssFormSectionBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAssFormSectionHandler {
    public List<HrAssFormSectionBody> getFormSection(long id) {
        return HrAssFormSection.findById(id)
                .stream()
                .map(HrAssFormSectionBody::fromFormSection)
                .collect(Collectors.toList());
    }

    public HrAssFormSectionBody updateFormSection(HrAssFormSectionBody body) {
        if (body.getIdHrAssFormSection() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var hrAssFormSection = saveNewUpdateFormSection(body);
        return HrAssFormSectionBody.fromFormSection(hrAssFormSection);
    }

    private HrAssFormSection saveNewUpdateFormSection(HrAssFormSectionBody body) {
        var hrAssFormSection = new HrAssFormSection();
        hrAssFormSection.section = body.getSection();
        hrAssFormSection.description = body.getDescription();
        hrAssFormSection.sectionL2 = body.getSectionL2();
        hrAssFormSection.descriptionL2 = body.getDescriptionL2();
        hrAssFormSection.idAssFormMain = body.getIdAssFormMain();
        hrAssFormSection.orderNumber = body.getOrderNumber();
        hrAssFormSection.typeSection = body.getTypeSection();
        hrAssFormSection.page = body.getPage();
        hrAssFormSection.weightPoint = body.getWeightPoint();
        hrAssFormSection.idPointEvaluation = body.getIdHrAssFormSection();
        hrAssFormSection.idPredicateEvaluation = body.getIdPredicateEvaluation();
        hrAssFormSection.persist();
        return hrAssFormSection;
    }
}
