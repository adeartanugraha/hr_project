package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataWorkhourForm;
import com.dimata.demo.hr_project.models.table.DataWorkhour;
import com.dimata.demo.hr_project.services.api.DataWorkhourApi;

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
public class WorkhourController {

    @Autowired
    private DataWorkhourApi dataWorkhourApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/workhour", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataWorkhour> maintainerAddDataSiswa(@RequestBody DataWorkhourForm form) {
        return dataWorkhourApi.createDataWorkhour(form);
    }

    @GetMapping(path = BASE_URL + "/workhour")
    public Flux<DataWorkhour> maintainerGetAllDataSiswa(CommonParam param) {
        return dataWorkhourApi.getAllDataWorkhour(param);
    }

    @GetMapping(path = BASE_URL + "/workhour/{id_workhour}")
    public Mono<DataWorkhour> maintainerGetDataSiswa(@PathVariable("id_workhour") Long idWorkhour) {
        return dataWorkhourApi.getDataWorkhour(idWorkhour);
    }

    @PutMapping(path = BASE_URL + "/workhour/{id_workhour}")
    public Mono<DataWorkhour> maintainerUpdateDataSiswa(@PathVariable("id_workhour") long idWorkhour, @RequestBody DataWorkhourForm form) {
        return dataWorkhourApi.updateDataWorkhour(idWorkhour, form);
    }
}
