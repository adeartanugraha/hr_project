package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.DataToken;
import com.dimata.demo.hr_project.services.dbHandler.DataTokenDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataTokenCrude {
    @Autowired
    private DataTokenDbhandler dataTokenDbhandler;

    public static Option initOption(DataToken record) {
        return new Option(record);
    }

    public Mono<DataToken> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<DataToken> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<DataToken> savedRecord = dataTokenDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<DataToken> updateRecord(Option option) {
        return dataTokenDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final DataToken record;
        
        public Option(DataToken record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
