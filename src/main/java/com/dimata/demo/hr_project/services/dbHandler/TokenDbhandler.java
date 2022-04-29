package com.dimata.demo.hr_project.services.dbHandler;

import java.util.UUID;

import com.dimata.demo.hr_project.core.api.DbHandlerBase;
import com.dimata.demo.hr_project.models.table.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@EqualsAndHashCode(callSuper = true)
public class TokenDbhandler extends DbHandlerBase<Token, String>{
    @Autowired
    private R2dbcRepository<Token, String> repo;

    @Override
    protected R2dbcRepository<Token, String> getRepository() {
        return repo;
    }

    @Override
    protected Mono<Token> setGenerateId(Token record) {
        return Mono.just(record)
            .map(z -> {
                String id = UUID.randomUUID().toString();
                z.setInsertId(id);
                return z;
            });
    }

    @Override
    protected Flux<Token> setGenerateIdBatch(Flux<Token> records) {
        return records
            .map(rec -> {
                String id = UUID.randomUUID().toString();
                rec.setInsertId(id);
                return rec;
            });
    }
}
