package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataScheduleForm;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.services.crude.DataScheduleCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataScheduleApi {
    
    @Autowired
    private DataScheduleCrude dataWorkhourCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<DataSchedule> createDataWorkhour(DataScheduleForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataScheduleCrude.Option option = DataScheduleCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataWorkhourCrude::create);
    }

    public Flux<DataSchedule> getAllDataWorkhour(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataSchedule.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataSchedule::fromRow)
            .all();
    }

    public Mono<DataSchedule> getDataWorkhour(Long id) {
        var sql = SelectQBuilder.emptyBuilder(DataSchedule.TABLE_NAME)
            .addWhere(WhereQuery.when(DataSchedule.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataSchedule::fromRow)
            .one();
    }

    public Mono<DataSchedule> updateDataWorkhour(Long id, DataScheduleForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                DataScheduleCrude.Option option = DataScheduleCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataWorkhourCrude::updateRecord);
    }
}
