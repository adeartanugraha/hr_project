package com.dimata.demo.hr_project.enums;

import java.time.DayOfWeek;
import java.time.LocalDate;

import lombok.Getter;

public class DayOnly {
    LocalDate date = LocalDate.now();
    DayOfWeek now = date.getDayOfWeek();
    
    @Getter
    private final int day = now.getValue();

    public static String getDay(Integer day){
        switch (day) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THRUSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
            default:
                return "UNDEFINED";
        }
    }

    
}
