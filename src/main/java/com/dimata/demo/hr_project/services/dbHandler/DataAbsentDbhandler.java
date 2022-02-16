package com.dimata.demo.hr_project.services.dbHandler;

import java.util.Arrays;
import java.util.List;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.core.search.CollumnQuery;
import com.dimata.demo.hr_project.core.search.CollumnStep;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.models.table.DataUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class DataAbsentDbhandler extends DbHandlerBase<DataAbsent, Long>{
    @Autowired
    private R2dbcRepository<DataAbsent, Long> repo;

    @Override
    protected R2dbcRepository<DataAbsent, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<DataAbsent> setGenerateId(DataAbsent record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<DataAbsent> setGenerateIdBatch(Flux<DataAbsent> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }

    public List<CollumnStep> userAbsentColumn() {
        return Arrays.asList(CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.ID_COL)),
        CollumnQuery.add(getColumnName(DataUser.TABLE_NAME, DataUser.USERNAME_COL)),
        CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.ID_USER_COL)),
        CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.ID_TOKEN_COL)),
        CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.USED_AT_COL)),
        CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.STATUS_COL)),
        CollumnQuery.add(getColumnName(DataAbsent.TABLE_NAME, DataAbsent.IS_LATE_COL))
        );
    }

    public String getColumnName(String tableName, String columnName) {
        return tableName+"."+columnName;
    }
}
