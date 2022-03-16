package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataToken;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataTokenRepo extends R2dbcRepository<DataToken, Long> {
    
    Mono<DataToken> findById(Long id);
}
