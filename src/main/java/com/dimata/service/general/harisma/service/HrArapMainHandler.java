package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.ContactList;
import com.dimata.service.general.harisma.entity.EmployeeStart;
import com.dimata.service.general.harisma.entity.HrArapMain;
import com.dimata.service.general.harisma.entity.Perkiraan;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrArapMainBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrArapMainHandler {
    public List<HrArapMainBody> getArapMain(long id) {
        return HrArapMain.findById(id)
                .stream()
                .map(HrArapMainBody::formArapMain)
                .collect(Collectors.toList());
    }

    public List<HrArapMainBody> getAllHrArapMain() {
        return HrArapMain.getAllData()
                .stream()
                .map(HrArapMainBody::formArapMain)
                .collect(Collectors.toList());
    }

    public HrArapMain updateArapMain(HrArapMainBody body) {
        HrArapMain main = HrArapMain.findById(body.getIdHrArapMain());
        if (main == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateArapMain(main);
        return main;
    }

    public HrArapMainBody createArapMain(HrArapMainBody body) {
        if (body.getIdContact() == null || body.getIdPerkiraan() == null || body.getIdEmployee() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var contactList = fetchContactList(body.getIdContact());
        var perkiraan = fetchPerkiraan(body.getIdPerkiraan());
        var employee = fetchEmployee(body.getIdEmployee());
        var hrArapMain = saveNewHrArapMain(body, contactList, perkiraan, employee);
        return HrArapMainBody.formArapMain(hrArapMain);
    }

    private ContactList fetchContactList(long contactId) {
        return (ContactList) ContactList.findByIdOptional(contactId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private Perkiraan fetchPerkiraan(long perkiraanId) {
        return (Perkiraan) Perkiraan.findByIdOptional(perkiraanId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private EmployeeStart fetchEmployee(long employeeId) {
        return (EmployeeStart) EmployeeStart.findByIdOptional(employeeId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrArapMain saveNewHrArapMain(HrArapMainBody body, ContactList contactList, Perkiraan perkiraan, EmployeeStart employee) {
        var hrArapMain = new HrArapMain();
        hrArapMain.id = body.getIdHrArapMain();
        hrArapMain.voucherNo = body.getVoucherNo();
        hrArapMain.voucherDate = body.getVoucherDate();
        hrArapMain.idContact = contactList;
        hrArapMain.numberOfPayment = body.getNumberOfPayment();
        hrArapMain.idPerkiraanLawan = body.getIdPerkiraanLawan();
        hrArapMain.idPerkiraan = perkiraan;
        hrArapMain.idCurrency = body.getIdCurrency();
        hrArapMain.counter = body.getCounter();
        hrArapMain.rate = body.getRate();
        hrArapMain.amount = body.getAmount();
        hrArapMain.notaNo = body.getNotaNo();
        hrArapMain.notaDate = body.getNotaDate();
        hrArapMain.description = body.getDescription();
        hrArapMain.arapType = body.getArapType();
        hrArapMain.arapDocStatus = body.getArapDocStatus();
        hrArapMain.arapMainStatus = body.getArapMainStatus();
        hrArapMain.lastUpdate = body.getLastUpdate();
        hrArapMain.idJurnal = body.getIdJurnal();
        hrArapMain.idComponentDeduction = body.getIdComponentDeduction();
        hrArapMain.idEmployee = employee;
        hrArapMain.entryDate = body.getEntryDate();
        hrArapMain.periodEvery = body.getPeriodEvery();
        hrArapMain.periodEveryDmy = body.getPeriodEveryDmy();
        hrArapMain.startOfPaymentDate = body.getStartOfPaymentDate();
        hrArapMain.paymentAmountPlan = body.getPaymentAmountPlan();
        hrArapMain.periodType = body.getPeriodType();
        hrArapMain.idPeriod = body.getIdPeriod();
        hrArapMain.persist();
        return hrArapMain;
    }
}
