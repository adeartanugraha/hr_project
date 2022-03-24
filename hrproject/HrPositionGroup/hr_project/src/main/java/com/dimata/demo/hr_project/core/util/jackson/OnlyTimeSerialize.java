package com.dimata.demo.hr_project.core.util.jackson;

import java.time.LocalTime;

import com.dimata.demo.hr_project.core.util.FormatUtil;
import com.fasterxml.jackson.databind.util.StdConverter;

public class OnlyTimeSerialize extends StdConverter<LocalTime, String>{
    @Override
    public String convert(LocalTime time) {
        return FormatUtil.convertTimeToString(time);
    }
}
