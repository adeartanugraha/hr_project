package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrDivisionForm;
import com.dimata.demo.hr_project.models.table.HrDivision;
import com.dimata.demo.hr_project.services.api.HrDivisionApi;

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
public class DivisionController {
    @Autowired
    private HrDivisionApi hrDivisionApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/division", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrDivision> maintainerAddDataDivision(@RequestBody HrDivisionForm form) {
        return hrDivisionApi.createDataDivision(form);
    }

    @GetMapping(path = BASE_URL + "/division")
    public Flux<HrDivision> maintainerGetAllDataDivision(CommonParam param) {
        return hrDivisionApi.getAllDataDivision(param);
    }

    @GetMapping(path = BASE_URL + "/division/{DIVISION_ID}")
    public Mono<HrDivision> maintainerGetDataDivision(@PathVariable("DIVISION_ID") Long divisionId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrDivisionApi.getDataDivision(divisionId);
    }

    @PutMapping(path = BASE_URL + "/division/{DIVISION_ID}")
    public Mono<HrDivision> maintainerUpdateDataDivision(@PathVariable("DIVISION_ID") long divisionId, @RequestBody HrDivisionForm form) {
        return hrDivisionApi.updateDataDivision(divisionId, form);
    }
}  
