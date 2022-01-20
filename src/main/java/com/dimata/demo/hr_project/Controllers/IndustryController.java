package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataIndustryForm;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.services.api.DataIndustryApi;

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
public class IndustryController {
    @Autowired
    private DataIndustryApi dataIndustryApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/industry", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataIndustry> maintainerAddDataIndustry(@RequestBody DataIndustryForm form) {
        // TODO : Tidak boleh ada dua return dalam satu method.

        return dataIndustryApi.createDataIndustry(form);

    }

    @GetMapping(path = BASE_URL + "/industry")
    public Flux<DataIndustry> maintainerGetAllDataIndustry(CommonParam param) {
        return dataIndustryApi.getAllDataIndustry(param);
    }

    @GetMapping(path = BASE_URL + "/industry/{id_industry}")
    public Mono<DataIndustry> maintainerGetDataIndustry(@PathVariable("id_industry") Long idIndustry) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return dataIndustryApi.getDataIndustry(idIndustry);
    }

    @PutMapping(path = BASE_URL + "/industry/{id_industry}")
    public Mono<DataIndustry> maintainerUpdateDataIndustry(@PathVariable("id_industry") long idIndustry, @RequestBody DataIndustryForm form) {
        return dataIndustryApi.updateDataIndustry(idIndustry, form);
    }
}
