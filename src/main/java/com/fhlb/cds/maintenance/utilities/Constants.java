package com.fhlb.cds.maintenance.utilities;

/**
 * This class defines constants for Advance prepayment fee type service and
 * report generator services
 */
public class Constants {

	/******************** Constants for reporting services ****************/
	public static final String FHLB_LOGO_PATH = "fhlbny_logo.jpg";
	public static final String REPORT_PROPERTY_FILE = "reportFile.properties";
	public static final String FILE_NAME = "Exclusion_Report";
	public static final String FILE = "File";
	public static final String MEDIA_TYPE_CSV = "text/csv";
	public static final String MEDIA_TYPE_XLS = "application/vnd.ms-excel";

	/******************** Application Service version constant ****************/
	public static final String SERVICE_VERSION_1 = "Accept=application/vnd.app.v1+json";

	public static final String DEFAULT_ENVIRONMENT = "development";
	public static final String SIT_ENVIRONMENT = "sit";
	public static final String PRODUCTION_ENVIRONMENT = "production";

	Constants() {
		/** Default constructor **/
	}

}
