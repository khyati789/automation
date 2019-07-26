package com.fhlb.cds.maintenance.error;

import com.fhlb.commons.error.Error;


/**
 * Errors that are specific to the CDS Admin API
 */
public enum AdvanceMaintenanceError implements Error {
	NOT_NULL(4388,ErrorMessage.NOT_NULL),
	MAX_LENGTH(4322,ErrorMessage.MAX_LENGTH),
	RECORD_ALREADY_EXIST(4355,ErrorMessage.RECORD_ALREADY_EXIST),
    ADVPREPYMTFEECALCCODE_REQUIRED(2000,ErrorMessage.CODE_REQUIRED),
    ADVPREPYMTFEECALCCODE_TOO_LONG(2001,ErrorMessage.ADVPREPYMTFEECALCCODE_TOO_LONG),
    ADVPREPYMTFEECALCCODE_DUPLICATE(2002,ErrorMessage.ADVPREPYMTFEECALCCODE_DUPLICATE),
    ADVPREPYMTFEEDESC_REQUIRED(3000,ErrorMessage.ADVPREPYMTFEEDESC_REQUIRED),
    ADVPREPYMTFEEDESC_TOO_LONG(3001,ErrorMessage.ADVPREPYMTFEEDESC_TOO_LONG),
    INVALID_ID(3002,ErrorMessage.INVALID_ID),
    RECORD_NOT_FOUND(3003,ErrorMessage.RECORD_NOT_FOUND),
    NULL_FLAG(4000,ErrorMessage.NULL_FLAG),
    PURPOSE_TYPE_CODE_REQUIRED(2000, ErrorMessage.PURPOSE_TYPE_CODE_REQUIRED), PURPOSE_TYPE_CODE_LENGTH(2001,
            ErrorMessage.PURPOSE_TYPE_CODE_LENGTH), PURPOSE_TYPE_CODE_DUPLICATE(2002,
                    ErrorMessage.PURPOSE_TYPE_CODE_DUPLICATE), PURPOSE_TYPE_DESC_REQUIRED(3000,
                            ErrorMessage.PURPOSE_TYPE_DESC_REQUIRED), PURPOSE_TYPE_DESC_TOO_LONG(3001,
                                    ErrorMessage.PURPOSE_TYPE_DESC_TOO_LONG), PURPOSE_TYPE_ID_NOT_FOUND(4000,
                                            ErrorMessage.PURPOSE_TYPE_ID_NOT_FOUND), PURPOSE_TYPE_ID_DUPLICATE(
                                                    4001,
                                                    ErrorMessage.PURPOSE_TYPE_ID_DUPLICATE), PURPOSE_TYPE_CODE_NOT_CHANGE(
                                                            4001, ErrorMessage.PURPOSE_TYPE_CODE_NOT_CHANGE);

    private final int code;
    private final String message;

    AdvanceMaintenanceError(int code, String message) {
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
