package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.HrDepartment;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface HrDepartmentRepo extends R2dbcRepository<HrDepartment, Long> {
    Mono<HrDepartment> findById(long id);
    
}
