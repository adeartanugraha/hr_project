package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.HrPosition;
import com.dimata.demo.hr_project.services.dbHandler.HrPositionDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HrPositionCrude {
    @Autowired
    private HrPositionDbhandler dataJurusanDbhandler;

    public static Option initOption(HrPosition record) {
        return new Option(record);
    }

    public Mono<HrPosition> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<HrPosition> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<HrPosition> savedRecord = dataJurusanDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<HrPosition> updateRecord(Option option) {
        return dataJurusanDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final HrPosition record;
        
        public Option(HrPosition record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
