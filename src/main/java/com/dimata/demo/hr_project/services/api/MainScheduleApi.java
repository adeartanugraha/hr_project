package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.MainScheduleForm;
import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.dimata.demo.hr_project.services.crude.MainScheduleCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MainScheduleApi {
    
    @Autowired
    private MainScheduleCrude dataSiswaCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<MainSchedule> createMainSchedule(MainScheduleForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            MainScheduleCrude.Option option = MainScheduleCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataSiswaCrude::create);
    }

    public Flux<MainSchedule> getAllMainSchedule(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(MainSchedule.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(MainSchedule::fromRow)
            .all();
    }

    public Mono<MainSchedule> getMainSchedule(Long id) {
        var sql = SelectQBuilder.emptyBuilder(MainSchedule.TABLE_NAME)
            .addWhere(WhereQuery.when(MainSchedule.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(MainSchedule::fromRow)
            .one();
    }

    public Mono<MainSchedule> updateMainSchedule(Long id, MainScheduleForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                MainScheduleCrude.Option option = MainScheduleCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataSiswaCrude::updateRecord);
    }
}
