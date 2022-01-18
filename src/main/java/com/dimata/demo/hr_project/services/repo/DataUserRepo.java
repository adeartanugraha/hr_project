package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.DataUser;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface DataUserRepo extends R2dbcRepository<DataUser, Long> {
    Mono<DataUser> findById(long id);
    
}
