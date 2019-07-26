package com.fhlb.cds.maintenance.termexceptiontype;

/**
 * This class handels all http requests of TermExceptionType
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

import com.fhlb.cds.maintenance.utilities.Constants;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;
import com.fhlb.commons.utils.FileOperation;

@RestController
@RequestMapping("/maintenance/term/exceptiontype")
public class TermExceptionTypeController {

	private final TermExceptionTypeService termexceptiontypeService;
	private final ReportGenerator reportGenerator;

	@Autowired
	public TermExceptionTypeController(
			TermExceptionTypeService termexceptiontypeService,
			ReportGenerator reportGenerator) {
		super();
		this.termexceptiontypeService = termexceptiontypeService;
		this.reportGenerator = reportGenerator;
	}
 
	/**
	 * Get the data of term exception type List Generate the report based on
	 * export type
	 * 
	 * @param exportType
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> getTermExceptionTypeList(
			@RequestParam(value = "exportType", required = false) String exportType) throws FileNotFoundException {
		if (exportType == null) {
			return new ResponseEntity<>(termexceptiontypeService.getTermexceptiontype(), HttpStatus.OK);
		} else {
			String reportData = termexceptiontypeService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "termexceptionType.xsl",
					"Term-Exception Type Report", termexceptiontypeService.getTermExceptionTypeReportHeaders(),
					"Term-Exception Type");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}

	/**
	 * Get record by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public TermExceptionTypeResource getTermexceptiontypeById(@PathVariable int id) {
		
		return termexceptiontypeService.getTermexceptiontypeById(id);
	}

	/**
	 * Adding new record
	 * 
	 * @param termexceptiontypeResource
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public TermExceptionTypeResource createTermexceptiontype(
			@Validated @RequestBody TermExceptionTypeResource termexceptiontypeResource) {
		
		return termexceptiontypeService.createTermexceptiontype(termexceptiontypeResource);
	}

	/**
	 * Editing particular record
	 * 
	 * @param id
	 * @param termexceptiontypeResource
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public TermExceptionTypeResource updateTermexceptiontype(@PathVariable int id,
			@Validated @RequestBody TermExceptionTypeResource termexceptiontypeResource) {
		
		return termexceptiontypeService.updateTermexceptiontype(id, termexceptiontypeResource);
	}

	/**
	 * Deleting particular record
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public TermExceptionTypeResource deleteTermexceptiontype(@PathVariable int id) {
		
		return termexceptiontypeService.deleteTermexceptiontype(id);
	}
}
