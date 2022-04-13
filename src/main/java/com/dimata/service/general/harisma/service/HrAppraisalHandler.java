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
    public HrAppraisalBody updateAppraisal(HrAppraisalBody body) {
        if (body.getHrAppraisalId() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var AppMain = fetchAppMain(body.getHrAppMainId());
        var formItem = fetchAssFormItem(body.getAssFormItemId());
        var hrAppraisal = saveNewHrAppraisal(body, AppMain, formItem);
        return HrAppraisalBody.fromHrAppraisal(hrAppraisal);
    }

    public List<HrAppraisalBody> getAllHrAppraisal(long appraisalId) {
        return HrAppraisal.findById(appraisalId)
                .stream()
                .map(HrAppraisalBody::fromHrAppraisal)
                .collect(Collectors.toList());
    }

    private HrAppMain fetchAppMain(long baseId) {
        return (HrAppMain) HrAppMain.findByIdOptional(baseId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.CNT_NF));
    }

    private HrAssFormItem fetchAssFormItem(long baseId) {
        return (HrAssFormItem) HrAssFormItem.findByIdOptional(baseId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.CNT_NF));
    }

    private HrAppraisal saveNewHrAppraisal(HrAppraisalBody body, HrAppMain hrAppMain, HrAssFormItem hrAssFormItem) {
        var hrAppraisal = new HrAppraisal();
        hrAppraisal.empComment = body.getEmpComment();
        hrAppraisal.assComment = body.getAssComment();
        hrAppraisal.rating = body.getRating();
        hrAppraisal.hrAppMain = hrAppMain;
        hrAppraisal.hrAssFormItem = hrAssFormItem;
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
        return hrAppraisal;
    }
}
