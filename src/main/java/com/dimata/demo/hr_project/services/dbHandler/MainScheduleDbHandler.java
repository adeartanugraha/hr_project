package com.dimata.demo.hr_project.services.dbHandler;

import java.util.Arrays;
import java.util.List;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.core.search.CollumnQuery;
import com.dimata.demo.hr_project.core.search.CollumnStep;
import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.dimata.demo.hr_project.services.repo.MainSceduleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class MainScheduleDbHandler extends DbHandlerBase<MainSchedule, Long> {
    
    @Autowired
    private MainSceduleRepo repo;

    @Override
    protected R2dbcRepository<MainSchedule, Long> getRepository() {
        return repo;
    }

    @Override
    protected Mono<MainSchedule> setGenerateId(MainSchedule record) {
        return Mono.just(record)
            .map(z -> {
                long id = getGenerateUtil().generateOID();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<MainSchedule> setGenerateIdBatch(Flux<MainSchedule> records) {
        return records
            .map(rec -> {
                long id = getGenerateUtil().generateOID();
                rec.setInsertId(id);
                return rec;
            });
    }

    public List<CollumnStep> mainScheduleColumn() {
        return Arrays.asList(CollumnQuery.add(getColumnName(MainSchedule.TABLE_NAME, MainSchedule.ID_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.TIME_IN_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.TIME_OUT_COL)),
        CollumnQuery.add(getColumnName(DataSchedule.TABLE_NAME, DataSchedule.DAY_COL)),
        CollumnQuery.add(getColumnName(DataUser.TABLE_NAME, DataUser.USERNAME_COL)),
        CollumnQuery.add(getColumnName(MainSchedule.TABLE_NAME, MainSchedule.ID_SCHEDULE_COL)),
        CollumnQuery.add(getColumnName(MainSchedule.TABLE_NAME, MainSchedule.ID_INDUSTRY_COL)),
        CollumnQuery.add(getColumnName(DataIndustry.TABLE_NAME, DataIndustry.NAME_INDUSTRY_COL)),
        CollumnQuery.add(getColumnName(MainSchedule.TABLE_NAME, MainSchedule.ID_USER_COL)),
        CollumnQuery.add(getColumnName(MainSchedule.TABLE_NAME, MainSchedule.STATUS_COL))
        );
    }

    public String getColumnName(String tableName, String columnName) {
        return tableName+"."+columnName;
    }
    
}
