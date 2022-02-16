package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.JoinQuery;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.MainScheduleForm;
import com.dimata.demo.hr_project.models.output.UserSchedule;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.dimata.demo.hr_project.services.crude.MainScheduleCrude;
import com.dimata.demo.hr_project.services.dbHandler.MainScheduleDbHandler;

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
    @Autowired
    private MainScheduleDbHandler mainScheduleDbHandler;

    public Mono<MainSchedule> createMainSchedule(MainScheduleForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            MainScheduleCrude.Option option = MainScheduleCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataSiswaCrude::create);
    }

    public Flux<UserSchedule> getAllMainSchedule(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(MainSchedule.TABLE_NAME, param)
        .addColumns(mainScheduleDbHandler.mainScheduleColumn())
        .addJoin(JoinQuery.doInnerJoin(DataSchedule.TABLE_NAME)
            .on(WhereQuery.when(MainSchedule.TABLE_NAME+"."+MainSchedule.ID_SCHEDULE_COL)
            .is(DataSchedule.TABLE_NAME+"."+DataSchedule.ID_COL))
            )
        .addJoin(JoinQuery.doInnerJoin(DataUser.TABLE_NAME)
            .on(WhereQuery.when(MainSchedule.TABLE_NAME+"."+MainSchedule.ID_USER_COL)
            .is(DataUser.TABLE_NAME+"."+DataUser.ID_COL))
            )
        .addJoin(JoinQuery.doInnerJoin(DataIndustry.TABLE_NAME)
            .on(WhereQuery.when(MainSchedule.TABLE_NAME+"."+MainSchedule.ID_INDUSTRY_COL)
            .is(DataIndustry.TABLE_NAME+"."+DataIndustry.ID_COL))
            )
        .build();
        // var sql = SelectQBuilder.builderWithCommonParam(MainSchedule.TABLE_NAME, param)
        //     .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(UserSchedule::fromRow)
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
