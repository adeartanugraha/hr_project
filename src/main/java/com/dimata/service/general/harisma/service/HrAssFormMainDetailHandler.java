package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormMain;
import com.dimata.service.general.harisma.entity.HrAssFormMainDetail;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAssFormMainDetailBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAssFormMainDetailHandler {
    public List<HrAssFormMainDetailBody> getFormMainDetail(long id) {
        return HrAssFormMainDetail.findById(id)
                .stream()
                .map(HrAssFormMainDetailBody::formMainDetailBody)
                .collect(Collectors.toList());
    }

    public List<HrAssFormMainDetailBody> getAllFormMainDetail() {
        return HrAssFormMainDetail.getAllData()
                .stream()
                .map(HrAssFormMainDetailBody::formMainDetailBody)
                .collect(Collectors.toList());
    }

    public HrAssFormMainDetail updateFormMainDetail(HrAssFormMainDetailBody body) {
        HrAssFormMainDetail formMainDetail = HrAssFormMainDetail.findById(body.getIdAssFormMainDetail());
        if (formMainDetail == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateDetail(formMainDetail);
        return formMainDetail;
    }

    public HrAssFormMainDetailBody createFormMainDetail(HrAssFormMainDetailBody body) {
        if (body.getIdAssFormMainDetail() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var formMain = fetchFormMain(body.getIdAssFormMainDetail());
        var hrAssFormMain = saveNewHrAssFormMainDetail(body, formMain);
        return HrAssFormMainDetailBody.formMainDetailBody(hrAssFormMain);
    }

    private HrAssFormMain fetchFormMain(long formMainId) {
        return (HrAssFormMain) HrAssFormMain.findByIdOptional(formMainId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrAssFormMainDetail saveNewHrAssFormMainDetail(HrAssFormMainDetailBody body, HrAssFormMain formMain) {
        var hrAssFormMainDetail = new HrAssFormMainDetail();
        hrAssFormMainDetail.id.id = formMain.id;
        hrAssFormMainDetail.idGroupRank = body.getIdGroupRank();
        hrAssFormMainDetail.persist();
        return hrAssFormMainDetail;
    }
}
