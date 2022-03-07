package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.JoinQuery;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataScheduleForm;
import com.dimata.demo.hr_project.models.output.IndustrySchedule;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.services.crude.DataScheduleCrude;
import com.dimata.demo.hr_project.services.dbHandler.DataScheduleDbHandler;

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
    @Autowired
    private DataScheduleDbHandler dataScheduleDbHandler;

    public Mono<DataSchedule> createDataWorkhour(DataScheduleForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataScheduleCrude.Option option = DataScheduleCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataWorkhourCrude::create);
    }

    public Flux<IndustrySchedule> getAllDataWorkhour(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataSchedule.TABLE_NAME, param)
        .addColumns(dataScheduleDbHandler.userScheduleColumn())
        .addJoin(JoinQuery.doInnerJoin(DataIndustry.TABLE_NAME)
            .on(WhereQuery.when(DataSchedule.TABLE_NAME+"."+DataSchedule.ID_INDUSTRY_COL)
            .is(DataIndustry.TABLE_NAME+"."+DataIndustry.ID_COL))
        )
        .build();
        // var sql = SelectQBuilder.builderWithCommonParam(DataSchedule.TABLE_NAME, param)
        //     .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(IndustrySchedule::fromRow)
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
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
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
