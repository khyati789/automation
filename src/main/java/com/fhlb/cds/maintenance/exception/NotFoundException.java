package com.fhlb.cds.maintenance.exception;

import org.springframework.http.HttpStatus;

import com.fhlb.cds.maintenance.error.TermExceptionTypeError;
import com.fhlb.commons.exception.RestException;

public class NotFoundException
	extends RestException {

    public NotFoundException(Object resourceId) {
        super(TermExceptionTypeError.NOT_FOUND, HttpStatus.NOT_FOUND, resourceId);
    }
	
}
