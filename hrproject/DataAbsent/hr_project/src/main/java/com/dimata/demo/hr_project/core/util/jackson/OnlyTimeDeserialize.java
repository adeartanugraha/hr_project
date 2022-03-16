package com.dimata.demo.hr_project.core.util.jackson;

import java.time.LocalTime;

import com.dimata.demo.hr_project.core.util.FormatUtil;
import com.fasterxml.jackson.databind.util.StdConverter;

public class OnlyTimeDeserialize extends StdConverter<String, LocalTime> {
    @Override
    public LocalTime convert(String time) {
        return FormatUtil.convertTimeToLocalTime(time,"HH:mm:ss");
    }
    
}
