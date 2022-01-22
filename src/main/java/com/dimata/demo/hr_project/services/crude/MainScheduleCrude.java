package com.dimata.demo.hr_project.services.crude;

import com.dimata.demo.hr_project.models.table.MainSchedule;
import com.dimata.demo.hr_project.services.dbHandler.MainScheduleDbHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MainScheduleCrude {
    
    @Autowired
    private MainScheduleDbHandler mainScheduleDbHandler;

    public static Option initOption(MainSchedule record) {
        return new Option(record);
    }

    public Mono<MainSchedule> create(Option option) {
        return Mono.just(option)
            .flatMap(this::createRecord)
            .map(o -> o.getRecord());
    }

    public Flux<MainSchedule> createInBatch(Flux<Option> option) {
		return option
			.flatMap(this::create);
	}

    private Mono<Option> createRecord(Option option) {
		return Mono.just(option)
			.flatMap(o -> {
				Mono<MainSchedule> savedRecord = mainScheduleDbHandler.create(o.getRecord());
				
				return Mono.zip(savedRecord, Mono.just(o))
					.map(z -> z.getT2().setIdRecord(z.getT1().getId()));
			});
	}

    public Mono<MainSchedule> updateRecord(Option option) {
        return mainScheduleDbHandler.updateOnly(option.getRecord(), option.getRecord().getId());
    }

    @Data
    @Setter(AccessLevel.NONE)
    public static class Option {
        private final MainSchedule record;
        
        public Option(MainSchedule record) {
            this.record = record;
        }

        public Option setIdRecord(long id) {
            record.setId(id);
            return this;
        }
    }
}
