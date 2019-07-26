package com.fhlb.cds.exception;

import org.springframework.http.HttpStatus;

import com.fhlb.commons.error.Error;
import com.fhlb.commons.exception.RestException;

public class CodeValueChangeException extends RestException {

    private static final long serialVersionUID = -6290636678715813135L;

    public CodeValueChangeException(Error error, Object... messageArgs) {
        super(error, HttpStatus.BAD_REQUEST, messageArgs);
    }
}
