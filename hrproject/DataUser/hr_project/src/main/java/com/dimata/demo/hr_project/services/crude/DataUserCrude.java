package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.DataUser;
import com.dimata.demo.hr_project.services.dbHandler.DataUserDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataUserCrude {
    @Autowired
    private DataUserDbhandler dataJurusanDbhandler;

    public static Option initOption(DataUser record) {
        return new Option(record);
    }

    public Mono<DataUser> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<DataUser> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<DataUser> savedRecord = dataJurusanDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<DataUser> updateRecord(Option option) {
        return dataJurusanDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final DataUser record;
        
        public Option(DataUser record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
