package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrPositionGroupForm;
import com.dimata.demo.hr_project.models.table.HrPositionGroup;
import com.dimata.demo.hr_project.services.crude.HrPositionGroupCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class HrPositionGroupApi {
    @Autowired
    private HrPositionGroupCrude hrPositionGroupCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<HrPositionGroup> createDataPositionGroup(HrPositionGroupForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            HrPositionGroupCrude.Option option = HrPositionGroupCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(hrPositionGroupCrude::create);
    }

    public Flux<HrPositionGroup> getAllDataPositionGroup(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(HrPositionGroup.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrPositionGroup::fromRow)
            .all();
    }

    public Mono<HrPositionGroup> getDataPositionGroup(Long id) {
        var sql = SelectQBuilder.emptyBuilder(HrPositionGroup.TABLE_NAME)
            .addWhere(WhereQuery.when(HrPositionGroup.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrPositionGroup::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<HrPositionGroup> updateDataPositionGroup(Long id, HrPositionGroupForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                HrPositionGroupCrude.Option option = HrPositionGroupCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(hrPositionGroupCrude::updateRecord);
    }    
}
