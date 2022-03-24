package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrPositionGroup;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface HrPositionGroupRepo extends R2dbcRepository<HrPositionGroup, Long> {
    Mono<HrPositionGroup> findById(long id);
    
}
