package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.DataIndustry;
import com.dimata.demo.hr_project.services.dbHandler.DataIndustryDbhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataIndustryCrude {
    @Autowired
    private DataIndustryDbhandler dataJurusanDbhandler;

    public static Option initOption(DataIndustry record) {
        return new Option(record);
    }

    public Mono<DataIndustry> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<DataIndustry> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<DataIndustry> savedRecord = dataJurusanDbhandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<DataIndustry> updateRecord(Option option) {
        return dataJurusanDbhandler.update(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final DataIndustry record;
        
        public Option(DataIndustry record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
