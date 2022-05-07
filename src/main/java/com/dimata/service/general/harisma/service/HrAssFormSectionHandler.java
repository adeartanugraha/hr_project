package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormMain;
import com.dimata.service.general.harisma.entity.HrAssFormSection;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
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

    public List<HrAssFormSectionBody> getAllFormSection() {
        return HrAssFormSection.getAllData()
                .stream()
                .map(HrAssFormSectionBody::fromFormSection)
                .collect(Collectors.toList());
    }

    public HrAssFormSection updateFormSection(HrAssFormSectionBody body) {
        HrAssFormSection formSection = HrAssFormSection.findById(body.getIdHrAssFormSection());
        if (formSection == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateFormSection(formSection);
        return formSection;
    }

    public HrAssFormSectionBody createFormSection(HrAssFormSectionBody body) {
        if (body.getIdAssFormMain() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var formMain = fetchAssFormMain(body.getIdAssFormMain());
        var hrAssFormSection = saveNewFormSection(body, formMain);
        return HrAssFormSectionBody.fromFormSection(hrAssFormSection);
    }

    private HrAssFormMain fetchAssFormMain(long formMainId) {
        return (HrAssFormMain) HrAssFormMain.findByIdOptional(formMainId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrAssFormSection saveNewFormSection(HrAssFormSectionBody body, HrAssFormMain assFormMain) {
        var hrAssFormSection = new HrAssFormSection();
        hrAssFormSection.id = body.getIdHrAssFormSection();
        hrAssFormSection.section = body.getSection();
        hrAssFormSection.description = body.getDescription();
        hrAssFormSection.sectionL2 = body.getSectionL2();
        hrAssFormSection.descriptionL2 = body.getDescriptionL2();
        hrAssFormSection.idAssFormMain = assFormMain;
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
