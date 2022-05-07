package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrArapItem;
import com.dimata.service.general.harisma.entity.HrArapMain;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrArapItemBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrArapItemHandler {
    public List<HrArapItemBody> getHrArapItem(long id) {
        return HrArapItem.findById(id)
                .stream()
                .map(HrArapItemBody::formArapItem)
                .collect(Collectors.toList());
    }

    public List<HrArapItemBody> getAllArapIten() {
        return HrArapItem.getAllData()
                .stream()
                .map(HrArapItemBody::formArapItem)
                .collect(Collectors.toList());
    }

    public HrArapItem updateArapItem(HrArapItemBody body) {
        HrArapItem item = HrArapItem.findById(body.getIdHrArapItem());
        if (item == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateArapItem(item);
        return item;
    }

    public HrArapItemBody createArapItem(HrArapItemBody body) {
        if (body.getIdArapMain() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var arapMain = fetchArapMain(body.getIdArapMain());
        var hrArapItem = saveNewItem(body, arapMain);
        return HrArapItemBody.formArapItem(hrArapItem);
    }

    private HrArapMain fetchArapMain(long arapMainId) {
        return (HrArapMain) HrArapMain.findByIdOptional(arapMainId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrArapItem saveNewItem(HrArapItemBody body, HrArapMain arapMain) {
        var hrAppItem = new HrArapItem();
        hrAppItem.id = body.getIdHrArapItem();
        hrAppItem.idArapMain = arapMain;
        hrAppItem.angsuran = body.getAngsuran();
        hrAppItem.dueDate = body.getDueDate();
        hrAppItem.description = body.getDescription();
        hrAppItem.leftToPay = body.getLeftToPay();
        hrAppItem.rate = body.getRate();
        hrAppItem.idReceiveAktiva = body.getIdReceiveAktiva();
        hrAppItem.idSellingAktiva = body.getIdSellingAktiva();
        hrAppItem.idCurrency = body.getIdCurrency();
        hrAppItem.arapItemStatus = body.getArapItemStatus();
        hrAppItem.lastUpdate = body.getLastUpdate();
        hrAppItem.persist();
        return hrAppItem;
    }
}
