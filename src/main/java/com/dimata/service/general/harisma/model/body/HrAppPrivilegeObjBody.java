package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrAppPrivilegeObj;
import lombok.Data;

@Data
public class HrAppPrivilegeObjBody {
    private Long idAppPrivilegeObj;
    private Long idPriv;
    private Integer code;

    public static HrAppPrivilegeObjBody formPrivilegeObj(HrAppPrivilegeObj ent) {
        var output = new HrAppPrivilegeObjBody();
        output.setIdAppPrivilegeObj(ent.id);
        output.setIdPriv(ent.idPriv.id);
        output.setCode(ent.code);
        return output;
    }

    public HrAppPrivilegeObj updatePrivilege(HrAppPrivilegeObj obj) {
        obj.idPriv.id = changeItOrNot(idPriv, obj.idPriv.id);
        obj.code = changeItOrNot(code, obj.code);
        return obj;
    }
}
