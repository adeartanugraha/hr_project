package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

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

    public HrAssFormMain updateFormMain(HrAssFormMain formMain) {
        formMain.groupRankId = changeItOrNot(idGroupRank, formMain.groupRankId);
        formMain.title = changeItOrNot(title, formMain.title);
        formMain.subtitle = changeItOrNot(subtitle, formMain.subtitle);
        formMain.titleL2 = changeItOrNot(titleL2, formMain.titleL2);
        formMain.subtitleL2 = changeItOrNot(subtitleL2, formMain.subtitleL2);
        formMain.mainData = changeItOrNot(mainData, formMain.mainData);
        formMain.note = changeItOrNot(note, formMain.note);
        return formMain;
    }
}
