package com.dimata.demo.hr_project.Controllers;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.forms.HrCompanyForm;
import com.dimata.demo.hr_project.models.table.HrCompany;
import com.dimata.demo.hr_project.services.api.HrCompanyApi;

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
public class CompanyController {
    @Autowired
    private HrCompanyApi hrCompanyApi;

    private static final String BASE_URL = "/hr_project/v1";

    @PostMapping(path = BASE_URL + "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<HrCompany> maintainerAddDataCompany(@RequestBody HrCompanyForm form) {
        return hrCompanyApi.createDataCompany(form);
    }

    @GetMapping(path = BASE_URL + "/company")
    public Flux<HrCompany> maintainerGetAllDataCompany(CommonParam param) {
        return hrCompanyApi.getAllDataCompany(param);
    }

    @GetMapping(path = BASE_URL + "/company/{COMPANY_ID}")
    public Mono<HrCompany> maintainerGetDataCompany(@PathVariable("COMPANY_ID") Long companyId) {
        // TODO : ini typo ? gak kepakek auto correcnya ?
        // tinggal pencel spasi + ctrl
        return hrCompanyApi.getDataCompany(companyId);
    }

    @PutMapping(path = BASE_URL + "/company/{COMPANY_ID}")
    public Mono<HrCompany> maintainerUpdateDataCompany(@PathVariable("COMPANY_ID") long companyId, @RequestBody HrCompanyForm form) {
        return hrCompanyApi.updateDataCompany(companyId, form);
    }
}  
