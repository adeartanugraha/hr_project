package com.dimata.demo.hr_project.enums;

import lombok.Getter;

public enum WorkStatus {
    WFO(0),
    WFH(1),
    UNDEFINED(-1);

    @Getter
    private final int code;

    public static WorkStatus getStatus(Integer code){
        switch (code) {
            case 0:
                return WFO;
            case 1:
                return WFH;
            default:
                return UNDEFINED;
        }
    }

    WorkStatus(int code) {
        this.code = code;
    }

    // public String parseStatus(WorkStatus status){
    //     if (status == WorkStatus.WFO) {
    //         return "WFO";
    //     }
    //     return "WFH";
    // }

    public String parseStatus(int code) {
        if (getStatus(code) == WorkStatus.WFO) {
            return "WFO";
        } else if (getStatus(code) == WorkStatus.WFH) {
            return "WFH";
        }
        return "Undefined";
    }
}
