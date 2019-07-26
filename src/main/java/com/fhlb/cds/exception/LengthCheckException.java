package com.fhlb.cds.exception;

/**
 * This exception should be thrown when a user-provided resource length 
 * 
 */

import org.springframework.http.HttpStatus;
import com.fhlb.commons.error.Error;
import com.fhlb.commons.exception.RestException;

public class LengthCheckException extends RestException {
    private static final long serialVersionUID = -6290636678715813135L;

    public LengthCheckException(Error error, Object... messageArgs) {
        super(error, HttpStatus.BAD_REQUEST, messageArgs);
    }

}
