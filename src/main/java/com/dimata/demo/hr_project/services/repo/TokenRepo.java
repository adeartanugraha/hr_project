package com.dimata.demo.hr_project.services.repo;

import com.dimata.demo.hr_project.models.table.Token;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Mono;

public interface TokenRepo extends R2dbcRepository<Token, String> {
    
    Mono<Token> findById(String id);
}
