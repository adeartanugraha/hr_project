package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrArapCreditor;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.model.body.HrArapCreditorBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrArapCreditorHandler {
    public List<HrArapCreditorBody> getCreditor(long id) {
        return HrArapCreditor.findById(id)
                .stream()
                .map(HrArapCreditorBody::formArapCreditor)
                .collect(Collectors.toList());
    }

    public List<HrArapCreditorBody> getAllCreditor() {
        return HrArapCreditor.getAllData()
                .stream()
                .map(HrArapCreditorBody::formArapCreditor)
                .collect(Collectors.toList());
    }

    public HrArapCreditor updateCreditor(HrArapCreditorBody body) {
        HrArapCreditor creditor = HrArapCreditor.findById(body.getIdHrArapCreditor());
        if (creditor == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updateCreditor(creditor);
        return creditor;
    }

    public HrArapCreditorBody createCreditor(HrArapCreditorBody body ) {
        var hrArapCreditor = saveNewCreditor(body);
        return HrArapCreditorBody.formArapCreditor(hrArapCreditor);
    }

    private HrArapCreditor saveNewCreditor(HrArapCreditorBody body) {
        var hrArapCreditor = new HrArapCreditor();
        hrArapCreditor.id = body.getIdHrArapCreditor();
        hrArapCreditor.creditorName = body.getCreditorName();
        hrArapCreditor.description = body.getDescription();
        hrArapCreditor.persist();
        return hrArapCreditor;
    }
}
