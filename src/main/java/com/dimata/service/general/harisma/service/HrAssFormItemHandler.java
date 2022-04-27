package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAssFormItem;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAssFormItemBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAssFormItemHandler {
    public List<HrAssFormItemBody> getHrFormItem(long id) {
        return HrAssFormItem.findById(id)
                .stream()
                .map(HrAssFormItemBody::formHrAssFormItem)
                .collect(Collectors.toList());
    }

    public List<HrAssFormItemBody> getAllHrFormItem() {
        return HrAssFormItem.getAllData()
                .stream()
                .map(HrAssFormItemBody::formHrAssFormItem)
                .collect(Collectors.toList());
    }

    public HrAssFormItem updateFormItem(HrAssFormItemBody body) {
        HrAssFormItem formItem = HrAssFormItem.findById(body.getIdAssFormSection());
        if (formItem == null) {
            throw new FormatException(ExceptionCode.DATA_NOT_FOUND, "Data not found");
        }
        body.updateFormItem(formItem);
        return formItem;
    }

    public HrAssFormItemBody createFormItem(HrAssFormItemBody body) {
        var hrAssFormItem = saveNewForm(body);
        return HrAssFormItemBody.formHrAssFormItem(hrAssFormItem);
    }

    private HrAssFormItem saveNewForm(HrAssFormItemBody body) {
        var hrAssFormItem = new HrAssFormItem();
        hrAssFormItem.id = body.getIdHrAssFormItem();
        hrAssFormItem.title = body.getTitle();
        hrAssFormItem.titleL2 = body.getTitleL2();
        hrAssFormItem.itemPoin1 = body.getItemPoin1();
        hrAssFormItem.itemPoin2 = body.getItemPoin2();
        hrAssFormItem.itemPoin3 = body.getItemPoin3();
        hrAssFormItem.itemPoin4 = body.getItemPoin4();
        hrAssFormItem.itemPoin5 = body.getItemPoin5();
        hrAssFormItem.itemPoin6 = body.getItemPoin6();
        hrAssFormItem.type = body.getType();
        hrAssFormItem.orderNumber = body.getOrderNumber();
        hrAssFormItem.number = body.getNumber();
        hrAssFormItem.page = body.getPage();
        hrAssFormItem.height = body.getHeight();
        hrAssFormItem.idAssFormSection = body.getIdAssFormSection();
        hrAssFormItem.idKpiList = body.getIdKpiList();
        hrAssFormItem.weightPoint = body.getWeightPoint();
        hrAssFormItem.kpiTarget = body.getKpiTarget();
        hrAssFormItem.kpiUnit = body.getKpiUnit();
        hrAssFormItem.kpiNote = body.getKpiNote();
        hrAssFormItem.formula = body.getFormula();
        hrAssFormItem.persist();
        return hrAssFormItem;
    }
}
