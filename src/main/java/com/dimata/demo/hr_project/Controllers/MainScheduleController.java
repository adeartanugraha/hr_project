package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.MainScheduleForm;
import com.dimata.demo.hr_project.models.output.UserSchedule;
import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.dimata.demo.hr_project.services.api.MainScheduleApi;

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
public class MainScheduleController {

    @Autowired
    private MainScheduleApi mainScheduleApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/main_schedule", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<MainSchedule> maintainerAddMainSchedule(@RequestBody MainScheduleForm form) {
        return mainScheduleApi.createMainSchedule(form);
    }

    @GetMapping(path = BASE_URL + "/main_schedule")
    public Flux<UserSchedule> maintainerGetAllMainSchedule(CommonParam param) {
        return mainScheduleApi.getAllMainSchedule(param);
    }

    @GetMapping(path = BASE_URL + "/main_schedule/{id_mainschedule}")
    public Mono<MainSchedule> maintainerGetMainSchedule(@PathVariable("id_mainschedule") Long idMainschedule) {
        return mainScheduleApi.getMainSchedule(idMainschedule);
    }

    @PutMapping(path = BASE_URL + "/main_schedule/{id_mainschedule}")
    public Mono<MainSchedule> maintainerUpdateMainSchedule(@PathVariable("id_mainschedule") long idMainschedule, @RequestBody MainScheduleForm form) {
        return mainScheduleApi.updateMainSchedule(idMainschedule, form);
    }
}
