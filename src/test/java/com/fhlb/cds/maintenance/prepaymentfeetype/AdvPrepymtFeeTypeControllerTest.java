package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeController;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeResource;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeService;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;

@RunWith(MockitoJUnitRunner.class)
public class AdvPrepymtFeeTypeControllerTest {

	@InjectMocks
	private AdvPrepymtFeeTypeController advPrepymtFeeTypeController;

	@Mock
	private AdvPrepymtFeeTypeService advPrepymtFeeTypeService;

	private AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource;

	@Mock
	private ReportGenerator reportGenerator;

	@Mock
	private HttpServletRequest request;

	@Test
	public void testAdvPrepymtFeeTypeController() {
		AdvPrepymtFeeTypeController advPrepymtFeeTypeController = new AdvPrepymtFeeTypeController(
				advPrepymtFeeTypeService, reportGenerator);
		assertNotSame("Validate AdvPrepymtFeeTypeCOntroller", advPrepymtFeeTypeController,
				new AdvPrepymtFeeTypeController(advPrepymtFeeTypeService, reportGenerator));
	}

	@Test
	public void testGetAdvPrepymtFeeTypeById() {
		when(advPrepymtFeeTypeService.getAdvPrepymtFeeTypeById(50))
				.thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate Get Resource by Id", advPrepymtFeeTypeController.getAdvPrepymtFeeTypeById(50),
				advPrepymtFeeTypeResource);
	}

	@Test
	public void testCreateAdvPrepymtFeeType() {
		when(advPrepymtFeeTypeService.createAdvPrepymtFeeType(advPrepymtFeeTypeResource))
				.thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate Save data", advPrepymtFeeTypeController.createAdvPrepymtFeeType(advPrepymtFeeTypeResource),
				advPrepymtFeeTypeResource);
	}

	@Test
	public void testUpdateAdvPrepymtFeeType() {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
		advPrepymtFeeTypeResource.setId(12);
		when(advPrepymtFeeTypeService.updateAdvPrepymtFeeType(advPrepymtFeeTypeResource,50))
				.thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate Save data", advPrepymtFeeTypeController.updateAdvPrepymtFeeType(50,advPrepymtFeeTypeResource),
				advPrepymtFeeTypeResource);
	}

	@Test
	public void testDeleteAdvPrepymtFeeType() {
		when(advPrepymtFeeTypeService.deleteAdvPrepymtFeeType(50)).thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate Delete data by id", advPrepymtFeeTypeController.deleteAdvPrepymtFeeType(50),
				advPrepymtFeeTypeResource);
	}

	@Test // (expected = NullPointerException.class)
	public void testGetAdvPrepymtFeeTypeList() throws FileNotFoundException {
		String exportType = null;
		List<AdvPrepymtFeeTypeResource> advPrepymtFeeTypeResource = new ArrayList<AdvPrepymtFeeTypeResource>();
		when(advPrepymtFeeTypeService.getAllAdvPrepymtFeeType()).thenReturn(advPrepymtFeeTypeResource);
		assertNotSame("Validate NullPointerException on Prepayment Fee Type List ",
				advPrepymtFeeTypeController.getAdvPrepymtFeeTypeList(exportType), advPrepymtFeeTypeResource);
	}

	@SuppressWarnings("rawtypes")
	@Test(expected = NullPointerException.class)
	public void testGetAdvPrepymtFeeTypeListExportType() throws FileNotFoundException {
		String exportType = "pdf";
		String reportData = null;
		ReportFileType report = null;
		ResponseEntity r = new ResponseEntity<Object>(HttpStatus.OK);
		when(advPrepymtFeeTypeService.getReportData()).thenReturn(reportData);
		when(reportGenerator.generateReport(reportData, exportType, "prepaymentList.xsl",
				"Validate Prepayment Fee Type List Report", advPrepymtFeeTypeService.getListReportHeader(),
				"Validate Prepayment Fee Type List")).thenReturn(report);
		assertNotSame("Validate NullPointerException on Prepayment Fee Type List ",
				advPrepymtFeeTypeController.getAdvPrepymtFeeTypeList(exportType), r);
	}

}
