package com.fhlb.cds.maintenance.error;

import com.fhlb.commons.error.Error;

/**
 * Errors that are specific to the Advance Purpose Type API
 */

public enum TermMaintenanceError implements Error {

    NOT_FOUND(3688, ErrorMessage.NOT_FOUND), 
    CODE_REQUIRED(3644,ErrorMessage.CODE_REQUIRED),
    FUND_SOURCE_DESCRITION_LENGTH(3622,ErrorMessage.FUND_SOURCE_DESCRITION_LENGTH),
    CODE_DUPLICATE(3655,ErrorMessage.CODE_DUPLICATE);
    
    private final int code;
    private final String message;

    TermMaintenanceError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
