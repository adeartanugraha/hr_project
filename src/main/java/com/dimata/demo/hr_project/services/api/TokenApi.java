package com.dimata.demo.hr_project.services.api;


import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.TokenForm;
import com.dimata.demo.hr_project.models.table.Token;
import com.dimata.demo.hr_project.services.crude.TokenCrude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class TokenApi {
    @Autowired
    private TokenCrude dataTokenCrude;
    @Autowired
	private R2dbcEntityTemplate template;

    public Mono<Token> createDataToken(TokenForm form) {
        return Mono.just(form)
        .flatMap(f -> {
            TokenCrude.Option option = TokenCrude.initOption(f.convertNewRecord());
            return Mono.just(option);
        })
        .flatMap(dataTokenCrude::create);
    }

    public Flux<Token> getAllDataToken(CommonParam param) {
        var sql = SelectQBuilder.builderWithCommonParam(Token.TABLE_NAME, param)
            .build();
        return template.getDatabaseClient()
            .sql(sql)
            .map(Token::fromRow)
            .all();
    }

    public Mono<Token> getDataToken(String id) {
        var sql = SelectQBuilder.emptyBuilder(Token.TABLE_NAME)
            .addWhere(WhereQuery.when(Token.ID_COL).is(id))
            .build();
        System.out.println(sql);
        return template.getDatabaseClient()
            .sql(sql)
            .map(Token::fromRow)
            .one()
            .switchIfEmpty(Mono.error(new DataNotFoundException("data tidak ditemukan")));
    }

    public Mono<Token> updateDataToken(String id, TokenForm form) {
        return Mono.zip(Mono.just(id), Mono.just(form))
            .map(z -> {
                z.getT2().setId(z.getT1());
                return z.getT2();
            })
            .flatMap(d -> {
                TokenCrude.Option option = TokenCrude.initOption(d.convertNewRecord());
                return Mono.just(option);
            })
            .flatMap(dataTokenCrude::updateRecord);
    }    
}
