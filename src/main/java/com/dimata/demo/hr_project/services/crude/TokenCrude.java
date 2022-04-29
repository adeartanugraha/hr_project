package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.Token;
import com.dimata.demo.hr_project.services.dbHandler.TokenDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TokenCrude {
    @Autowired
    private TokenDbhandler dataTokenDbhandler;

    public static Option initOption(Token record) {
        return new Option(record);
    }

    public Mono<Token> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<Token> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<Token> savedRecord = dataTokenDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<Token> updateRecord(Option option) {
        return dataTokenDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final Token record;
        
        public Option(Token record) {
            this.record = record;
        }

        public Option setIdRecord(String id) {
            record.setId(id);
            return this;
        }
    }
}
