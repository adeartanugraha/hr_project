package com.dimata.demo.hr_project.services.api;

import com.dimata.demo.hr_project.core.exception.DataNotFoundException;
import com.dimata.demo.hr_project.core.search.CommonParam;
import com.dimata.demo.hr_project.core.search.SelectQBuilder;
import com.dimata.demo.hr_project.core.search.WhereQuery;
import com.dimata.demo.hr_project.forms.HrPositionForm;
import com.dimata.demo.hr_project.models.table.HrPosition;
import com.dimata.demo.hr_project.services.crude.HrPositionCrude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HrPositionApi {
  @Autowired
  private HrPositionCrude hrDepartmentCrude;

  @Autowired
  private R2dbcEntityTemplate template;

  public Mono<HrPosition> createDataDepartment(HrPositionForm form) {
    return Mono
      .just(form)
      .flatMap(
        f -> {
          HrPositionCrude.Option option = HrPositionCrude.initOption(
            f.convertNewRecord()
          );
          return Mono.just(option);
        }
      )
      .flatMap(hrDepartmentCrude::create);
  }

  public Flux<HrPosition> getAllDataDepartment(CommonParam param) {
    var sql = SelectQBuilder
      .builderWithCommonParam(HrPosition.TABLE_NAME, param)
      .build();
    return template.getDatabaseClient().sql(sql).map(HrPosition::fromRow).all();
  }

  public Mono<HrPosition> getDataDepartment(Long id) {
    var sql = SelectQBuilder
      .emptyBuilder(HrPosition.TABLE_NAME)
      .addWhere(WhereQuery.when(HrPosition.ID_COL).is(id))
      .build();
    System.out.println(sql);
    return template
      .getDatabaseClient()
      .sql(sql)
      .map(HrPosition::fromRow)
      .one()
      .switchIfEmpty(
        Mono.error(new DataNotFoundException("Data Tidak ditemukan"))
      );
  }

  public Mono<HrPosition> updateDataDepartment(Long id, HrPositionForm form) {
    return Mono
      .zip(Mono.just(id), Mono.just(form))
      .map(
        z -> {
          z.getT2().setId(z.getT1());
          return z.getT2();
        }
      )
      .flatMap(
        d -> {
          HrPositionCrude.Option option = HrPositionCrude.initOption(
            d.convertNewRecord()
          );
          return Mono.just(option);
        }
      )
      .flatMap(hrDepartmentCrude::updateRecord);
  }
}
