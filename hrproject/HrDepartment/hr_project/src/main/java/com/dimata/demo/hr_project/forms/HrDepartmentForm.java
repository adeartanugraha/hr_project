package com.dimata.demo.hr_project.forms;


import java.time.LocalDate;

import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrDepartment;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrDepartmentForm implements RecordAdapter<HrDepartment> {

    private Long id;
    private Long divisionId;
    private String department;
    private String description;
    private Long joinToDepartmentId;
    private Long departmentTypeId;
    private String address;
    private String city;
    private String npwp;
    private String province;
    private String region;
    private String subRegion;
    private String village;
    private String area;
    private String telephone;
    private String faxNumber;
    private Integer validStatus;
    private LocalDate validStart;
    private LocalDate validEnd;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrDepartment convertNewRecord() {
        return HrDepartment.Builder.createNewRecord(department, city, npwp, province, region, subRegion, village)
            .divisionId(divisionId)
            .joinToDepartmentId(joinToDepartmentId)
            .departmentTypeId(departmentTypeId)
            .area(area)
            .telephone(telephone)
            .faxNumber(faxNumber)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .id(id)
            .build();
    }
    @Override
    public HrDepartment convertToRecord() {
        return HrDepartment.Builder.emptyBuilder()
            .department(department)
            .city(city)
            .npwp(npwp)
            .province(province)
            .region(region)
            .subRegion(subRegion)
            .village(village)
            .description(description)
            .divisionId(divisionId)
            .joinToDepartmentId(joinToDepartmentId)
            .area(area)
            .telephone(telephone)
            .faxNumber(faxNumber)
            .departmentTypeId(departmentTypeId)
            .validStatus(validStatus)
            .validStart(validStart)
            .validEnd(validEnd)
            .id(id)
            .build();
    }
}
