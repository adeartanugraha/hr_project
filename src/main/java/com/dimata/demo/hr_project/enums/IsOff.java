package com.dimata.demo.hr_project.enums;

import lombok.Getter;

public enum IsOff {
    YES(0),
    NO(1),
    UNDEFINED(-1);

    @Getter
    private final int code;

    public static IsOff getIsOff(Integer code){
        switch (code) {
            case 0:
                return YES;
            case 1:
                return NO;
            default:
                return UNDEFINED;
        }
    }

    IsOff(int code) {
        this.code = code;
    }

    public String parseIsOff(IsOff gender){
        if (gender == IsOff.YES) {
            return "YES";
        }
        return "NO";
    }

    public String parseIsOff(int code) {
        if (getIsOff(code) == IsOff.YES) {
            return "YES";
        } else if (getIsOff(code) == IsOff.NO) {
            return "NO";
        }
        return "Undefined";
    }
}
