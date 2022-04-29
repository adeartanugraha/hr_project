package com.dimata.demo.hr_project.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Gunakan exception ini jika data tidak tersedia di database.
 *
 * @author Hariyogi
 * @since 2 Sep 2020
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5558238161985653783L;
    private static final String DEFAULT_POSTFIX = " tidak ditemukan";
    private final String message;
    

    
    public DataNotFoundException(String parameter) {
        super(parameter);
        this.message = parameter;
    }

    public DataNotFoundException(String prefix, String position) {
        this.message = prefix + " di " + position + DEFAULT_POSTFIX;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
