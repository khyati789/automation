package com.fhlb.cds.maintenance.advancepurposetype;

/**
 * This class for controlling all rest services of Advance PurposeType screen
 */

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
import com.fhlb.commons.beans.ReportFileType;
import com.fhlb.commons.utils.FileOperation;
import com.fhlb.cds.maintenance.utilities.Constants;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;

@RestController
@RequestMapping("/maintenance/advance/purposetype")
public class AdvancePurposeTypeController {

	private AdvancePurposeTypeService advancePurposeTypeService;
	private ReportGenerator reportGenerator;

	@Autowired
	public AdvancePurposeTypeController(
			AdvancePurposeTypeService advancePurposeTypeService,
			ReportGenerator reportGenerator) {
		super();
		this.advancePurposeTypeService = advancePurposeTypeService;
		this.reportGenerator = reportGenerator;
	}

	/**
	 * Get the Advance purpose type List and generate report based on export
	 * type
	 * 
	 * @param exportType
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> getAdvancePurposeTypeList(
			@RequestParam(value = "exportType", required = false) String exportType) throws FileNotFoundException {
		if (exportType == null) {
			return new ResponseEntity<>(advancePurposeTypeService.getAdvancePurposeTypeData(), HttpStatus.OK);
		} else {
			String reportData = advancePurposeTypeService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "purposeType.xsl",
					"Advance-Purpose Type Report", advancePurposeTypeService.getAdvancePurposeTypeReportHeaders(),
					"Advance-Purpose Type");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}

	/**
	 * Create the new Advance purpose type record
	 * 
	 * @param advancePurposeTypeResource
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.CREATED)
	public AdvancePurposeTypeResource createPurposeType(
			@Validated @RequestBody AdvancePurposeTypeResource advPurposeTypeResource) {
		
		return advancePurposeTypeService.createPurposeType(advPurposeTypeResource);
	}

	/**
	 * Updating the Advance purpose type record from resource
	 * 
	 * @param advancePurposeTypeId
	 * @param advancePurposeTypeResource
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvancePurposeTypeResource updatePurposeType(@PathVariable int id,
			@RequestBody AdvancePurposeTypeResource advancePurposeTypeResource) {
		
		return (advancePurposeTypeService.updatePurposeType(id, advancePurposeTypeResource));
	}

	/**
	 * Delete the advance purpose type record based on advance purpose type id
	 * 
	 * @param advancePurposeTypeId
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvancePurposeTypeResource deletePurposeType(@PathVariable int id) {
		
		return (advancePurposeTypeService.deletePurposeType(id));
	}

	/**
	 * Get the particular advance purpose type record by advance purposeTypeId
	 * 
	 * @param advancePurposeTypeId
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvancePurposeTypeResource getAdvancePurposeTypeTypeById(@PathVariable int id) {
		
		return advancePurposeTypeService.getAdvancePurposeTypeById(id);
	}
}
