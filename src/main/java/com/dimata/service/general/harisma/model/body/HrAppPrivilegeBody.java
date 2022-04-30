package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.core.util.jackson.TimeDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeSerialize;
import com.dimata.service.general.harisma.entity.HrAppPrivilege;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrAppPrivilegeBody {
    private Long idHrAppPrivilege;
    private String privName;

    @JsonSerialize(converter = TimeSerialize.class)
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime regDate;
    private String description;

    public static HrAppPrivilegeBody formHrAppPrivilege(HrAppPrivilege ent) {
        var output = new HrAppPrivilegeBody();
        output.setIdHrAppPrivilege(ent.id);
        output.setPrivName(ent.privName);
        output.setRegDate(ent.regDate);
        output.setDescription(ent.description);
        return output;
    }

    public HrAppPrivilege updatePrivilege(HrAppPrivilege privilege) {
        privilege.privName = changeItOrNot(privName, privilege.privName);
        privilege.description = changeItOrNot(description, privilege.description);
        return privilege;
    }
}
