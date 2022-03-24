package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrDivisionForm;
import com.dimata.demo.hr_project.models.table.HrDivision;
import com.dimata.demo.hr_project.services.crude.HrDivisionCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class HrDivisionApi {
    @Autowired
    private HrDivisionCrude hrDivisionCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<HrDivision> createDataDivision(HrDivisionForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            HrDivisionCrude.Option option = HrDivisionCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(hrDivisionCrude::create);
    }

    public Flux<HrDivision> getAllDataDivision(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(HrDivision.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrDivision::fromRow)
            .all();
    }

    public Mono<HrDivision> getDataDivision(Long id) {
        var sql = SelectQBuilder.emptyBuilder(HrDivision.TABLE_NAME)
            .addWhere(WhereQuery.when(HrDivision.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrDivision::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<HrDivision> updateDataDivision(Long id, HrDivisionForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                HrDivisionCrude.Option option = HrDivisionCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(hrDivisionCrude::updateRecord);
    }    
}
