package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAppMain;
import com.dimata.service.general.harisma.entity.HrAppraisal;
import com.dimata.service.general.harisma.entity.HrAssFormItem;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAppraisalBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppraisalHandler {
    public List<HrAppraisalBody> getHrAppraisal(long id) {
        return HrAppraisal.findById(id)
                .stream()
                .map(HrAppraisalBody::fromHrAppraisal)
                .collect(Collectors.toList());
    }

    public List<HrAppraisalBody> getAllHrAppraisal() {
        return HrAppraisal.getAllData()
                .stream()
                .map(HrAppraisalBody::fromHrAppraisal)
                .collect(Collectors.toList());
    }

    public HrAppraisal updateAppraisal(HrAppraisalBody body) {
        HrAppraisal appraisal = HrAppraisal.findById(body.getHrAppraisalId());
        if (appraisal == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND, "Data not found");
        }
        body.updateAppraisal(appraisal);
        return appraisal;
    }

    public HrAppraisalBody createAppraisal(HrAppraisalBody body) {
        if (body.getHrAppMainId() == null || body.getAssFormItemId() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var appMain = fetchAppMain(body.getHrAppMainId());
        var assFormItem = fetchAssFormItem(body.getAssFormItemId());
        var hrAppraisal = saveNewHrAppraisal(body, appMain, assFormItem);
        return HrAppraisalBody.fromHrAppraisal(hrAppraisal);
    }

    private HrAppMain fetchAppMain(long appMainId) {
        return (HrAppMain) HrAppMain.findByIdOptional(appMainId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrAssFormItem fetchAssFormItem(long assFormItem) {
        return (HrAssFormItem) HrAssFormItem.findByIdOptional(assFormItem)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrAppraisal saveNewHrAppraisal(HrAppraisalBody body, HrAppMain appMain, HrAssFormItem assFormItem) {
        var hrAppraisal = new HrAppraisal();
        hrAppraisal.id = body.getHrAppraisalId();
        hrAppraisal.empComment = body.getEmpComment();
        hrAppraisal.assComment = body.getAssComment();
        hrAppraisal.rating = body.getRating();
        hrAppraisal.hrAppMain = appMain;
        hrAppraisal.hrAssFormItem = assFormItem;
        hrAppraisal.answer1 = body.getAnswer1();
        hrAppraisal.answer2 = body.getAnswer2();
        hrAppraisal.answer3 = body.getAnswer3();
        hrAppraisal.answer4 = body.getAnswer4();
        hrAppraisal.answer5 = body.getAnswer5();
        hrAppraisal.answer6 = body.getAnswer6();
        hrAppraisal.realization = body.getRealization();
        hrAppraisal.evidence = body.getEvidence();
        hrAppraisal.point = body.getPoint();
        hrAppraisal.weight = body.getWeight();
        hrAppraisal.kpiId = body.getKpiId();
        hrAppraisal.persist();
        return hrAppraisal;
    }
}
