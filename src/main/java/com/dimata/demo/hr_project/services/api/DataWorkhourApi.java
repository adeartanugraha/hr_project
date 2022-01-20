package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.DataWorkhourForm;
import com.dimata.demo.hr_project.models.table.DataWorkhour;
import com.dimata.demo.hr_project.services.crude.DataWorkhourCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DataWorkhourApi {
    
    @Autowired
    private DataWorkhourCrude dataWorkhourCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<DataWorkhour> createDataWorkhour(DataWorkhourForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            DataWorkhourCrude.Option option = DataWorkhourCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataWorkhourCrude::create);
    }

    public Flux<DataWorkhour> getAllDataWorkhour(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(DataWorkhour.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataWorkhour::fromRow)
            .all();
    }

    public Mono<DataWorkhour> getDataWorkhour(Long id) {
        var sql = SelectQBuilder.emptyBuilder(DataWorkhour.TABLE_NAME)
            .addWhere(WhereQuery.when(DataWorkhour.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(DataWorkhour::fromRow)
            .one();
    }

    public Mono<DataWorkhour> updateDataWorkhour(Long id, DataWorkhourForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                DataWorkhourCrude.Option option = DataWorkhourCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataWorkhourCrude::updateRecord);
    }
}
