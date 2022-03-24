package com.dimata.demo.hr_project.forms;


import com.dimata.demo.hr_project.core.api.RecordAdapter;
import com.dimata.demo.hr_project.core.util.jackson.DateDeserialize;
import com.dimata.demo.hr_project.models.table.HrCompany;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HrCompanyForm implements RecordAdapter<HrCompany> {

    private Long id;
    private String company;
    private String description;
    @JsonDeserialize(converter = DateDeserialize.class)
    @Override
    public HrCompany convertNewRecord() {
        return HrCompany.Builder.createNewRecord(company)
            .description(description)
            .id(id)
            .build();
    }
    @Override
    public HrCompany convertToRecord() {
        return HrCompany.Builder.emptyBuilder()
            .company(company)
            .description(description)
            .id(id)
            .build();
    }
}
