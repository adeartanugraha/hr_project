package com.dimata.demo.hr_project.forms;


import java.time.LocalDate;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrDivision;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrDivisionForm implements RecordAdapter<HrDivision> {

    private Long id;
    private String division;
    private Long companyId;
    private Long divisionTypeId;
    private String description;
    private String city;
    private String npwp;
    private String province;
    private String region;
    private String subRegion;
    private String village;
    private String area;
    private String telephone;
    private String faxNumber;
    private Integer typeOfDivision;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    private String pemotong;
    private Long employeeId;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrDivision convertNewRecord() {
        return HrDivision.Builder.createNewRecord(division, city, npwp, province, region, subRegion, village)
            .description(description)
            .companyId(companyId)
            .divisionTypeId(divisionTypeId)
            .area(area)
            .telephone(telephone)
            .faxNumber(faxNumber)
            .typeOfDivision(typeOfDivision)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .pemotong(pemotong)
            .employeeId(employeeId)
            .id(id)
            .build();
    }
    @Override
    public HrDivision convertToRecord() {
        return HrDivision.Builder.emptyBuilder()
            .division(division)
            .city(city)
            .npwp(npwp)
            .province(province)
            .region(region)
            .subRegion(subRegion)
            .village(village)
            .description(description)
            .companyId(companyId)
            .divisionTypeId(divisionTypeId)
            .area(area)
            .telephone(telephone)
            .faxNumber(faxNumber)
            .typeOfDivision(typeOfDivision)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .pemotong(pemotong)
            .employeeId(employeeId)
            .id(id)
            .build();
    }
}
