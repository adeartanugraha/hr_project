package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrCompanyForm;
import com.dimata.demo.hr_project.models.table.HrCompany;
import com.dimata.demo.hr_project.services.crude.HrCompanyCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class HrCompanyApi {
    @Autowired
    private HrCompanyCrude hrCompanyCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<HrCompany> createDataCompany(HrCompanyForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            HrCompanyCrude.Option option = HrCompanyCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(hrCompanyCrude::create);
    }

    public Flux<HrCompany> getAllDataCompany(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(HrCompany.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrCompany::fromRow)
            .all();
    }

    public Mono<HrCompany> getDataCompany(Long id) {
        var sql = SelectQBuilder.emptyBuilder(HrCompany.TABLE_NAME)
            .addWhere(WhereQuery.when(HrCompany.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrCompany::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<HrCompany> updateDataCompany(Long id, HrCompanyForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                HrCompanyCrude.Option option = HrCompanyCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(hrCompanyCrude::updateRecord);
    }    
}
