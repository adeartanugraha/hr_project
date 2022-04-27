package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormMain;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.model.body.HrAssFormMainBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAssFormMainHandler {
    public List<HrAssFormMainBody> getFormMain(long id) {
        return HrAssFormMain.findById(id)
                .stream()
                .map(HrAssFormMainBody::formFormMain)
                .collect(Collectors.toList());
    }

    public List<HrAssFormMainBody> getAllFormMain() {
        return HrAssFormMain.getAllData()
                .stream()
                .map(HrAssFormMainBody::formFormMain)
                .collect(Collectors.toList());
    }

    public HrAssFormMain updateFormMain(HrAssFormMainBody body) {
        HrAssFormMain formMain = HrAssFormMain.findById(body.getIdHrAssFormMain());
        if (formMain == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateFormMain(formMain);
        return formMain;
    }

    public HrAssFormMainBody createFormMain(HrAssFormMainBody body) {
        var hrAssFormMain = saveNewFormMain(body);
        return HrAssFormMainBody.formFormMain(hrAssFormMain);
    }

    private HrAssFormMain saveNewFormMain(HrAssFormMainBody body) {
        var hrAssFormMain = new HrAssFormMain();
        hrAssFormMain.id = body.getIdHrAssFormMain();
        hrAssFormMain.groupRankId = body.getIdGroupRank();
        hrAssFormMain.title = body.getTitle();
        hrAssFormMain.subtitle = body.getSubtitle();
        hrAssFormMain.titleL2 = body.getTitleL2();
        hrAssFormMain.subtitleL2 = body.getSubtitleL2();
        hrAssFormMain.mainData = body.getMainData();
        hrAssFormMain.note = body.getNote();
        hrAssFormMain.persist();
        return hrAssFormMain;
    }
}
