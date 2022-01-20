package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataWorkhour;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataWorkhourRepo extends R2dbcRepository<DataWorkhour, Long> {
    
    Mono<DataWorkhour> findById(Long id);
}
