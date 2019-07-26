package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeDB;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeDao;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeMapper;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeResource;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeService;
import com.fhlb.commons.exception.FieldRequiredException;

@RunWith(MockitoJUnitRunner.class)
public class AdvPrepymtFeeTypeServiceTest {

	@InjectMocks
	private AdvPrepymtFeeTypeService advPrepymtFeeTypeService;

	@Mock
	private AdvPrepymtFeeTypeDao advPrepymtFeeTypeDao;

	@Mock
	private AdvPrepymtFeeTypeMapper advPrepymtFeeTypeMapper;

	@Test
	public void testGetAdvPrepymtFeeTypeById() {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
		when(advPrepymtFeeTypeService.getAdvPrepymtFeeTypeById(50)).thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate get prepayment fee type by Id", advPrepymtFeeTypeService.getAdvPrepymtFeeTypeById(50),
				advPrepymtFeeTypeResource);
	}

	@Test
	public void testCreateAdvPrepymtFeeType() {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
		advPrepymtFeeTypeResource.setAdvPrepymtFeeCalcCode("TET");
        advPrepymtFeeTypeResource.setAdvPrepymtFeeDesc("Testing");
        advPrepymtFeeTypeResource.setActFeeCalcFlag("Y");
        advPrepymtFeeTypeResource.setActReplRateFlag("Y");
        advPrepymtFeeTypeResource.setIndFeeCalcFlag("Y");
		when(advPrepymtFeeTypeService.createAdvPrepymtFeeType(advPrepymtFeeTypeResource))
				.thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate create new record in prepayment fee type",
				advPrepymtFeeTypeService.createAdvPrepymtFeeType(advPrepymtFeeTypeResource), advPrepymtFeeTypeResource);
	}

	@Test
	public void testUpdateAdvPrepymtFeeType() {
        AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
        advPrepymtFeeTypeResource.setAdvPrepymtFeeCalcCode("TET");
        advPrepymtFeeTypeResource.setAdvPrepymtFeeDesc("Testing");
        advPrepymtFeeTypeResource.setActFeeCalcFlag("Y");
        advPrepymtFeeTypeResource.setActReplRateFlag("Y");
        advPrepymtFeeTypeResource.setIndFeeCalcFlag("Y");
		when(advPrepymtFeeTypeService.updateAdvPrepymtFeeType(advPrepymtFeeTypeResource,50))
				.thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate update record in prepayment fee type",
				advPrepymtFeeTypeService.updateAdvPrepymtFeeType(advPrepymtFeeTypeResource,50), advPrepymtFeeTypeResource);
	}

	@Test
	public void testDeleteAdvPrepymtFeeType() {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
		AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB = new AdvPrepymtFeeTypeDB();
		when(advPrepymtFeeTypeDao.getAdvPrepymtFeeTypeById(50)).thenReturn(advPrepymtFeeTypeDB);
		when(advPrepymtFeeTypeService.deleteAdvPrepymtFeeType(50)).thenReturn(advPrepymtFeeTypeResource);
		assertEquals("Validate delete record in prepayment fee type by id", advPrepymtFeeTypeService.deleteAdvPrepymtFeeType(50),
				advPrepymtFeeTypeResource);
	}

	@Test
	public void testGetAllAdvPrepymtFeeType() {
		List<AdvPrepymtFeeTypeResource> advPrepymtFeeTypeResources = new ArrayList<AdvPrepymtFeeTypeResource>();
		List<AdvPrepymtFeeTypeDB> advPrepymtFeeTypeDBs = new ArrayList<AdvPrepymtFeeTypeDB>();
		when(advPrepymtFeeTypeService.getAllAdvPrepymtFeeType()).thenReturn(advPrepymtFeeTypeResources);
		when(advPrepymtFeeTypeDao.getAdvPrepymtFeeType()).thenReturn(advPrepymtFeeTypeDBs);
		assertEquals("Validate get all prepayment fee type", advPrepymtFeeTypeService.getAllAdvPrepymtFeeType(),
				advPrepymtFeeTypeResources);
	}

	@Test
	public void testGetListReportHeader() {
		assertEquals("Validate get Prepayment fee type report header ", getListReportHeaderDummy(),
				advPrepymtFeeTypeService.getListReportHeader());
	}

	@Test
	public void testGetReportData() {
		assertTrue("Validate get prepayment fee type report data ",
				advPrepymtFeeTypeService.getReportData().contains("records"));
	}

	public Map<String, String> getListReportHeaderDummy() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("code", "Code");
		reportHeaders.put("desc", "Description");
		reportHeaders.put("indFeeCalcFlag", "Ind Fee Calc Flag");
		reportHeaders.put("actFeeCalcFlag", "Act Fee Calc Flag");
		reportHeaders.put("actReplRateFlag", "Act Repl Rate Flag");

		return reportHeaders;
	}

}
