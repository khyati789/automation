package com.fhlb.cds.maintenance.advancepurposetype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fhlb.cds.exception.CodeValueChangeException;
import com.fhlb.cds.exception.FieldValueDuplicateException;
import com.fhlb.cds.exception.LengthCheckException;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeDB;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeDao;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeMapper;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeResource;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeService;
import com.fhlb.commons.exception.FieldRequiredException;
import com.fhlb.commons.exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AdvancePurposeTypeServiceTest {

    @InjectMocks
    private static AdvancePurposeTypeService advancepurposeTypeService;

    @Mock
    private AdvancePurposeTypeDao advancePurposeTypeDao;

    @Mock
    private AdvancePurposeTypeMapper advancePurposeTypeMapper;

    AdvancePurposeTypeResource advancePurposeTypeResource = new AdvancePurposeTypeResource();
    AdvancePurposeTypeDB advancePurposeTypeDB = new AdvancePurposeTypeDB();

    @Test
    public void testAdvancePurposeTypeServiceConstructor() {
        AdvancePurposeTypeService advPurposeTypeService = new AdvancePurposeTypeService(
                advancePurposeTypeMapper, advancePurposeTypeDao);
        assertNotSame(
                "validate constructor",
                advPurposeTypeService,
                new AdvancePurposeTypeService(advancePurposeTypeMapper, advancePurposeTypeDao));
    }

    @Test
    public void testGetAdvancePurposeTypeData() {
        List<AdvancePurposeTypeDB> advPurposeTypeDB = new ArrayList<AdvancePurposeTypeDB>();
        List<AdvancePurposeTypeResource> advPurposeTypeResource = new ArrayList<AdvancePurposeTypeResource>();
        when(advancePurposeTypeDao.getAdvancePurposeTypeData()).thenReturn(advPurposeTypeDB);
        assertEquals(
                "validate get Advance Purpose Type",
                advPurposeTypeResource,
                advancepurposeTypeService.getAdvancePurposeTypeData());
    }

    @Test(expected = FieldRequiredException.class)
    public void testCreatePurposeType() throws Exception {
        when(advancePurposeTypeDao.createPurposeType(advancePurposeTypeDB)).thenReturn(advancePurposeTypeDB);
        assertNotSame(
                "validate create Purpose Type",
                advancePurposeTypeResource,
                advancepurposeTypeService.createPurposeType(advancePurposeTypeResource));
    }

    
    @Test(expected = FieldValueDuplicateException.class)
    public void testCreatePurposeTypeCode12() {
        AdvancePurposeTypeResource advPurposeTypeResource = new AdvancePurposeTypeResource();
        advPurposeTypeResource.setAdvPurposeTypeCode("A");
        when(advancePurposeTypeDao.getPurposeTypeCode("A")).thenReturn(true);
        assertNotSame(
                "validate duplicate advance purpose type code",
                advPurposeTypeResource,
                advancepurposeTypeService.createPurposeType(advPurposeTypeResource));
    }
    
    @Test(expected = LengthCheckException.class)
    public void testCreatePurposeTypeDescription() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("qqqq");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        advancePurposeTypeResource
                .setAdvPurposeTypeDescription(getStringValue(25));
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate create Purpose Type Description",
                advancePurposeTypeResource,
                advancepurposeTypeService.createPurposeType(advancePurposeTypeResource));
    }
    
    @Test(expected = NotFoundException.class)
    public void testUpdatePurposeType() {
        advancePurposeTypeDB.setId(15);
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertEquals(
                "validate update Purpose Type",
                advancePurposeTypeResource,
                advancepurposeTypeService.updatePurposeType(
                        advancePurposeTypeDB.getId(),
                        advancePurposeTypeResource));
    }

    @Test(expected = LengthCheckException.class)
    public void testUpdatePurposeTypeDescription() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("qqqq");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        advancePurposeTypeResource
                .setAdvPurposeTypeDescription(getStringValue(25));
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate update Purpose Type Description",
                advancePurposeTypeResource,
                advancepurposeTypeService.updatePurposeType(
                        advancePurposeTypeDB.getId(),
                        advancePurposeTypeResource));
    }

    @Test(expected = CodeValueChangeException.class)
    public void testUpdatePurposeTypeCode() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("123456");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("B");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123");
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate update Purpose Type Description",
                advancePurposeTypeResource,
                advancepurposeTypeService.updatePurposeType(
                        advancePurposeTypeDB.getId(),
                        advancePurposeTypeResource));
    }

    @Test
    public void testUpdatePurposeTypeAllData() {
        advancePurposeTypeDB.setAdvPurposeTypeCode("B");
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeDescription("123");
        advancePurposeTypeResource.setAdvPurposeTypeCode("B");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123456");
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate update Purpose Type",
                advancePurposeTypeResource,
                advancepurposeTypeService.updatePurposeType(
                        advancePurposeTypeDB.getId(),
                        advancePurposeTypeResource));
    }

    @Test(expected = NotFoundException.class)
    public void testDeletePurposeType() {
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeDB.setId(15);
        assertNotSame(
                "validate delete advance purpose type",
                advancePurposeTypeResource.getId(),
                advancepurposeTypeService.deletePurposeType(14));
    }

    @Test
    public void testDeletePurposeTypeId() {
        advancePurposeTypeDB.setAdvPurposeTypeCode("B");
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeDescription("123");
        advancePurposeTypeResource.setAdvPurposeTypeCode("B");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123456");
        when(advancePurposeTypeDao.getPurposeTypeId(14)).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate delete Purpose Type",
                advancePurposeTypeResource,
                advancepurposeTypeService.deletePurposeType(14));
    }

    @Test
    public void testGetAdvancePurposeTypeById() {
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("B");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123");
        advancePurposeTypeDB.setAdvPurposeTypeCode("B");
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeDescription("123");
        when(advancePurposeTypeDao.getPurposeTypeId(advancePurposeTypeDB.getId())).thenReturn(
                advancePurposeTypeDB);
        assertNotSame(
                "validate get Purpose Type by id",
                advancePurposeTypeResource,
                advancepurposeTypeService.getAdvancePurposeTypeById(14));
    }

    @Test
    public void testGetAdvancePurposeTypeReportHeaders() {
        assertEquals(
                "validate get advance purpose type report header",
                getAdvancePurposeTypeReportHeadersDummy(),
                advancepurposeTypeService.getAdvancePurposeTypeReportHeaders());
    }

    private static Map<String, String> getAdvancePurposeTypeReportHeadersDummy() {
        Map<String, String> reportHeaders = new LinkedHashMap<>();
        reportHeaders.put("advancePurposeTypeCode", "CODE");
        reportHeaders.put("advancePurposeTypeDescription", "DESCRIPTION");
        return reportHeaders;
    }

    @Test
    public void testGetReportData() {
        assertEquals("validate get report data", getReportDataDummy(), advancepurposeTypeService.getReportData());
    }

    private static String getReportDataDummy() {
        JSONObject records = new JSONObject();
        JSONArray report;
        List<AdvancePurposeTypeResource> advancePurposeTypeResources = advancepurposeTypeService
                .getAdvancePurposeTypeData();
        report = new JSONArray();
        for (AdvancePurposeTypeResource advancePurposeTypeResource : advancePurposeTypeResources) {
            report.put(advancePurposeTypeResource.toJson());
        }
        records.put("records", report);
        return records.toString();
    }
    
    @Test
    public void testCreatePurposeTypeCode() {
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        advancePurposeTypeResource
        .setAdvPurposeTypeDescription(getStringValue(5));
        when(advancePurposeTypeDao.getPurposeTypeCode("A")).thenReturn(false);
        assertNotSame(
                "validate duplicate advance purpose type code",
                advancePurposeTypeResource,
                advancepurposeTypeService.createPurposeType(advancePurposeTypeResource));
    }
    
    final  String getStringValue(int s){
        String sst="s";
        for (int i=0; i<s; i++)
            sst= sst+"s";
        return sst;
    }

}
