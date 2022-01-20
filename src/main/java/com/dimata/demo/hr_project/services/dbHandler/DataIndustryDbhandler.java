package com.dimata.demo.hr_project.services.dbHandler;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.DataIndustry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class DataIndustryDbhandler extends DbHandlerBase<DataIndustry, Long>{
    @Autowired
    private R2dbcRepository<DataIndustry, Long> repo;

    @Override
    protected R2dbcRepository<DataIndustry, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<DataIndustry> setGenerateId(DataIndustry record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<DataIndustry> setGenerateIdBatch(Flux<DataIndustry> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }
}
