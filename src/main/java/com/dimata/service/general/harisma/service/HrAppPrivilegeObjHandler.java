package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAppPrivilege;
import com.dimata.service.general.harisma.entity.HrAppPrivilegeObj;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.exception.FormatException;
import com.dimata.service.general.harisma.model.body.HrAppPrivilegeObjBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppPrivilegeObjHandler {
    public List<HrAppPrivilegeObjBody> getPrivilegeObj(long id) {
        return HrAppPrivilegeObj.findById(id)
                .stream()
                .map(HrAppPrivilegeObjBody::formPrivilegeObj)
                .collect(Collectors.toList());
    }

    public List<HrAppPrivilegeObjBody> getAllPrivilegeObj() {
        return HrAppPrivilegeObj.getAllData()
                .stream()
                .map(HrAppPrivilegeObjBody::formPrivilegeObj)
                .collect(Collectors.toList());
    }

    public HrAppPrivilegeObj updatePrivilegeObje(HrAppPrivilegeObjBody body) {
        HrAppPrivilegeObj privilegeObj = HrAppPrivilegeObj.findById(body.getIdAppPrivilegeObj());
        if (privilegeObj == null) {
            throw new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND);
        }
        body.updatePrivilege(privilegeObj);
        return privilegeObj;
    }

    public HrAppPrivilegeObjBody createPrivilegeObj(HrAppPrivilegeObjBody body) {
        if (body.getIdPriv() == null) {
            throw new FormatException(ExceptionCode.F_NV);
        }
        var privilege = fetchAppPrivilege(body.getIdPriv());
        var hrAppPrivilegeObj = saveNewPrivilegeObj(body, privilege);
        return HrAppPrivilegeObjBody.formPrivilegeObj(hrAppPrivilegeObj);
    }

    private HrAppPrivilege fetchAppPrivilege(long appPrivilegeId) {
        return (HrAppPrivilege) HrAppPrivilege.findByIdOptional(appPrivilegeId)
                .orElseThrow(() -> new DataNotFoundException(ExceptionCode.DATA_NOT_FOUND));
    }

    private HrAppPrivilegeObj saveNewPrivilegeObj(HrAppPrivilegeObjBody body, HrAppPrivilege privilege) {
        var hrAppPrivilegeObj = new HrAppPrivilegeObj();
        hrAppPrivilegeObj.id = body.getIdAppPrivilegeObj();
        hrAppPrivilegeObj.idPriv = privilege;
        hrAppPrivilegeObj.code = body.getCode();
        hrAppPrivilegeObj.persist();
        return hrAppPrivilegeObj;
    }
}
