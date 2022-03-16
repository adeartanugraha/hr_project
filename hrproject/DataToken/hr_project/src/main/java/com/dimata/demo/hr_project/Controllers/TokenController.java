package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataTokenForm;
import com.dimata.demo.hr_project.models.table.DataToken;
import com.dimata.demo.hr_project.services.api.DataTokenApi;

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
public class TokenController {
    @Autowired
    private DataTokenApi dataTokenApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/token", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataToken> maintainerAddDataToken(@RequestBody DataTokenForm form) {
        return dataTokenApi.createDataToken(form);

    }

    @GetMapping(path = BASE_URL + "/token")
    public Flux<DataToken> maintainerGetAllDataToken(CommonParam param) {
        return dataTokenApi.getAllDataToken(param);
    }

    @GetMapping(path = BASE_URL + "/token/{token_code}")
    public Mono<DataToken> maintainerGetDataAbsent(@PathVariable("token_code") Long tokenCode) {
        return dataTokenApi.getDataToken(tokenCode);
    }

    @PutMapping(path = BASE_URL + "/token/{token_code}")
    public Mono<DataToken> maintainerUpdateDataAbsent(@PathVariable("token_code") long tokenCode, @RequestBody DataTokenForm form) {
        return dataTokenApi.updateDataToken(tokenCode, form);
    }
}
