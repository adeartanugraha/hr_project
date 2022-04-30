package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAppPrivilege;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.model.body.HrAppPrivilegeBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppPrivilegeHandler {
    public List<HrAppPrivilegeBody> getHrAppPrivilege(long id) {
        return HrAppPrivilege.findById(id)
                .stream()
                .map(HrAppPrivilegeBody::formHrAppPrivilege)
                .collect(Collectors.toList());
    }

    public List<HrAppPrivilegeBody> getAllHrAppPrivilege() {
        return HrAppPrivilege.getAllData()
                .stream()
                .map(HrAppPrivilegeBody::formHrAppPrivilege)
                .collect(Collectors.toList());
    }

    public HrAppPrivilege updateAppPrivilege(HrAppPrivilegeBody body) {
        HrAppPrivilege privilege = HrAppPrivilege.findById(body.getIdHrAppPrivilege());
        if (privilege == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updatePrivilege(privilege);
        return privilege;
    }

    public HrAppPrivilegeBody createAppPrivilege(HrAppPrivilegeBody body) {
        var hrAppPrivilege = saveNewPrivilege(body);
        return HrAppPrivilegeBody.formHrAppPrivilege(hrAppPrivilege);
    }

    private HrAppPrivilege saveNewPrivilege(HrAppPrivilegeBody body) {
        var hrAppPrivilege = new HrAppPrivilege();
        hrAppPrivilege.id = body.getIdHrAppPrivilege();
        hrAppPrivilege.privName = body.getPrivName();
        hrAppPrivilege.regDate = body.getRegDate();
        hrAppPrivilege.description = body.getDescription();
        hrAppPrivilege.persist();
        return hrAppPrivilege;
    }
}
