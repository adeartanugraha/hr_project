package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormMain;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
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

    public HrAssFormMainBody updateFormMain(HrAssFormMainBody body) {
        if (body.getIdHrAssFormMain() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var hrAssFormMain = saveNewUpdateFormMain(body);
        return HrAssFormMainBody.formFormMain(hrAssFormMain);
    }

    private HrAssFormMain saveNewUpdateFormMain(HrAssFormMainBody body) {
        var hrAssFormMain = new HrAssFormMain();
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
