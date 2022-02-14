package com.dimata.demo.hr_project.services.repo;

import java.util.List;

import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.models.table.DataUser;

import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataAbsentRepo extends R2dbcRepository<DataAbsent, Long> {
    Mono<DataAbsent> findById(long id);
    // List<DataAbsent> findByIdUser(long id); 
}
