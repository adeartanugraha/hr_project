package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrPositionGroupForm;
import com.dimata.demo.hr_project.models.table.HrPositionGroup;
import com.dimata.demo.hr_project.services.api.HrPositionGroupApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PositionGroupController {
    @Autowired
    private HrPositionGroupApi hrPositionGroupApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/position_group", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrPositionGroup> maintainerAddDataPositionGroup(@RequestBody HrPositionGroupForm form) {
        return hrPositionGroupApi.createDataPositionGroup(form);
    }

    @GetMapping(path = BASE_URL + "/position_group")
    public Flux<HrPositionGroup> maintainerGetAllDataPositionGroup(CommonParam param) {
        return hrPositionGroupApi.getAllDataPositionGroup(param);
    }

    @GetMapping(path = BASE_URL + "/position_group/{POSITION_GROUP_ID}")
    public Mono<HrPositionGroup> maintainerGetDataPositionGroup(@PathVariable("POSITION_GROUP_ID") Long positionGroupId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrPositionGroupApi.getDataPositionGroup(positionGroupId);
    }

    @PutMapping(path = BASE_URL + "/position_group/{POSITION_GROUP_ID}")
    public Mono<HrPositionGroup> maintainerUpdateDataPositionGroup(@PathVariable("POSITION_GROUP_ID") long positionGroupId, @RequestBody HrPositionGroupForm form) {
        return hrPositionGroupApi.updateDataPositionGroup(positionGroupId, form);
    }
}  
