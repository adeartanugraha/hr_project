package com.dimata.service.general.harisma.service;

import com.dimata.service.general.harisma.entity.HrAppGroup;
import com.dimata.service.general.harisma.exception.DataNotFoundException;
import com.dimata.service.general.harisma.exception.ExceptionCode;
import com.dimata.service.general.harisma.model.body.HrAppGroupBody;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HrAppGroupHandler {
    public List<HrAppGroupBody> getHrAppGroup(long id) {
        return HrAppGroup.findById(id)
                .stream()
                .map(HrAppGroupBody::fromHrAppGroup)
                .collect(Collectors.toList());
    }

    public List<HrAppGroupBody> getAllHrAppGroup() {
        return HrAppGroup.getAllData()
                .stream()
                .map(HrAppGroupBody::fromHrAppGroup)
                .collect(Collectors.toList());
    }

    public HrAppGroup updateAppGroup(HrAppGroupBody body) {
        HrAppGroup group = HrAppGroup.findById(body.getIdHrAppGroup());
        if(group == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Group not found");
        }
        body.updateGroup(group);
        return group;
    }

    public HrAppGroupBody createAppGroup(HrAppGroupBody body) {
        var hrAppGroup = saveNewHrAppGroup(body);
        return HrAppGroupBody.fromHrAppGroup(hrAppGroup);
    }

    private HrAppGroup saveNewHrAppGroup(HrAppGroupBody body) {
        var hrAppGroup = new HrAppGroup();
        hrAppGroup.id = body.getIdHrAppGroup();
        hrAppGroup.groupName = body.getGroupName();
        hrAppGroup.regDate = body.getRegDate();
        hrAppGroup.status = body.getStatus();
        hrAppGroup.description = body.getDescription();
        hrAppGroup.persist();
        return hrAppGroup;
    }
}
