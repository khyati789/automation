package com.fhlb.cds.maintenance.advancepurposetype;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeController;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeResource;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeService;
import com.fhlb.cds.maintenance.utilities.ReportGenerator;
import com.fhlb.commons.beans.ReportFileType;

@RunWith(MockitoJUnitRunner.class)
public class AdvancePurposeTypeControllerTest {

    @InjectMocks
    AdvancePurposeTypeController advancePurposeTypeController;

    @Mock
    AdvancePurposeTypeService advancePurposeTypeService;

    @Mock
    ReportGenerator reportGenerator;

    AdvancePurposeTypeResource advancePurposeTypeResource = new AdvancePurposeTypeResource();

    @Test
    public void testAdvancePurposeTypeControllerConstructor() {
        AdvancePurposeTypeController advancePurposeTypeController = new AdvancePurposeTypeController(
                advancePurposeTypeService, reportGenerator);
        assertNotSame(
                "validate contructor",
                advancePurposeTypeController,
                new AdvancePurposeTypeController(advancePurposeTypeService, reportGenerator));
    }

    @Test
    public void testCreatePurposeType() throws Exception {

        when(advancePurposeTypeService.createPurposeType(advancePurposeTypeResource))
                .thenReturn(advancePurposeTypeResource);
        assertEquals(
                "validate create purpose type",
                advancePurposeTypeResource,
                advancePurposeTypeController.createPurposeType(advancePurposeTypeResource));
    }

    @Test
    public void testUpdatePurposeType() {
        when(advancePurposeTypeService.updatePurposeType(14, advancePurposeTypeResource))
                .thenReturn(advancePurposeTypeResource);
        assertEquals(
                "validate update purpose type",
                advancePurposeTypeResource,
                advancePurposeTypeController.updatePurposeType(14, advancePurposeTypeResource));
    }

    @Test
    public void testDeletePurposeType() {
        when(advancePurposeTypeService.deletePurposeType(14)).thenReturn(advancePurposeTypeResource);
        assertEquals(
                "validate delete purpose type",
                advancePurposeTypeResource,
                advancePurposeTypeController.deletePurposeType(14));
    }

    @Test
    public void testGetAdvancePurposeTypeList() throws FileNotFoundException {
        ResponseEntity<Object> reponseEntity = new ResponseEntity<>(HttpStatus.OK);
        List<AdvancePurposeTypeResource> advancePurposeTypeResource = new ArrayList<AdvancePurposeTypeResource>();
        when(advancePurposeTypeService.getAdvancePurposeTypeData()).thenReturn(advancePurposeTypeResource);
        assertNotSame(
                "validate get advance purpose type list",
                reponseEntity,
                advancePurposeTypeController.getAdvancePurposeTypeList(null));
    }

    @Test(expected = NullPointerException.class)
    public void testGetReportAdvancePurposeTypeList() throws FileNotFoundException {
        ResponseEntity<Object> reponseEntity = new ResponseEntity<>(HttpStatus.OK);
        String reportData = null;
        ReportFileType reportFileType = new ReportFileType();
        when(advancePurposeTypeService.getReportData()).thenReturn(reportData);
        when(reportGenerator.generateReport(
                reportData,
                "pdf",
                "purposeType.xsl",
                "Advance Purpose Type List Report",
                advancePurposeTypeService.getAdvancePurposeTypeReportHeaders(),
                "AdvancePurposeType List")).thenReturn(reportFileType);

        assertNotSame(
                "validate report generate type",
                reponseEntity,
                advancePurposeTypeController.getAdvancePurposeTypeList("pdf"));
    }

    @Test
    public void testGetAdvancePurposeTypeById() {
        when(advancePurposeTypeService.getAdvancePurposeTypeById(14)).thenReturn(advancePurposeTypeResource);
        assertEquals(
                "validate delete purpose type",
                advancePurposeTypeResource,
                advancePurposeTypeController.getAdvancePurposeTypeTypeById(14));
    }
}
