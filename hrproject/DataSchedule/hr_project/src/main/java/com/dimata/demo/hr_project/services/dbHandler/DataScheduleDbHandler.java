package com.dimata.demo.hr_project.services.dbHandler;

import java.util.Arrays;
import java.util.List;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.core.search.CollumnQuery;
import com.dimata.demo.hr_project.core.search.CollumnStep;
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
    
    public List<CollumnStep> userScheduleColumn() {
        return Arrays.asList(CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.ID_COL)),
        CollumnQuery.add(getColumnName("data_industry", "name_industry")),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.ID_INDUSTRY_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.DAY_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.TIME_IN_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.TIME_OUT_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.ISOFF_COL))
        );
    }

    public String getColumnName(String tableName, String columnName) {
        return tableName+"."+columnName;
    }
}
