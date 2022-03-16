package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataIndustryForm;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.services.crude.DataIndustryCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class DataIndustryApi {
    @Autowired
    private DataIndustryCrude dataIndustryCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<DataIndustry> createDataIndustry(DataIndustryForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataIndustryCrude.Option option = DataIndustryCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataIndustryCrude::create);
    }

    public Flux<DataIndustry> getAllDataIndustry(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataIndustry.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataIndustry::fromRow)
            .all();
    }

    public Mono<DataIndustry> getDataIndustry(Long id) {
        var sql = SelectQBuilder.emptyBuilder(DataIndustry.TABLE_NAME)
            .addWhere(WhereQuery.when(DataIndustry.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataIndustry::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<DataIndustry> updateDataIndustry(Long id, DataIndustryForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                DataIndustryCrude.Option option = DataIndustryCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataIndustryCrude::updateRecord);
    }    
}
