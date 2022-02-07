package com.dimata.demo.hr_project.models.output;

import java.util.Arrays;
import java.util.List;

import com.dimata.demo.hr_project.core.search.CollumnQuery;
import com.dimata.demo.hr_project.core.search.CollumnStep;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.models.table.DataAbsent;
import com.dimata.demo.hr_project.models.table.DataUser;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAbsent {
    private Long idUser;
    private Long idAbsent;

    public static UserAbsent fromRow(Row row) {
        var result = new UserAbsent();
        result.setIdUser(ManipulateUtil.parseRow(row, "id_user", Long.class));
        result.setIdAbsent(ManipulateUtil.parseRow(row, "id_absent", Long.class));
        return result;
    }
}
