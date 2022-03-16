package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataTokenForm;
import com.dimata.demo.hr_project.models.table.DataToken;
import com.dimata.demo.hr_project.services.crude.DataTokenCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class DataTokenApi {
    @Autowired
    private DataTokenCrude dataTokenCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<DataToken> createDataToken(DataTokenForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataTokenCrude.Option option = DataTokenCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataTokenCrude::create);
    }

    public Flux<DataToken> getAllDataToken(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataToken.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataToken::fromRow)
            .all();
    }

    public Mono<DataToken> getDataToken(Long id) {
        var sql = SelectQBuilder.emptyBuilder(DataToken.TABLE_NAME)
            .addWhere(WhereQuery.when(DataToken.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataToken::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("data tidak ditemukan")));
    }

    public Mono<DataToken> updateDataToken(Long id, DataTokenForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                DataTokenCrude.Option option = DataTokenCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataTokenCrude::updateRecord);
    }    
}
