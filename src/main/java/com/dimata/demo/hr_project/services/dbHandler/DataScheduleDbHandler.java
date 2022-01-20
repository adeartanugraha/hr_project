package com.dimata.demo.hr_project.services.dbHandler;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.services.repo.DataScheduleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class DataScheduleDbHandler extends DbHandlerBase<DataSchedule, Long> {
    
    @Autowired
    private DataScheduleRepo repo;

    @Override
    protected R2dbcRepository<DataSchedule, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<DataSchedule> setGenerateId(DataSchedule record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<DataSchedule> setGenerateIdBatch(Flux<DataSchedule> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }
    
}
