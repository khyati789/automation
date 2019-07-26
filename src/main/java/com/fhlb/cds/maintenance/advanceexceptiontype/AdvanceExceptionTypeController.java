package com.fhlb.cds.maintenance.advanceexceptiontype;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fhlb.cds.maintenance.utilities.Constants;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;
import com.fhlb.commons.utils.FileOperation;

/**
 * This class for controlling all rest services of Advance ExceptionType screen
 *
 * @author o-doraba
 *
 */
@RestController
@RequestMapping("maintenance/advance")
public class AdvanceExceptionTypeController {

	private AdvanceExceptionTypeService advanceExceptionTypeService;
	private ReportGenerator reportGenerator;

	@Autowired
	public AdvanceExceptionTypeController(
			AdvanceExceptionTypeService advanceExceptionTypeService,
			ReportGenerator reportGenerator) {
		super();
		this.advanceExceptionTypeService = advanceExceptionTypeService;
		this.reportGenerator = reportGenerator;
	}

	/**
	 * Get the Advanceexception type List and genrate report based on export
	 * type
	 *
	 * @param exportType
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/exceptiontype", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> getAdvanceExceptionTypeList(
			@RequestParam(value = "exportType", required = false) String exportType) throws FileNotFoundException {
		if (exportType == null) {
			return new ResponseEntity<>(advanceExceptionTypeService.getAdvanceExceptionTypeData(), HttpStatus.OK);
		} else {
			String reportData = advanceExceptionTypeService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "exceptionType.xsl",
					"Advance-Exception Type Report", advanceExceptionTypeService.getAdvanceExceptionTypeReportHeaders(),
					"Advance-Exception Type");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}

	/**
	 * Create the new Advance exception type record
	 *
	 * @param advanceExceptionTypeResource
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exceptiontype", 
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.CREATED)
	public AdvanceExceptionTypeResource createAdvanceExceptionType(
			@Validated @RequestBody AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		
		return advanceExceptionTypeService.createAdvanceExceptionTypeData(advanceExceptionTypeResource);
	}

	/**
	 * Updating the Advance exception type record from resource
	 *
	 * @param advanceExceptionTypeId
	 * @param advanceExceptionTypeResource
	 * @return
	 */
	@RequestMapping(value = "/exceptiontype/{advanceExceptionTypeId}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvanceExceptionTypeResource updateAdvanceExceptionType(@PathVariable int advanceExceptionTypeId,
			@Validated @RequestBody AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		
		return advanceExceptionTypeService.updateAdvanceExceptionTypeData(advanceExceptionTypeId,
				advanceExceptionTypeResource);
	}

	/**
	 * Delete the advance exception type record based on advance exception type
	 * id
	 *
	 * @param advanceExceptionTypeId
	 * @return
	 */
	@RequestMapping(value = "/exceptiontype/{advanceExceptionTypeId}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvanceExceptionTypeResource deleteAdvanceExceptionType(@PathVariable int advanceExceptionTypeId) {
		
		return advanceExceptionTypeService.deleteAdvanceExceptionType(advanceExceptionTypeId);
	}

	/**
	 * Get the particular advance exception type record by advance
	 * exceptionTypeId
	 *
	 * @param advanceExceptionTypeId
	 * @return
	 */
	@RequestMapping(value = "/exceptiontype/{advanceExceptionTypeId}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvanceExceptionTypeResource getAdvanceExceptionTypeById(@PathVariable int advanceExceptionTypeId) {

		return advanceExceptionTypeService.getAdvanceExceptionTypeById(advanceExceptionTypeId);

	}

}
