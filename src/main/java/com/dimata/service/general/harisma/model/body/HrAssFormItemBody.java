package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.entity.HrAssFormItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HrAssFormItemBody {
    private Long idHrAssFormItem;
    private String title;
    private String titleL2;
    private String itemPoin1;
    private String itemPoin2;
    private String itemPoin3;
    private String itemPoin4;
    private String itemPoin5;
    private String itemPoin6;
    private Integer type;
    private Integer orderNumber;
    private Integer number;
    private Integer page;
    private Integer height;
    private Long idAssFormSection;
    private Long idKpiList;
    private BigDecimal weightPoint;
    private BigDecimal kpiTarget;
    private String kpiUnit;
    private String kpiNote;
    private String formula;

    public static HrAssFormItemBody formHrAssFormItem(HrAssFormItem ent) {
        var output = new HrAssFormItemBody();
        output.setIdHrAssFormItem(ent.id);
        output.setTitle(ent.title);
        output.setTitleL2(ent.titleL2);
        output.setItemPoin1(ent.itemPoin1);
        output.setItemPoin2(ent.itemPoin2);
        output.setItemPoin3(ent.itemPoin3);
        output.setItemPoin4(ent.itemPoin4);
        output.setItemPoin5(ent.itemPoin5);
        output.setItemPoin6(ent.itemPoin6);
        output.setType(ent.type);
        output.setOrderNumber(ent.orderNumber);
        output.setNumber(ent.number);
        output.setPage(ent.page);
        output.setHeight(ent.height);
        output.setIdAssFormSection(ent.idAssFormSection);
        output.setIdKpiList(ent.idKpiList);
        output.setWeightPoint(ent.weightPoint);
        output.setKpiTarget(ent.kpiTarget);
        output.setKpiUnit(ent.kpiUnit);
        output.setKpiNote(ent.kpiNote);
        output.setFormula(ent.formula);
        return output;
    }
}
