package com.dimata.demo.hr_project.enums;

import lombok.Getter;

public enum IsActive {
    ACTIVE(0),
    NOT_ACTIVE(1),
    UNDEFINED(-1);

    @Getter
    private final int code;

    public static IsActive getIsActive(Integer code){
        switch (code) {
            case 0:
                return ACTIVE;
            case 1:
                return NOT_ACTIVE;
            default:
                return UNDEFINED;
        }
    }

    IsActive(int code) {
        this.code = code;
    }

    public String parseIsActive(IsActive active){
        if (active == IsActive.ACTIVE) {
            return "Active";
        }
        return "Not Active";
    }

    public String parseIsActive(int code) {
        if (getIsActive(code) == IsActive.ACTIVE) {
            return "Active";
        } else if (getIsActive(code) == IsActive.NOT_ACTIVE) {
            return "Not Active";
        }
        return "Undefined";
    }
}
