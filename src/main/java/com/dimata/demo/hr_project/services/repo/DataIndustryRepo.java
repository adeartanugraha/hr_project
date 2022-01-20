package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataIndustry;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataIndustryRepo extends R2dbcRepository<DataIndustry, Long> {
    Mono<DataIndustry> findById(long id);
    
}
