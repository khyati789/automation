package com.fhlb.cds.maintenance.termfundsource;

import java.io.FileNotFoundException;

/**
 * This class for controlling all rest services of TermFundSource screen
 */

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

@RestController
@RequestMapping("maintenance/term/fundsource")
public class TermFundSourceController {

	private final TermFundSourceService termFundSourceService;
	private ReportGenerator reportGenerator;

	@Autowired
	public TermFundSourceController(
			TermFundSourceService termFundSourceService, ReportGenerator reportGenerator) {
		this.termFundSourceService = termFundSourceService;
		this.reportGenerator = reportGenerator;
	}

	/**
	 * Get the Term Fund Source and generate report based on export type
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
			return new ResponseEntity<>(termFundSourceService.getTermFundSource(), HttpStatus.OK);
		} else {
			String reportData = termFundSourceService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "termFundSource.xsl",
					"Term-Fund Source Report", termFundSourceService.getTermFundSourceReportHeaders(),
					"Term-Fund Source");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}

	/**
	 * Get the particular term fund source record by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public TermFundSourceResource getTermFundSourceById(@PathVariable int id) {
		
		return termFundSourceService.getTermFundSourceById(id);
	}

	/**
	 * Create the new Term Fund Source record
	 * 
	 * @param termFundSourceResource
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.CREATED)
	public TermFundSourceResource createTermFundSource(
			@Validated @RequestBody TermFundSourceResource termFundSourceResource) {
		
		return termFundSourceService.createTermFundSource(termFundSourceResource);
	}

	/**
	 * Updating the Term Fund Source record from resource
	 * 
	 * @param id
	 * @param termFundSourceResource
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public TermFundSourceResource updateTermFundSource(@PathVariable int id,
			@Validated @RequestBody TermFundSourceResource termFundSourceResource) {
		
		return termFundSourceService.updateTermFundSource(id, termFundSourceResource);
	}

	/**
	 * Delete the Term Fund Source record based on id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public TermFundSourceResource deleteTermFundSource(@PathVariable int id) {
		
		return termFundSourceService.deleteTermFundSource(id);
	}

}