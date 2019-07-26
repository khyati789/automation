package com.fhlb.cds.maintenance.prepaymentfeetype;

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
import com.fhlb.commons.CustomException;
import com.fhlb.commons.beans.ReportFileType;
import com.fhlb.commons.utils.FileOperation;

@RestController
@RequestMapping("/maintenance/advance/prepaymentfeetype")
public class AdvPrepymtFeeTypeController {
	@Autowired
	private AdvPrepymtFeeTypeService advPrepymtFeeTypeService;

	private final ReportGenerator reportGenerator;

	public AdvPrepymtFeeTypeController(
			AdvPrepymtFeeTypeService advPrepymtFeeTypeService,
			ReportGenerator reportGenerator) {
		this.advPrepymtFeeTypeService = advPrepymtFeeTypeService;
		this.reportGenerator = reportGenerator;
	}

	/**
	 * get Advance Prepayment Fee Type By Id
	 *
	 * @param id
	 *            to fetch the specific record
	 * @return advPrepymtFeeTypeResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvPrepymtFeeTypeResource getAdvPrepymtFeeTypeById(@PathVariable(required = true) int id) {
		
		return advPrepymtFeeTypeService.getAdvPrepymtFeeTypeById(id);
	}

	/**
	 * Insert Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeResource
	 * @return advPrepymtFeeTypeResource
	 */
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.CREATED)
	public AdvPrepymtFeeTypeResource createAdvPrepymtFeeType(
			@Validated @RequestBody AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource) {
		
		return advPrepymtFeeTypeService.createAdvPrepymtFeeType(advPrepymtFeeTypeResource);
	}

	/**
	 * Update Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeResource
	 * @return advPrepymtFeeTypeResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvPrepymtFeeTypeResource updateAdvPrepymtFeeType(@PathVariable(required = true) int id,
			@Validated @RequestBody AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource) {
		advPrepymtFeeTypeResource.setId(id);
		
		return advPrepymtFeeTypeService.updateAdvPrepymtFeeType(advPrepymtFeeTypeResource, id);
	}

	/**
	 * Delete Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeCalcCode
	 * @return advPrepymtFeeTypeResource
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	@ResponseStatus(value = HttpStatus.OK)
	public AdvPrepymtFeeTypeResource deleteAdvPrepymtFeeType(@PathVariable int id) {
		
		return advPrepymtFeeTypeService.deleteAdvPrepymtFeeType(id);
	}

	/**
	 * Retrieve list of Prepayment Fee type list or retrieve report
	 *
	 * @param exportType
	 *            type of report to export (pdf, csv, xsl)
	 * @return
	 * @throws CustomException
	 * @throws FileNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = Constants.SERVICE_VERSION_1)
	public ResponseEntity<Object> getAdvPrepymtFeeTypeList(
			@RequestParam(value = "exportType", required = false) String exportType) throws FileNotFoundException {
		if (exportType == null) {
			return new ResponseEntity<>(advPrepymtFeeTypeService.getAllAdvPrepymtFeeType(), HttpStatus.OK);
		} else {
			String reportData = advPrepymtFeeTypeService.getReportData();
			ReportFileType report = reportGenerator.generateReport(reportData, exportType, "prepaymentList.xsl",
					"Advance-Prepayment Fee Type Report", advPrepymtFeeTypeService.getListReportHeader(),
					"Advance-Prepayment Fee");
			FileOperation inputStream = new FileOperation(report.getReportFile());
			
			return new ResponseEntity<>(new InputStreamResource(inputStream), report.getHttpHeader(), HttpStatus.OK);
		}
	}

}