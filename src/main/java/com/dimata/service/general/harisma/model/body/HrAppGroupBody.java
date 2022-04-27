package com.dimata.service.general.harisma.model.body;

import static com.dimata.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.dimata.service.general.harisma.core.util.jackson.TimeDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeSerialize;
import com.dimata.service.general.harisma.entity.HrAppGroup;
import com.dimata.service.general.harisma.entity.enums.HrAppGroupStatus;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrAppGroupBody {
    private Long idHrAppGroup;
    private String groupName;
    @JsonSerialize(converter = TimeSerialize.class)
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime regDate;
    private HrAppGroupStatus status;
    private String description;

    public static HrAppGroupBody fromHrAppGroup(HrAppGroup ent) {
        var output = new HrAppGroupBody();
        output.setIdHrAppGroup(ent.id);
        output.setGroupName(ent.groupName);
        output.setRegDate(ent.regDate);
        output.setStatus(ent.status);
        output.setDescription(ent.description);
        return output;
    }

    public HrAppGroup updateGroup(HrAppGroup group) {
        group.groupName = changeItOrNot(groupName, group.groupName);
        group.status = changeItOrNot(status, group.status);
        group.description = changeItOrNot(description, group.description);
        return group;
    }
}
