package com.dimata.demo.hr_project.core.search;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SortQuery {
    private String sortBy;
    private boolean asc;
}
