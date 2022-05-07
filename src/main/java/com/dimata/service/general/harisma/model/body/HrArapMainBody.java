package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.core.util.jackson.DateDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.DateSerialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeSerialize;
import com.dimata.service.general.harisma.entity.HrArapMain;
import com.dimata.service.general.harisma.entity.enums.Status;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HrArapMainBody {
    private Long idHrArapMain;
    private String voucherNo;

    @JsonSerialize(converter = DateSerialize.class)
    @JsonDeserialize(converter = DateDeserialize.class)
    private LocalDate voucherDate;
    private Long idContact;
    private Integer numberOfPayment;
    private Long idPerkiraanLawan;
    private Long idPerkiraan;
    private Long idCurrency;
    private Integer counter;
    private Double rate;
    private Double amount;
    private String notaNo;

    @JsonSerialize(converter = DateSerialize.class)
    @JsonDeserialize(converter = DateDeserialize.class)
    private LocalDate notaDate;
    private String description;
    private Integer arapType;
    private Integer arapDocStatus;
    private Integer arapMainStatus;

    @JsonSerialize(converter = TimeSerialize.class)
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime lastUpdate;
    private Long idJurnal;
    private Long idComponentDeduction;
    private Long idEmployee;

    @JsonSerialize(converter = DateSerialize.class)
    @JsonDeserialize(converter = DateDeserialize.class)
    private LocalDate entryDate;
    private Status periodEvery;
    private Status periodEveryDmy;

    @JsonSerialize(converter = DateSerialize.class)
    @JsonDeserialize(converter = DateDeserialize.class)
    private LocalDate startOfPaymentDate;
    private Double paymentAmountPlan;
    private Status periodType;
    private Long idPeriod;

    public static HrArapMainBody formArapMain(HrArapMain ent) {
        var output = new HrArapMainBody();
        output.setIdHrArapMain(ent.id);
        output.setVoucherNo(ent.voucherNo);
        output.setVoucherDate(ent.voucherDate);
        output.setIdContact(ent.idContact.id);
        output.setNumberOfPayment(ent.numberOfPayment);
        output.setIdPerkiraanLawan(ent.idPerkiraanLawan);
        output.setIdPerkiraan(ent.idPerkiraan.id);
        output.setIdCurrency(ent.idCurrency);
        output.setCounter(ent.counter);
        output.setRate(ent.rate);
        output.setAmount(ent.amount);
        output.setNotaNo(ent.notaNo);
        output.setNotaDate(ent.notaDate);
        output.setDescription(ent.description);
        output.setArapType(ent.arapType);
        output.setArapDocStatus(ent.arapDocStatus);
        output.setArapMainStatus(ent.arapMainStatus);
        output.setLastUpdate(ent.lastUpdate);
        output.setIdJurnal(ent.idJurnal);
        output.setIdComponentDeduction(ent.idComponentDeduction);
        output.setIdEmployee(ent.idEmployee.id);
        output.setEntryDate(ent.entryDate);
        output.setPeriodEvery(ent.periodEvery);
        output.setPeriodEveryDmy(ent.periodEveryDmy);
        output.setStartOfPaymentDate(ent.startOfPaymentDate);
        output.setPaymentAmountPlan(ent.paymentAmountPlan);
        output.setPeriodType(ent.periodType);
        output.setIdPeriod(ent.idPeriod);
        return output;
    }

    public HrArapMain updateArapMain(HrArapMain main) {
        main.voucherNo = changeItOrNot(voucherNo, main.voucherNo);
        main.voucherDate = changeItOrNot(voucherDate, main.voucherDate);
        main.idContact.id = changeItOrNot(idContact, main.idContact.id);
        main.numberOfPayment = changeItOrNot(numberOfPayment, main.numberOfPayment);
        main.idPerkiraanLawan = changeItOrNot(idPerkiraanLawan, main.idPerkiraanLawan);
        main.idPerkiraan.id = changeItOrNot(idPerkiraan, main.idPerkiraan.id);
        main.idCurrency = changeItOrNot(idCurrency, main.idCurrency);
        main.counter = changeItOrNot(counter, main.counter);
        main.rate = changeItOrNot(rate, main.rate);
        main.amount = changeItOrNot(amount, main.amount);
        main.notaNo = changeItOrNot(notaNo, main.notaNo);
        main.notaDate = changeItOrNot(notaDate, main.notaDate);
        main.description = changeItOrNot(description, main.description);
        main.arapType = changeItOrNot(arapType, main.arapType);
        main.arapDocStatus = changeItOrNot(arapDocStatus, main.arapDocStatus);
        main.arapMainStatus = changeItOrNot(arapMainStatus, main.arapMainStatus);
        main.lastUpdate = changeItOrNot(lastUpdate, main.lastUpdate);
        main.idJurnal = changeItOrNot(idJurnal, main.idJurnal);
        main.idComponentDeduction = changeItOrNot(idComponentDeduction, main.idComponentDeduction);
        main.idEmployee.id = changeItOrNot(idEmployee, main.idEmployee.id);
        main.entryDate = changeItOrNot(entryDate, main.entryDate);
        main.periodEvery = changeItOrNot(periodEvery, main.periodEvery);
        main.periodEveryDmy = changeItOrNot(periodEveryDmy, main.periodEveryDmy);
        main.startOfPaymentDate = changeItOrNot(startOfPaymentDate, main.startOfPaymentDate);
        main.paymentAmountPlan = changeItOrNot(paymentAmountPlan, main.paymentAmountPlan);
        main.periodType = changeItOrNot(periodType, main.periodType);
        main.idPeriod = changeItOrNot(idPeriod, main.idPeriod);
        return main;
    }
}
