package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.search.CollumnQuery;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.JoinQuery;
import com.dimata.demo.hr_project.core.search.JoinQueryStep;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataAbsentForm;
import com.dimata.demo.hr_project.models.output.UserAbsent;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.dimata.demo.hr_project.services.crude.DataAbsentCrude;
import com.dimata.demo.hr_project.services.dbHandler.DataAbsentDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class DataAbsentApi {
    @Autowired
    private DataAbsentCrude dataAbsentCrude;
    @Autowired
	private R2dbcEntityTemplate template;
    @Autowired
    private DataAbsentDbhandler dataAbsentDbhandler;

    public Mono<DataAbsent> createDataAbsent(DataAbsentForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataAbsentCrude.Option option = DataAbsentCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataAbsentCrude::create);
    }

    public Flux<UserAbsent> getAllDataAbsent(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataAbsent.TABLE_NAME, param)
            .addColumns(dataAbsentDbhandler.userAbsentColumn())
            .addJoin(JoinQuery.doInnerJoin(DataUser.TABLE_NAME)
                .on(WhereQuery.when(DataAbsent.TABLE_NAME+"."+DataAbsent.ID_COL)
                .is(DataUser.TABLE_NAME+"."+DataUser.ID_COL))
            )
            .build();
        // var sql = SelectQBuilder.builder(DataAbsent.TABLE_NAME, JoinQuery.doInnerJoin(DataUser.TABLE_NAME).on(WhereQuery.when(DataAbsent.ID_COL).is(DataUser.ID_COL)), param)
        //     .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(UserAbsent::fromRow)
            .all();
    }

    public Mono<DataAbsent> getDataAbsent(Long id) {
        var sql = SelectQBuilder.emptyBuilder(DataAbsent.TABLE_NAME)
            .addWhere(WhereQuery.when(DataAbsent.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataAbsent::fromRow)
            .one();
    }

    public Mono<DataAbsent> updateDataAbsent(Long id, DataAbsentForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                DataAbsentCrude.Option option = DataAbsentCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataAbsentCrude::updateRecord);
    }    
}
