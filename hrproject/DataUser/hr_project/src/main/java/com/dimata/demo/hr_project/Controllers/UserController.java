package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.DataUserForm;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.dimata.demo.hr_project.services.api.DataUserApi;

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
public class UserController {
    @Autowired
    private DataUserApi dataUserApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<DataUser> maintainerAddDataUser(@RequestBody DataUserForm form) {
        // TODO : Tidak boleh ada dua return dalam satu method.

        return dataUserApi.createDataUser(form);

    }

    @GetMapping(path = BASE_URL + "/user")
    public Flux<DataUser> maintainerGetAllDataUser(CommonParam param) {
        return dataUserApi.getAllDataUser(param);
    }

    @GetMapping(path = BASE_URL + "/user/{id_user}")
    public Mono<DataUser> maintainerGetDataUser(@PathVariable("id_user") Long idUser) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return dataUserApi.getDataUser(idUser);
    }

    @PutMapping(path = BASE_URL + "/user/{id_user}")
    public Mono<DataUser> maintainerUpdateDataUser(@PathVariable("id_user") long idUser, @RequestBody DataUserForm form) {
        return dataUserApi.updateDataUser(idUser, form);
    }
}
