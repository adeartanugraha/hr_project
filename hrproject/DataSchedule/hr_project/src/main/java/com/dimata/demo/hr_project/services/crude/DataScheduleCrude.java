package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.DataSchedule;
import com.dimata.demo.hr_project.services.dbHandler.DataScheduleDbHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DataScheduleCrude {
    
    @Autowired
    private DataScheduleDbHandler dataWorkhourDbHandler;

    public static Option initOption(DataSchedule record) {
        return new Option(record);
    }

    public Mono<DataSchedule> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<DataSchedule> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<DataSchedule> savedRecord = dataWorkhourDbHandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<DataSchedule> updateRecord(Option option) {
        return dataWorkhourDbHandler.updateOnly(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final DataSchedule record;
        
        public Option(DataSchedule record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
