package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrDivision;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface HrDivisionRepo extends R2dbcRepository<HrDivision, Long> {
    Mono<HrDivision> findById(long id);
    
}
