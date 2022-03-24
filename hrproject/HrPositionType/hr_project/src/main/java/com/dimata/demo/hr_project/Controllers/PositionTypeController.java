package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrPositionTypeForm;
import com.dimata.demo.hr_project.models.table.HrPositionType;
import com.dimata.demo.hr_project.services.api.HrPositionTypeApi;

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
public class PositionTypeController {
    @Autowired
    private HrPositionTypeApi hrPositionTypeApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/position_type", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrPositionType> maintainerAddDataPositionType(@RequestBody HrPositionTypeForm form) {
        return hrPositionTypeApi.createDataPositionType(form);
    }

    @GetMapping(path = BASE_URL + "/position_type")
    public Flux<HrPositionType> maintainerGetAllDataPositionType(CommonParam param) {
        return hrPositionTypeApi.getAllDataPositionType(param);
    }

    @GetMapping(path = BASE_URL + "/position_type/{POSITION_TYPE_ID}")
    public Mono<HrPositionType> maintainerGetDataCompany(@PathVariable("POSITION_TYPE_ID") Long positionTypeId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrPositionTypeApi.getDataPositionType(positionTypeId);
    }

    @PutMapping(path = BASE_URL + "/position_type/{POSITION_TYPE_ID}")
    public Mono<HrPositionType> maintainerUpdateDataPositionType(@PathVariable("POSITION_TYPE_ID") long positionTypeId, @RequestBody HrPositionTypeForm form) {
        return hrPositionTypeApi.updateDataPositionType(positionTypeId, form);
    }
}  
