package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrDepartmentForm;
import com.dimata.demo.hr_project.models.table.HrDepartment;
import com.dimata.demo.hr_project.services.crude.HrDepartmentCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class HrDepartmentApi {
    @Autowired
    private HrDepartmentCrude hrDepartmentCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<HrDepartment> createDataDepartment(HrDepartmentForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            HrDepartmentCrude.Option option = HrDepartmentCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(hrDepartmentCrude::create);
    }

    public Flux<HrDepartment> getAllDataDepartment(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(HrDepartment.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrDepartment::fromRow)
            .all();
    }

    public Mono<HrDepartment> getDataDepartment(Long id) {
        var sql = SelectQBuilder.emptyBuilder(HrDepartment.TABLE_NAME)
            .addWhere(WhereQuery.when(HrDepartment.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(HrDepartment::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("Data Tidak ditemukan")));
    }

    public Mono<HrDepartment> updateDataDepartment(Long id, HrDepartmentForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                HrDepartmentCrude.Option option = HrDepartmentCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(hrDepartmentCrude::updateRecord);
    }    
}
