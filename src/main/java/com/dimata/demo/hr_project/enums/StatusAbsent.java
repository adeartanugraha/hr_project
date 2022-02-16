package com.dimata.demo.hr_project.enums;

import lombok.Getter;

public enum StatusAbsent {
    IN(0),
    OUT(1),
    UNDEFINED(-1);

    @Getter
    private final int code;

    public static StatusAbsent getStatusAbsent(Integer code){
        switch (code) {
            case 0:
                return IN;
            case 1:
                return OUT;
            default:
                return UNDEFINED;
        }
    }

    StatusAbsent(int code) {
        this.code = code;
    }

    public String parseStatusAbsent(StatusAbsent status){
        if (status == StatusAbsent.IN) {
            return "IN";
        }
        return "OUT";
    }

    public String parseIsOff(int code) {
        if (getStatusAbsent(code) == StatusAbsent.IN) {
            return "IN";
        } else if (getStatusAbsent(code) == StatusAbsent.OUT) {
            return "OUT";
        }
        return "Undefined";
    }
}
