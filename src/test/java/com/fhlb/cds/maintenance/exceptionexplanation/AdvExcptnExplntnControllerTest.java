package com.fhlb.cds.maintenance.exceptionexplanation;

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

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnController;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnResource;
import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnService;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;

@RunWith(MockitoJUnitRunner.class)
public class AdvExcptnExplntnControllerTest {
    
    @InjectMocks
    private AdvExcptnExplntnController advExcptnExplntnController;
    
    @Mock
    private AdvExcptnExplntnService advExcptnExplntnService;
    
    private AdvExcptnExplntnResource advExcptnExplntnResource;
    
    @Mock
    private ReportGenerator reportGenerator;

    @Mock
    private HttpServletRequest request;
    
    @Test
    public void testAdvExcptnExplntnController() {
        AdvExcptnExplntnController advExcptnExplntnController = new AdvExcptnExplntnController(advExcptnExplntnService, reportGenerator);
        assertNotSame("Validate Advance Exception Explanation", advExcptnExplntnController ,new AdvExcptnExplntnController(advExcptnExplntnService, reportGenerator));
       }
    @Test
    public void testGetAdvExcptnExplntnById() {
        when(advExcptnExplntnService.getAdvExcptnExplntnById(50))
                .thenReturn(advExcptnExplntnResource);
        assertEquals("Validate Get Resource by Id", advExcptnExplntnController.getAdvExcptnExplntnById(50),
                advExcptnExplntnResource);
    }

    @Test
    public void testCreateAdvExcptnExplntn() {
        when(advExcptnExplntnService.createAdvExcptnExplntn(advExcptnExplntnResource))
                .thenReturn(advExcptnExplntnResource);
        assertEquals("Validate Save data", advExcptnExplntnController.createAdvExcptnExplntn(advExcptnExplntnResource),
                advExcptnExplntnResource);
    }

    @Test
    public void testUpdateAdvPrepymtFeeType(int id) {
        AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
        advExcptnExplntnResource.setAdvExcptnExplntnDesc("Test");
        when(advExcptnExplntnService.updateAdvExcptnExplntn(id,advExcptnExplntnResource))
                .thenReturn(advExcptnExplntnResource);
        assertEquals("Validate Save data", advExcptnExplntnController.updateAdvExcptnExplntn(50,advExcptnExplntnResource),
                advExcptnExplntnResource);
    }

    @Test
    public void testDeleteAdvPrepymtFeeType() {
        when(advExcptnExplntnService.deleteAdvExcptnExplntn(50)).thenReturn(advExcptnExplntnResource);
        assertEquals("Validate Delete data by id", advExcptnExplntnController.deleteAdvExcptnExplntn(50),
                advExcptnExplntnResource);
    }

    @Test // (expected = NullPointerException.class)
    public void testGetAdvPrepymtFeeTypeList() throws FileNotFoundException {
        String exportType = null;
        List<AdvExcptnExplntnResource> advExcptnExplntnResource = new ArrayList<AdvExcptnExplntnResource>();
        when(advExcptnExplntnService.getAdvExcptnExplntn()).thenReturn(advExcptnExplntnResource);
        assertNotSame("Validate NullPointerException on Prepayment Fee Type List ",
                advExcptnExplntnController.getAdvExcptnExplntnList(exportType), advExcptnExplntnResource);
    }

    @SuppressWarnings("rawtypes")
    @Test(expected = NullPointerException.class)
    public void testGetAdvExcptnExplntnListExportType() throws FileNotFoundException {
        String exportType = "pdf";
        String reportData = null;
        ReportFileType report = null;
        ResponseEntity r = new ResponseEntity<Object>(HttpStatus.OK);
        when(advExcptnExplntnService.getReportData()).thenReturn(reportData);
        when(reportGenerator.generateReport(reportData, exportType, "prepaymentList.xsl",
                "Validate Prepayment Fee Type List Report", advExcptnExplntnService.getListReportHeader(),
                "Validate Prepayment Fee Type List")).thenReturn(report);
        assertNotSame("Validate NullPointerException on Prepayment Fee Type List ",
                advExcptnExplntnController.getAdvExcptnExplntnList(exportType), r);
    }

}
