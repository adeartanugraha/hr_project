package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataAbsentForm;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.services.api.DataAbsentApi;

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
public class AbsentController {
    @Autowired
    private DataAbsentApi dataAbsentApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/absent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataAbsent> maintainerAddDataAbsent(@RequestBody DataAbsentForm form) {
        

        return dataAbsentApi.createDataAbsent(form);

    }

    @GetMapping(path = BASE_URL + "/absent")
    public Flux<DataAbsent> maintainerGetAllDataAbsent(CommonParam param) {
        return dataAbsentApi.getAllDataAbsent(param);
    }

    @GetMapping(path = BASE_URL + "/absent/{id_absent}")
    public Mono<DataAbsent> maintainerGetDataAbsent(@PathVariable("id_absent") Long id_absent) {
     
        return dataAbsentApi.getDataAbsent(id_absent);
    }
    @GetMapping(path = BASE_URL + "/absent/user/{id_user}")
    public Flux<DataAbsent> maintainerGetDataAbsentUser(@PathVariable("id_user") Long id_user) {
     
        return dataAbsentApi.getDataAbsentUser(id_user);
    }

    @PostMapping(path = BASE_URL + "/absent/{id_absent}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataAbsent> maintainerUpdateDataAbsent(@PathVariable("id_absent") long idAbsent, @RequestBody DataAbsentForm form) {
        return dataAbsentApi.updateDataAbsent(idAbsent, form);
    }
}
