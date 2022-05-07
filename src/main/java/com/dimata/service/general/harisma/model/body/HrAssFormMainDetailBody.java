package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrAssFormMainDetail;
import lombok.Data;

@Data
public class HrAssFormMainDetailBody {
    private Long idAssFormMainDetail;
    private Long idGroupRank;

    public static HrAssFormMainDetailBody formMainDetailBody(HrAssFormMainDetail ent) {
        var output = new HrAssFormMainDetailBody();
        output.setIdAssFormMainDetail(ent.id.id);
        output.setIdGroupRank(ent.idGroupRank);
        return output;
    }

    public HrAssFormMainDetail updateDetail(HrAssFormMainDetail detail) {
        detail.id.id = changeItOrNot(idAssFormMainDetail, detail.id.id);
        detail.idGroupRank = changeItOrNot(idGroupRank, detail.idGroupRank);
        return detail;
    }
}
