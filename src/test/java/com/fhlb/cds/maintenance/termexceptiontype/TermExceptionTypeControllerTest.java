package com.fhlb.cds.maintenance.termexceptiontype;

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

import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeResource;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeController;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeService;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;

@RunWith(MockitoJUnitRunner.class)
public class TermExceptionTypeControllerTest {

    @InjectMocks
    private TermExceptionTypeController termexceptiontypeController;

    @Mock
    private TermExceptionTypeService termexceptiontypeService;

    @Mock
    private ReportGenerator reportGenerator;

    TermExceptionTypeResource termExceptionTypeResource = new TermExceptionTypeResource();

    @Test
    public void testTermexceptiontypeController() {
        TermExceptionTypeController termexceptiontypeController = new TermExceptionTypeController(
                termexceptiontypeService, reportGenerator);
        assertNotSame(
                "validating constructor",
                termexceptiontypeController,
                new TermExceptionTypeController(termexceptiontypeService, reportGenerator));
    }

    @Test
    public void testCreateTermExceptionType() {
        TermExceptionTypeResource termexceptiontypeResource = new TermExceptionTypeResource();
        ;
        when(termexceptiontypeService.createTermexceptiontype(termexceptiontypeResource))
                .thenReturn(termexceptiontypeResource);
        assertEquals(
                "validating create term exception type",
                termexceptiontypeResource,
                termexceptiontypeController.createTermexceptiontype(termexceptiontypeResource));
    }

    @Test
    public void testUpdateTermExceptionType() {
        TermExceptionTypeResource termExceptionTypeResource = new TermExceptionTypeResource();
        when(termexceptiontypeService.updateTermexceptiontype(12, termExceptionTypeResource))
                .thenReturn(termExceptionTypeResource);
        assertEquals(
                "Validating update term exceptiontype",
                termExceptionTypeResource,
                termexceptiontypeController.updateTermexceptiontype(12, termExceptionTypeResource));
    }

    @Test
    public void testDeleteTermexceptiontypeById() {
        TermExceptionTypeResource termexceptiontypeResource = new TermExceptionTypeResource();
        when(termexceptiontypeService.deleteTermexceptiontype(12)).thenReturn(termexceptiontypeResource);
        assertEquals(
                "validating delete term Exception by id",
                termexceptiontypeResource,
                termexceptiontypeController.deleteTermexceptiontype(12));
    }

    @Test
    public void testGetTermexceptiontypeById() {
        TermExceptionTypeResource termexceptiontypeResource = new TermExceptionTypeResource();
        when(termexceptiontypeService.getTermexceptiontypeById(12)).thenReturn(termexceptiontypeResource);
        assertEquals(
                "validating get term Exception by id",
                termexceptiontypeResource,
              termexceptiontypeController.getTermexceptiontypeById(12));
    } 

    @Test
    public void testGetTermExceptionTypeNull() throws FileNotFoundException {
        List<TermExceptionTypeResource> termExceptionTypeResource = new ArrayList<>();
        when(termexceptiontypeService.getTermexceptiontype()).thenReturn(termExceptionTypeResource);
        assertNotSame(
                "validating get term exception type",
                termExceptionTypeResource,
                termexceptiontypeController.getTermExceptionTypeList(null));
    }

    @Test(expected = NullPointerException.class)
    public void testGetTermExceptionType() throws FileNotFoundException {
        String reportData = null;
        ReportFileType report = null;
        when(reportGenerator.generateReport(
                "reportData",
                "exportType",
                "termexceptionType.xsl",
                "Term-Exception Type List Report",
                termexceptiontypeService.getTermExceptionTypeReportHeaders(),
                "Term-ExceptionType List")).thenReturn(report);
        when(termexceptiontypeService.getReportData()).thenReturn(reportData);
        assertNotSame(
                "validating get advance exception type report data",
                termExceptionTypeResource,
                termexceptiontypeController.getTermExceptionTypeList("exportType"));
    }
}
