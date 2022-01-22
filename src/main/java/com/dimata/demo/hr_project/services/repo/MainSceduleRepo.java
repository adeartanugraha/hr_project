package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.MainSchedule;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface MainSceduleRepo extends R2dbcRepository<MainSchedule, Long> {
    
    Mono<MainSchedule> findById(Long id);
}
