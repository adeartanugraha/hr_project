package com.dimata.demo.hr_project.services.dbHandler;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.DataWorkhour;
import com.dimata.demo.hr_project.services.repo.DataWorkhourRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class DataWorkhourDbHandler extends DbHandlerBase<DataWorkhour, Long> {
    
    @Autowired
    private DataWorkhourRepo repo;

    @Override
    protected R2dbcRepository<DataWorkhour, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<DataWorkhour> setGenerateId(DataWorkhour record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<DataWorkhour> setGenerateIdBatch(Flux<DataWorkhour> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }
    
}
