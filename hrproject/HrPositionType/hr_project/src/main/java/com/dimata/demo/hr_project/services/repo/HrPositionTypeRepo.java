package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrPositionType;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface HrPositionTypeRepo extends R2dbcRepository<HrPositionType, Long> {
    Mono<HrPositionType> findById(long id);
    
}
