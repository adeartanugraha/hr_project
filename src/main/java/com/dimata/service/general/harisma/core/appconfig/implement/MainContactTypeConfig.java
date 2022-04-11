package com.dimata.service.general.harisma.core.appconfig.implement;

import com.dimata.service.general.harisma.core.appconfig.AppConfig;
import com.dimata.service.general.harisma.core.appconfig.AppConfigSpec;
//import com.dimata.service.general.harisma.entity.ContactType;
//import com.dimata.service.general.harisma.exception.DataNotFoundException;
//import com.dimata.service.general.harisma.exception.ExceptionCode;

public class MainContactTypeConfig implements AppConfigSpec {
    @Override
    public AppConfig validate(AppConfig entity) {
        return null;
    }
//
//    @Override
//    public AppConfig validate(AppConfig entity) {
//        entity.value = entity.value
//            .trim()
//            .replace(" ", "_")
//            .toUpperCase();
//        var isExist = ContactType.isTypeExist(entity.value, entity.applicationId);
//        if(!isExist) {
//            throw new DataNotFoundException(ExceptionCode.CFG_VALUE_NO_VALID, "No contact type with name : " + entity.value);
//        }
//        return entity;
//    }
//
//
}
