package com.dimata.demo.hr_project.models.output;

import java.time.LocalDateTime;
import com.dimata.demo.hr_project.core.util.ManipulateUtil;
import com.dimata.demo.hr_project.core.util.jackson.TimeSerialize;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.r2dbc.spi.Row;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAbsent {
    private Long idUser;

    private Long id;
    private Long idSchedule;
    private Long idToken; 
    private String username; 

    private Boolean isLate;
    
    @JsonSerialize(converter = TimeSerialize.class)
    private LocalDateTime usedAt ;

    public static UserAbsent fromRow(Row row) {
        var result = new UserAbsent();
        result.setId(ManipulateUtil.parseRow(row, "id_absent", Long.class));
        result.setUsername(ManipulateUtil.parseRow(row, "username", String.class));
        result.setIdUser(ManipulateUtil.parseRow(row, "id_user", Long.class));
        result.setIdToken(ManipulateUtil.parseRow(row, "id_token", Long.class));
        result.setIsLate(ManipulateUtil.parseRow(row, "is_late", Boolean.class));
        result.setIdSchedule(ManipulateUtil.parseRow(row, "id_schedule", Long.class));
        result.setUsedAt(ManipulateUtil.parseRow(row,"used_at", LocalDateTime.class));
        return result;
    }
}
