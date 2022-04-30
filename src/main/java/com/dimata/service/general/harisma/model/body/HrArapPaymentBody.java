package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrArapPayment;
import com.dimata.service.general.harisma.entity.enums.HrAppGroupStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HrArapPaymentBody {
    private Long idHrArapPayment;
    private Long idArapMain;
    private String paymentNo;
    private LocalDate paymentDate;
    private Long idPerkiraanPayment;
    private Long idCurrency;
    private Integer counter;
    private Double rate;
    private Double amount;
    private Long idSellingAktiva;
    private Long idReceiveAktiva;
    private HrAppGroupStatus arapType;
    private Long idContact;
    private Double leftToPay;
    private HrAppGroupStatus paymentStatus;
    private LocalDateTime lastUpdate;
    private Long idJurnal;
    private Long idBoPayment;
    private Long idEmployee;
    private HrAppGroupStatus paymentType;

    public static HrArapPaymentBody formArapPayment(HrArapPayment ent) {
        var output = new HrArapPaymentBody();
        output.setIdHrArapPayment(ent.id);
        output.setIdArapMain(ent.idArapMain);
        output.setPaymentNo(ent.paymentNo);
        output.setPaymentDate(ent.paymentDate);
        output.setIdPerkiraanPayment(ent.idPerkiraanPayment);
        output.setIdCurrency(ent.idCurrency);
        output.setCounter(ent.counter);
        output.setRate(ent.rate);
        output.setAmount(ent.amount);
        output.setIdSellingAktiva(ent.idSellingAktiva);
        output.setIdReceiveAktiva(ent.idReceiveAktiva);
        output.setArapType(ent.arapType);
        output.setIdContact(ent.idContact);
        output.setLeftToPay(ent.leftToPay);
        output.setPaymentStatus(ent.paymentStatus);
        output.setLastUpdate(ent.lastUpdate);
        output.setIdJurnal(ent.idJurnal);
        output.setIdBoPayment(ent.idBoPaymnet);
        output.setIdEmployee(ent.idEmployee);
        output.setPaymentType(ent.paymentType);
        return output;
    }

    public HrArapPayment updateArapPayment(HrArapPayment payment) {
        payment.idArapMain = changeItOrNot(idArapMain, payment.idArapMain);
        payment.paymentNo = changeItOrNot(paymentNo, payment.paymentNo);
        payment.paymentDate = changeItOrNot(paymentDate, payment.paymentDate);
        payment.idPerkiraanPayment = changeItOrNot(idPerkiraanPayment, payment.idPerkiraanPayment);
        payment.idCurrency = changeItOrNot(idCurrency, payment.idCurrency);
        payment.counter = changeItOrNot(counter, payment.counter);
        payment.rate = changeItOrNot(rate, payment.rate);
        payment.amount = changeItOrNot(amount, payment.amount);
        payment.idSellingAktiva = changeItOrNot(idSellingAktiva, payment.idSellingAktiva);
        payment.idReceiveAktiva = changeItOrNot(idReceiveAktiva, payment.idReceiveAktiva);
        payment.arapType = changeItOrNot(arapType, payment.arapType);
        payment.idContact = changeItOrNot(idContact, payment.idContact);
        payment.leftToPay = changeItOrNot(leftToPay, payment.leftToPay);
        payment.paymentStatus = changeItOrNot(paymentStatus, payment.paymentStatus);
        payment.lastUpdate = changeItOrNot(lastUpdate, payment.lastUpdate);
        payment.idJurnal = changeItOrNot(idJurnal, payment.idJurnal);
        payment.idBoPaymnet = changeItOrNot(idBoPayment, payment.idBoPaymnet);
        payment.idEmployee = changeItOrNot(idEmployee, payment.idEmployee);
        payment.paymentType = changeItOrNot(paymentType, payment.paymentType);
        return payment;
    }
}
