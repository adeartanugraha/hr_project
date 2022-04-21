package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAppraisal;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAppraisalBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppraisalHandler {
    public HrAppraisalBody updateAppraisal(HrAppraisalBody body) {
        if (body.getHrAppraisalId() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
//        var AppMain = fetchAppMain(body.getHrAppMainId());
//        var formItem = fetchAssFormItem(body.getAssFormItemId());
        var hrAppraisal = saveNewUpdateHrAppraisal(body);
        return HrAppraisalBody.fromHrAppraisal(hrAppraisal);
    }

    public List<HrAppraisalBody> getHrAppraisal(long appraisalId) {
        return HrAppraisal.findById(appraisalId)
                .stream()
                .map(HrAppraisalBody::fromHrAppraisal)
                .collect(Collectors.toList());
    }

    public HrAppraisalBody createAppraisal(HrAppraisalBody body) {
//        if (body.getHrAppraisalId() == null) {
//            throw new FormatException(ExceptionCode.F_NV);
//        }
        var hrAppraisal = saveNewHrAppraisal(body);
//        hrAppraisal.persist();
        return HrAppraisalBody.fromHrAppraisal(hrAppraisal);
    }

//    private HrAppMain fetchAppMain(long baseId) {
//        return (HrAppMain) HrAppMain.findByIdOptional(baseId)
//                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.CNT_NF));
//    }
//
//    private HrAssFormItem fetchAssFormItem(long baseId) {
//        return (HrAssFormItem) HrAssFormItem.findByIdOptional(baseId)
//                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.CNT_NF));
//    }

    private HrAppraisal saveNewUpdateHrAppraisal(HrAppraisalBody body) {
        var hrAppraisal = new HrAppraisal();
        hrAppraisal.empComment = body.getEmpComment();
        hrAppraisal.assComment = body.getAssComment();
        hrAppraisal.rating = body.getRating();
        hrAppraisal.hrAppMain = body.getHrAppMainId();
        hrAppraisal.hrAssFormItem = body.getAssFormItemId();
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

    private HrAppraisal saveNewHrAppraisal(HrAppraisalBody body) {
        var hrAppraisal = new HrAppraisal();
        hrAppraisal.id = body.getHrAppraisalId();
        hrAppraisal.empComment = body.getEmpComment();
        hrAppraisal.assComment = body.getAssComment();
        hrAppraisal.rating = body.getRating();
        hrAppraisal.hrAppMain = body.getHrAppMainId();
        hrAppraisal.hrAssFormItem = body.getAssFormItemId();
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
