package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataAbsent;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataAbsentRepo extends R2dbcRepository<DataAbsent, Long> {
    Mono<DataAbsent> findById(long id);
    
}
