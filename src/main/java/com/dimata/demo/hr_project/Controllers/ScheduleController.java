package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataScheduleForm;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.services.api.DataScheduleApi;

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
public class ScheduleController {

    @Autowired
    private DataScheduleApi dataWorkhourApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/schedule", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataSchedule> maintainerAddDataSchedule(@RequestBody DataScheduleForm form) {
        return dataWorkhourApi.createDataWorkhour(form);
    }

    @GetMapping(path = BASE_URL + "/schedule")
    public Flux<DataSchedule> maintainerGetAllDataSchedule(CommonParam param) {
        return dataWorkhourApi.getAllDataWorkhour(param);
    }

    @GetMapping(path = BASE_URL + "/schedule/{id_schedule}")
    public Mono<DataSchedule> maintainerGetDataSchedule(@PathVariable("id_schedule") Long idSchedule) {
        return dataWorkhourApi.getDataWorkhour(idSchedule);
    }

    @PutMapping(path = BASE_URL + "/schedule/{id_schedule}")
    public Mono<DataSchedule> maintainerUpdateDataSchedule(@PathVariable("id_schedule") long idSchedule, @RequestBody DataScheduleForm form) {
        return dataWorkhourApi.updateDataWorkhour(idSchedule, form);
    }
}
