package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.TokenForm;
import com.dimata.demo.hr_project.models.table.Token;
import com.dimata.demo.hr_project.services.api.TokenApi;

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
    private TokenApi dataTokenApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/token", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Token> maintainerAddDataToken(@RequestBody TokenForm form) {
        // TODO : Tidak boleh ada dua return dalam satu method.

        return dataTokenApi.createDataToken(form);

    }

    @GetMapping(path = BASE_URL + "/token")
    public Flux<Token> maintainerGetAllDataToken(CommonParam param) {
        return dataTokenApi.getAllDataToken(param);
    }

    @GetMapping(path = BASE_URL + "/token/{token_code}")
    public Mono<Token> maintainerGetDataAbsent(@PathVariable("token_code") String tokenCode) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return dataTokenApi.getDataToken(tokenCode);
    }

    @PutMapping(path = BASE_URL + "/token/{token_code}")
    public Mono<Token> maintainerUpdateDataAbsent(@PathVariable("token_code") String tokenCode, @RequestBody TokenForm form) {
        return dataTokenApi.updateDataToken(tokenCode, form);
    }
}
