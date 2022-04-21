package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAssFormMain;
import lombok.Data;

@Data
public class HrAssFormMainBody {
    private Long idHrAssFormMain;
    private Long idGroupRank;
    private String title;
    private String subtitle;
    private String titleL2;
    private String subtitleL2;
    private String mainData;
    private String note;

    public static HrAssFormMainBody formFormMain(HrAssFormMain ent) {
        var output = new HrAssFormMainBody();
        output.setIdHrAssFormMain(ent.id);
        output.setIdGroupRank(ent.groupRankId);
        output.setTitle(ent.title);
        output.setSubtitle(ent.subtitle);
        output.setTitleL2(ent.titleL2);
        output.setSubtitleL2(ent.subtitleL2);
        output.setMainData(ent.mainData);
        output.setNote(ent.note);
        return output;
    }
}
