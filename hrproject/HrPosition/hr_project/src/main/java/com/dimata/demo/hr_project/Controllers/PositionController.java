package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrPositionForm;
import com.dimata.demo.hr_project.models.table.HrPosition;
import com.dimata.demo.hr_project.services.api.HrPositionApi;

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
public class PositionController {
    @Autowired
    private HrPositionApi hrDepartmentApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrPosition> maintainerAddDataDepartment(@RequestBody HrPositionForm form) {
        return hrDepartmentApi.createDataDepartment(form);
    }

    @GetMapping(path = BASE_URL + "/department")
    public Flux<HrPosition> maintainerGetAllDataDepartment(CommonParam param) {
        return hrDepartmentApi.getAllDataDepartment(param);
    }

    @GetMapping(path = BASE_URL + "/department/{DEPARTMENT_ID}")
    public Mono<HrPosition> maintainerGetDataDepartment(@PathVariable("DEPARTMENT_ID") Long departmentId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrDepartmentApi.getDataDepartment(departmentId);
    }

    @PutMapping(path = BASE_URL + "/department/{DEPARTMENT_ID}")
    public Mono<HrPosition> maintainerUpdateDataDepartment(@PathVariable("DEPARTMENT_ID") long departmentId, @RequestBody HrPositionForm form) {
        return hrDepartmentApi.updateDataDepartment(departmentId, form);
    }
}  
