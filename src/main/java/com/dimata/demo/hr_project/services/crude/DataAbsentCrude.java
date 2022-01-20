package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.services.dbHandler.DataAbsentDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataAbsentCrude {
    @Autowired
    private DataAbsentDbhandler dataJurusanDbhandler;

    public static Option initOption(DataAbsent record) {
        return new Option(record);
    }

    public Mono<DataAbsent> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<DataAbsent> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<DataAbsent> savedRecord = dataJurusanDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<DataAbsent> updateRecord(Option option) {
        return dataJurusanDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final DataAbsent record;
        
        public Option(DataAbsent record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
