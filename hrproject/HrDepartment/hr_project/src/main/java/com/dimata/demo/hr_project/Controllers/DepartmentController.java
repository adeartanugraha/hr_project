package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrDepartmentForm;
import com.dimata.demo.hr_project.models.table.HrDepartment;
import com.dimata.demo.hr_project.services.api.HrDepartmentApi;

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
public class DepartmentController {
    @Autowired
    private HrDepartmentApi hrDepartmentApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/department", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrDepartment> maintainerAddDataDepartment(@RequestBody HrDepartmentForm form) {
        return hrDepartmentApi.createDataDepartment(form);
    }

    @GetMapping(path = BASE_URL + "/department")
    public Flux<HrDepartment> maintainerGetAllDataDepartment(CommonParam param) {
        return hrDepartmentApi.getAllDataDepartment(param);
    }

    @GetMapping(path = BASE_URL + "/department/{DEPARTMENT_ID}")
    public Mono<HrDepartment> maintainerGetDataDepartment(@PathVariable("DEPARTMENT_ID") Long departmentId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrDepartmentApi.getDataDepartment(departmentId);
    }

    @PutMapping(path = BASE_URL + "/department/{DEPARTMENT_ID}")
    public Mono<HrDepartment> maintainerUpdateDataDepartment(@PathVariable("DEPARTMENT_ID") long departmentId, @RequestBody HrDepartmentForm form) {
        return hrDepartmentApi.updateDataDepartment(departmentId, form);
    }
}  
