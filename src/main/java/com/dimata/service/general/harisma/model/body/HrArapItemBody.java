package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.core.util.jackson.DateDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.DateSerialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeSerialize;
import com.dimata.service.general.harisma.entity.HrArapItem;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HrArapItemBody {
    private Long idHrArapItem;
    private Long idArapMain;
    private Double angsuran;
    @JsonSerialize(converter = DateSerialize.class)
    @JsonDeserialize(converter = DateDeserialize.class)
    private LocalDate dueDate;
    private String description;
    private Double leftToPay;
    private Double rate;
    private Long idReceiveAktiva;
    private Long idSellingAktiva;
    private Long idCurrency;
    private Integer arapItemStatus;

    @JsonSerialize(converter = TimeSerialize.class)
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime lastUpdate;

    public static HrArapItemBody formArapItem(HrArapItem ent) {
        var output = new HrArapItemBody();
        output.setIdHrArapItem(ent.id);
        output.setIdArapMain(ent.idArapMain.id);
        output.setAngsuran(ent.angsuran);
        output.setDueDate(ent.dueDate);
        output.setDescription(ent.description);
        output.setLeftToPay(ent.leftToPay);
        output.setRate(ent.rate);
        output.setIdReceiveAktiva(ent.idReceiveAktiva);
        output.setIdSellingAktiva(ent.idSellingAktiva);
        output.setIdCurrency(ent.idCurrency);
        output.setArapItemStatus(ent.arapItemStatus);
        output.setLastUpdate(ent.lastUpdate);
        return output;
    }

    public HrArapItem updateArapItem(HrArapItem item) {
        item.idArapMain.id = changeItOrNot(idArapMain, item.idArapMain.id);
        item.angsuran = changeItOrNot(angsuran, item.angsuran);
        item.dueDate = changeItOrNot(dueDate, item.dueDate);
        item.description = changeItOrNot(description, item.description);
        item.leftToPay = changeItOrNot(leftToPay, item.leftToPay);
        item.rate = changeItOrNot(rate, item.rate);
        item.idReceiveAktiva = changeItOrNot(idReceiveAktiva, item.idReceiveAktiva);
        item.idSellingAktiva = changeItOrNot(idSellingAktiva, item.idSellingAktiva);
        item.idCurrency = changeItOrNot(idCurrency, item.idCurrency);
        item.arapItemStatus = changeItOrNot(arapItemStatus, item.arapItemStatus);
        item.lastUpdate = changeItOrNot(lastUpdate, item.lastUpdate);
        return item;
    }
}
