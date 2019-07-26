package com.fhlb.cds.maintenance.error;
import com.fhlb.commons.error.Error;
public enum TermExceptionTypeError implements Error{

	NOT_FOUND(3544, ErrorMessage.NOT_FOUND),
	NO_REQUIRED(3588,ErrorMessage.NO_REQUIRED),
	CODE_REQUIRED(3588, ErrorMessage.CODE_REQUIRED),
	CODE_TOO_LONG(3522, ErrorMessage.CODE_TOO_LONG),
    DUPLICATE_CODE(3555,ErrorMessage.DUPLICATE_CODE),
    DUPLICATE_NO(3555,ErrorMessage.DUPLICATE_NO),
    DESC_TOO_LONG(3522,ErrorMessage.DESC_TOO_LONG);

	private final int code;
	private final String message;

	TermExceptionTypeError(int code, String message) {
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
