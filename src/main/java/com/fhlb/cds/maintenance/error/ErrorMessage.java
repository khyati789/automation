package com.fhlb.cds.maintenance.error;

/**
 * Error messages that are specific to the CDS Admin API. The set of default
 * error messages for use in all APIs can be found in
 * {@link com.fhlb.commons.error.CommonErrorMessage}
 */

public class ErrorMessage {
    
    /** Advance Prepayment Fee Type*/
	public static final String RECORD_NOT_FOUND = "Record not found.";
    public static final String ADVPREPYMTFEECALCCODE_REQUIRED = "advPrepymtFeeCalcCode is required.";
    public static final String ADVPREPYMTFEECALCCODE_DUPLICATE = "advPrepymtFeeCalcCode is already exist.";
    public static final String ADVPREPYMTFEECALCCODE_TOO_LONG = "advPrepymtFeeCalcCode must be 3 characters.";
    public static final String ADVPREPYMTFEEDESC_REQUIRED = "advPrepymtFeeDesc is required.";
    public static final String ADVPREPYMTFEEDESC_TOO_LONG = "advPrepymtFeeDesc must be 30 characters or less.";
    public static final String NULL_FLAG = "select atleast one value for flag.";

    /** Advance Exception Type*/
    public static final String DESC_REQUIRED = "Description is Required";
    public static final String INVALID_ID = "id not found.";

    /** Purpose Type*/
    public static final String PURPOSE_TYPE_CODE_REQUIRED = "Code is Required";
    public static final String PURPOSE_TYPE_CODE_LENGTH = "Code must be 1 character";
    public static final String PURPOSE_TYPE_CODE_NOT_CHANGE = "Code can not be manipulate";
    public static final String PURPOSE_TYPE_DESC_REQUIRED = "Description is Required";
    public static final String PURPOSE_TYPE_DESC_TOO_LONG = "Description length between 1 to 20 characters or less";
    public static final String PURPOSE_TYPE_ID_NOT_FOUND = "Resource with id: \"%s\" was not found.";
    public static final String PURPOSE_TYPE_ID_DUPLICATE = "Resource with id: \"%s\"  is already present";
    public static final String PURPOSE_TYPE_CODE_DUPLICATE = "Resource with code: \"%s\"  is already present";

    /** Term Exception TYpe*/
    public static final String NOT_FOUND = "Record not found.";
    public static final String DUPLICATE_CODE = "Record already exist for CODE";
    public static final String DUPLICATE_NO = "Record already exist for NO";
    public static final String CODE_REQUIRED = "Code is required.";
    public static final String CODE_TOO_LONG = "Length of Code should not be more than 8";
    public static final String NO_TOO_LONG = "Length of No should not be more than 4";
    public static final String NO_REQUIRED = "Number is required";
    public static final String NO_INVALID = "No must be number only";
    public static final String DESC_TOO_LONG = "Length of Description should not be more than 70";
    ErrorMessage() {
        /** Default constructor **/
        
    }
    /** Fund Source Term*/
    public static final String FUND_SOURCE_DESCRITION_LENGTH = "Length must be 40 characters";
    public static final String CODE_DUPLICATE ="Term fund source code already exist";
    public static final String FUND_SOURCE_CODE_LENGTH ="Length of CODE should not be more than 1";

    /**Exception Explanation **/
    public static final String RECORD_ALREADY_EXIST = "Record already exist";
    public static final String NOT_NULL = "Explanation description should not be empty";
    public static final String MAX_LENGTH = "Length of EXPLANATION DESCRIPTION should not be more than 60";
    
}