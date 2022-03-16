package com.dimata.demo.hr_project.enums;

import lombok.Getter;

public enum DayOfWeeks {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THRUSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    UNDEFINED(-1);

    @Getter
    private final int code;

    public static DayOfWeeks getDay(Integer code){
        switch (code) {
            case 0:
                return SUNDAY;
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THRUSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            default:
                return UNDEFINED;
        }
    }

    DayOfWeeks(int code) {
        this.code = code;
    }

    // public String parseStatus(WorkStatus day){
    //     if (day == DayOfWeek.SUNDAY) {
    //         return "WFO";
    //     }
    //     return "WFH";
    // }

    public String parseStatus(int code) {
        if (getDay(code) == DayOfWeeks.SUNDAY) {
            return "SUNDAY";
        } else if (getDay(code) == DayOfWeeks.MONDAY) {
            return "MONDAY";
        } else if (getDay(code) == DayOfWeeks.TUESDAY) {
            return "TUESDAY";
        } else if (getDay(code) == DayOfWeeks.WEDNESDAY) {
            return "WEDNESDAY";
        } else if (getDay(code) == DayOfWeeks.THRUSDAY) {
            return "THRUSDAY";
        } else if (getDay(code) == DayOfWeeks.FRIDAY) {
            return "FRIDAY";
        } else if (getDay(code) == DayOfWeeks.SATURDAY) {
            return "SATURDAY";
        }
        return "Undefined";
    }
}
