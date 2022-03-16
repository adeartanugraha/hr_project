package com.dimata.demo.hr_project.core.search;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FunctionOpt {
    String function;

    @Override
    public String toString(){
        return function;
    }
}
