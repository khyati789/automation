package com.fhlb.cds.maintenance.advanceexceptiontype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeController;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeResource;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeService;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;

@RunWith(MockitoJUnitRunner.class)
public class AdvanceExceptionTypeControllerTest { 

    @InjectMocks
    private AdvanceExceptionTypeController advanceExceptionTypeController;

    @Mock
    private AdvanceExceptionTypeService advanceExceptionTypeService;

    @Mock
    private ReportGenerator reportGenerator;

    AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();

    @Test
    public void testConstructorAdvanceController() {
        AdvanceExceptionTypeController advanceExceptionTypeController = new AdvanceExceptionTypeController(
                advanceExceptionTypeService, reportGenerator);
        assertNotSame(
                "validating constructor",
                advanceExceptionTypeController,
                new AdvanceExceptionTypeController(advanceExceptionTypeService, reportGenerator));

    }

    @Test
    public void testCreateAdvanceExceptionType() throws Exception {
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        when(advanceExceptionTypeService.createAdvanceExceptionTypeData(advanceExceptionTypeResource))
                .thenReturn(advanceExceptionTypeResource);
        assertEquals(
                "validating create advance exception type",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.createAdvanceExceptionType(advanceExceptionTypeResource));
    }

    @Test
    public void testUpdateAdvanceExceptionType() {
        when(advanceExceptionTypeService
                .updateAdvanceExceptionTypeData(12, advanceExceptionTypeResource))
                        .thenReturn(advanceExceptionTypeResource);
        assertEquals(
                "validating update advance exception type",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.updateAdvanceExceptionType(12, advanceExceptionTypeResource));

    }

    @Test
    public void testDeleteAdvanceExceptionType() {
        when(advanceExceptionTypeService
                .deleteAdvanceExceptionType(12)).thenReturn(advanceExceptionTypeResource);
        assertEquals(
                "validating delete advance exception type",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.deleteAdvanceExceptionType(12));

    }

    @Test
    public void testGetAdvanceExceptionTypeById() {
        when(advanceExceptionTypeService
                .getAdvanceExceptionTypeById(12)).thenReturn(advanceExceptionTypeResource);
        assertEquals(
                "validating get advance exception type by id",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.getAdvanceExceptionTypeById(12));

    }

    @Test
    public void testGetAdvanceExceptionTypeNull() throws FileNotFoundException {
        List<AdvanceExceptionTypeResource> advanceExceptionTypeResource = new ArrayList<>();
        when(advanceExceptionTypeService.getAdvanceExceptionTypeData()).thenReturn(advanceExceptionTypeResource);
        assertNotSame(
                "validating get advance exception type",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.getAdvanceExceptionTypeList(null));
    }

    @Test(expected = NullPointerException.class)
    public void testGetAdvanceExceptionType() throws FileNotFoundException {
        String reportData = null;
        ReportFileType report = null;
        when(reportGenerator.generateReport(
                "reportData",
                "exportType",
                "exceptionType.xsl",
                "Advance Exception Type List Report",
                advanceExceptionTypeService.getAdvanceExceptionTypeReportHeaders(),
                "AdvanceExceptionType List")).thenReturn(report);
        when(advanceExceptionTypeService.getReportData()).thenReturn(reportData);
        assertNotSame(
                "validating get advance exception type report data",
                advanceExceptionTypeResource,
                advanceExceptionTypeController.getAdvanceExceptionTypeList("exportType"));
    }
}
