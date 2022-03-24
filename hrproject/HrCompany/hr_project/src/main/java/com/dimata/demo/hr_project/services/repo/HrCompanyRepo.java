package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrCompany;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface HrCompanyRepo extends R2dbcRepository<HrCompany, Long> {
    Mono<HrCompany> findById(long id);
    
}
