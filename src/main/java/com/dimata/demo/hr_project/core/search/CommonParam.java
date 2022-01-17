package com.dimata.demo.hr_project.core.search;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class CommonParam {
    @Min(value = 1, message = "Minimal 1")
    private int page = 1;
    @Min(value = 1, message = "Minimal 1")
    private int limit = 10;
    private boolean nolmt = false;
    private boolean asc = true;
    private String sortBy;
}
