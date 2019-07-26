package com.fhlb.cds.maintenance.exceptionexplanation;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * 
 * @author o-rajput
 *
 */
@RestController
@RequestMapping("maintenance/advance/exceptionexplanation")
public class AdvExcptnExplntnController {

	@Autowired
	private AdvExcptnExplntnService advExcptnExplntnService;

	private final ReportGenerator reportGenerator;

	public AdvExcptnExplntnController(
			AdvExcptnExplntnService advExcptnExplntnService,
			ReportGenerator reportGenerator) {
		this.advExcptnExplntnService = advExcptnExplntnService;
		this.reportGenerator = reportGenerator;
	}

	/**
	 * Get Exception Explanation by id
	 * 
	 * @param id
	 * @return advExcptnExplntnResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvExcptnExplntnResource getAdvExcptnExplntnById(@PathVariable(required = true) int id) {
		
		return advExcptnExplntnService.getAdvExcptnExplntnById(id);
	}

	/**
	 * Create Exception Explanation Description
	 * 
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnResource
	 */
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.CREATED)
	public AdvExcptnExplntnResource createAdvExcptnExplntn(
			@RequestBody AdvExcptnExplntnResource advExcptnExplntnResource) {
		
		return advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource);
	}

	/**
	 * Update Exception Explanation Description by id
	 * 
	 * @param id
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvExcptnExplntnResource updateAdvExcptnExplntn(@PathVariable(required = true) int id,
			@RequestBody AdvExcptnExplntnResource advExcptnExplntnResource) {
		
		return advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource);
	}

	/**
	 * Delete Exception Explanation Description by id
	 * 
	 * @param id
	 * @return advExcptnExplntnResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvExcptnExplntnResource deleteAdvExcptnExplntn(@PathVariable(required = true) int id) {
		
		return advExcptnExplntnService.deleteAdvExcptnExplntn(id);
	}

	/**
	 * Get list of Exception Explanation Description & generating reports
	 * according to exportType
	 * 
	 * @param exportType
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	public ResponseEntity<Object> getAdvExcptnExplntnList(
			@RequestParam(value = "exportType", required = false) String exportType) throws FileNotFoundException {
		if (exportType == null) {
			return new ResponseEntity<>(advExcptnExplntnService.getAdvExcptnExplntn(), HttpStatus.OK);
		} else {
			String reportData = advExcptnExplntnService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "exceptionList.xsl",
					"Advance-Exception Explanation Report", advExcptnExplntnService.getListReportHeader(),
					"Advance-Exception Explanation");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}
}