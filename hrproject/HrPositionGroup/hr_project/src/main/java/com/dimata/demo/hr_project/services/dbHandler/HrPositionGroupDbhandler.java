package com.dimata.demo.hr_project.services.dbHandler;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.HrPositionGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class HrPositionGroupDbhandler extends DbHandlerBase<HrPositionGroup, Long>{
    @Autowired
    private R2dbcRepository<HrPositionGroup, Long> repo;

    @Override
    protected R2dbcRepository<HrPositionGroup, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<HrPositionGroup> setGenerateId(HrPositionGroup record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<HrPositionGroup> setGenerateIdBatch(Flux<HrPositionGroup> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }
}
