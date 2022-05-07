package com.dimata.service.general.harisma.model.body;

import com.dimata.service.general.harisma.core.util.jackson.TimeDeserialize;
import com.dimata.service.general.harisma.core.util.jackson.TimeSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeStartBody {
    private Long idEmployee;
    private String reg;
    private String nik;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String phone;
    private String sex;
    private String Religion;
    private Double divition;
    private String dep;
    private String location;
    private String status;
    private String position;
    private Double child;
    private String dob;
    @JsonSerialize(converter = TimeSerialize.class)
    @JsonDeserialize(converter = TimeDeserialize.class)
    private LocalDateTime start;
    private String level;
}
