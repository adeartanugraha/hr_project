package com.dimata.demo.hr_project.services.dbHandler;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.HrDivision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class HrDivisionDbhandler extends DbHandlerBase<HrDivision, Long>{
    @Autowired
    private R2dbcRepository<HrDivision, Long> repo;

    @Override
    protected R2dbcRepository<HrDivision, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<HrDivision> setGenerateId(HrDivision record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<HrDivision> setGenerateIdBatch(Flux<HrDivision> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }
}
