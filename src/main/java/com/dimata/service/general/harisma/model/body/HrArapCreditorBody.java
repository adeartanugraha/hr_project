package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.entity.HrArapCreditor;
import lombok.Data;

@Data
public class HrArapCreditorBody {
    private Long idHrArapCreditor;
    private String creditorName;
    private String description;

    public static HrArapCreditorBody formArapCreditor(HrArapCreditor ent) {
        var output = new HrArapCreditorBody();
        output.setIdHrArapCreditor(ent.id);
        output.setCreditorName(ent.creditorName);
        output.setDescription(ent.description);
        return output;
    }

    public HrArapCreditor updateCreditor(HrArapCreditor creditor) {
        creditor.creditorName = changeItOrNot(creditorName, creditor.creditorName);
        creditor.description = changeItOrNot(description, creditor.description);
        return creditor;
    }
}
