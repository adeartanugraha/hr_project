package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataSchedule;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataScheduleRepo extends R2dbcRepository<DataSchedule, Long> {
    
    Mono<DataSchedule> findById(Long id);
}
