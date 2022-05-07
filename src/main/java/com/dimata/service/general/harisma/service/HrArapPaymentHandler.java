package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.ContactList;
import com.dimata.service.general.harisma.entity.EmployeeStart;
import com.dimata.service.general.harisma.entity.HrArapMain;
import com.dimata.service.general.harisma.entity.HrArapPayment;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrArapPaymentBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrArapPaymentHandler {
    public List<HrArapPaymentBody> getHrArapPayment(long id) {
        return HrArapPayment.findById(id)
                .stream()
                .map(HrArapPaymentBody::formArapPayment)
                .collect(Collectors.toList());
    }

    public List<HrArapPaymentBody> getAllHrArapPayment() {
        return HrArapPayment.getAllData()
                .stream()
                .map(HrArapPaymentBody::formArapPayment)
                .collect(Collectors.toList());
    }

    public HrArapPayment updateArapPayment(HrArapPaymentBody body) {
        HrArapPayment payment = HrArapPayment.findById(body.getIdHrArapPayment());
        if (payment == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateArapPayment(payment);
        return payment;
    }

    public HrArapPaymentBody createArapPayment(HrArapPaymentBody body) {
        if (body.getIdArapMain() == null || body.getIdContact() == null || body.getIdEmployee() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var arapMain = fetchArapMain(body.getIdArapMain());
        var contactList = fetchContactList(body.getIdContact());
        var employee = fetchEmployee(body.getIdEmployee());
        var hrArapPayment = saveNewHrArapPayment(body, arapMain, contactList, employee);
        return HrArapPaymentBody.formArapPayment(hrArapPayment);
    }

    private HrArapMain fetchArapMain(long arapMainId) {
        return (HrArapMain) HrArapMain.findByIdOptional(arapMainId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private ContactList fetchContactList(long contactId) {
        return (ContactList) ContactList.findByIdOptional(contactId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private EmployeeStart fetchEmployee(long employeeId) {
        return (EmployeeStart) EmployeeStart.findByIdOptional(employeeId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrArapPayment saveNewHrArapPayment(HrArapPaymentBody body, HrArapMain arapMain, ContactList contactList, EmployeeStart employee) {
        var hrArapPayment = new HrArapPayment();
        hrArapPayment.id = body.getIdHrArapPayment();
        hrArapPayment.idArapMain = arapMain;
        hrArapPayment.paymentNo = body.getPaymentNo();
        hrArapPayment.paymentDate = body.getPaymentDate();
        hrArapPayment.idPerkiraanPayment = body.getIdPerkiraanPayment();
        hrArapPayment.idCurrency = body.getIdCurrency();
        hrArapPayment.counter = body.getCounter();
        hrArapPayment.rate = body.getRate();
        hrArapPayment.amount = body.getAmount();
        hrArapPayment.idSellingAktiva = body.getIdSellingAktiva();
        hrArapPayment.idReceiveAktiva = body.getIdReceiveAktiva();
        hrArapPayment.arapType = body.getArapType();
        hrArapPayment.idContact = contactList;
        hrArapPayment.leftToPay = body.getLeftToPay();
        hrArapPayment.paymentStatus = body.getPaymentStatus();
        hrArapPayment.lastUpdate = body.getLastUpdate();
        hrArapPayment.idJurnal = body.getIdJurnal();
        hrArapPayment.idBoPaymnet = body.getIdBoPayment();
        hrArapPayment.idEmployee = employee;
        hrArapPayment.paymentType = body.getPaymentType();
        hrArapPayment.persist();
        return hrArapPayment;
    }
}
