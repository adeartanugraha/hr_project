package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrPositionTypeForm;
import com.dimata.demo.hr_project.models.table.HrPositionType;
import com.dimata.demo.hr_project.services.crude.HrPositionTypeCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class HrPositionTypeApi {
    @Autowired
    private HrPositionTypeCrude hrPositionTypeCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<HrPositionType> createDataPositionType(HrPositionTypeForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            HrPositionTypeCrude.Option option = HrPositionTypeCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(hrPositionTypeCrude::create);
    }

    public Flux<HrPositionType> getAllDataPositionType(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(HrPositionType.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrPositionType::fromRow)
            .all();
    }

    public Mono<HrPositionType> getDataPositionType(Long id) {
        var sql = SelectQBuilder.emptyBuilder(HrPositionType.TABLE_NAME)
            .addWhere(WhereQuery.when(HrPositionType.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrPositionType::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<HrPositionType> updateDataPositionType(Long id, HrPositionTypeForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                HrPositionTypeCrude.Option option = HrPositionTypeCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(hrPositionTypeCrude::updateRecord);
    }    
}
