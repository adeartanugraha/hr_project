package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

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

    public HrAssFormItem updateFormItem(HrAssFormItem formItem) {
        formItem.title = changeItOrNot(title, formItem.title);
        formItem.titleL2 = changeItOrNot(titleL2, formItem.titleL2);
        formItem.itemPoin1 = changeItOrNot(itemPoin1, formItem.itemPoin1);
        formItem.itemPoin2 = changeItOrNot(itemPoin2, formItem.itemPoin2);
        formItem.itemPoin3 = changeItOrNot(itemPoin3, formItem.itemPoin3);
        formItem.itemPoin4 = changeItOrNot(itemPoin4, formItem.itemPoin4);
        formItem.itemPoin5 = changeItOrNot(itemPoin5, formItem.itemPoin5);
        formItem.itemPoin6 = changeItOrNot(itemPoin6, formItem.itemPoin6);
        formItem.type = changeItOrNot(type, formItem.type);
        formItem.orderNumber = changeItOrNot(orderNumber, formItem.orderNumber);
        formItem.number = changeItOrNot(number, formItem.number);
        formItem.page = changeItOrNot(page, formItem.page);
        formItem.height = changeItOrNot(height, formItem.height);
        formItem.idAssFormSection = changeItOrNot(idAssFormSection, formItem.idAssFormSection);
        formItem.idKpiList = changeItOrNot(idKpiList, formItem.idKpiList);
        formItem.weightPoint = changeItOrNot(weightPoint, formItem.weightPoint);
        formItem.kpiTarget = changeItOrNot(kpiTarget, formItem.kpiTarget);
        formItem.kpiUnit = changeItOrNot(kpiUnit, formItem.kpiUnit);
        formItem.kpiNote = changeItOrNot(kpiNote, formItem.kpiNote);
        formItem.formula = changeItOrNot(formula, formItem.formula);
        return formItem;
    }
}
