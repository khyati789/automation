package com.fhlb.cds.maintenance.advanceexceptiontype;

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

import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeDB;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeDao;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeMapper;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeResource;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeService;
import com.fhlb.commons.exception.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AdvanceExceptionTypeServiceTest {

    @InjectMocks
    private static AdvanceExceptionTypeService advanceExceptionTypeService;

    @Mock
    private AdvanceExceptionTypeDao advanceExceptionTypeDao;

    @Mock
    private AdvanceExceptionTypeMapper advanceExceptionTypeMapper;

    @Test
    public void testAdvanceExceptionTypeService() {
        AdvanceExceptionTypeService advanceExceptionTypeService = new AdvanceExceptionTypeService(
                advanceExceptionTypeDao, advanceExceptionTypeMapper);
        assertNotSame(
                "validating constructor",
                advanceExceptionTypeService,
                new AdvanceExceptionTypeService(advanceExceptionTypeDao, advanceExceptionTypeMapper));
    }

    @Test
    public void testGetAdvanceExceptionTypeData() {
        List<AdvanceExceptionTypeDB> advanceExceptionTypeDB = new ArrayList<AdvanceExceptionTypeDB>();
        List<AdvanceExceptionTypeResource> advanceExceptionTypeResource = new ArrayList<AdvanceExceptionTypeResource>();
        when(advanceExceptionTypeDao.getAdvanceExceptionTypeData()).thenReturn(advanceExceptionTypeDB);
        assertEquals(
                "validating get advance exception by data type",
                advanceExceptionTypeResource,
                advanceExceptionTypeService.getAdvanceExceptionTypeData());
    }

    @Test
    public void testCreateAdvanceExceptionTypeData() throws Exception {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        when(advanceExceptionTypeDao.createAdvanceExceptionType(advanceExceptionTypeMapper
                .fromResource(advanceExceptionTypeResource))).thenReturn(advanceExceptionTypeDB);
        assertNotSame(
                "validating create advance exceptiontype data",
                advanceExceptionTypeResource,
                advanceExceptionTypeService.createAdvanceExceptionTypeData(advanceExceptionTypeResource));

    }

    @Test
    public void testUpdateAdvanceExceptionTypeData() {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        when(advanceExceptionTypeDao.updateAdvanceExceptionType(advanceExceptionTypeDB))
                .thenReturn(advanceExceptionTypeDB);
        when(advanceExceptionTypeDao.getAdvanceExceptionTypeByExceptionTypeId(12))
                .thenReturn(advanceExceptionTypeDB);
        assertNotSame(
                "validating update advance exceptiontypedata",
                advanceExceptionTypeResource,
                advanceExceptionTypeService.updateAdvanceExceptionTypeData(12, advanceExceptionTypeResource));
    }

    @Test
    public void testDeleteAdvanceExceptionType() {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        when(advanceExceptionTypeMapper.fromEntity(advanceExceptionTypeDB))
                .thenReturn(advanceExceptionTypeResource);
        when(advanceExceptionTypeDao.getAdvanceExceptionTypeByExceptionTypeId(12))
                .thenReturn(advanceExceptionTypeDB);
        assertEquals(
                "validating delete advance exception type",
                advanceExceptionTypeResource,
                advanceExceptionTypeService.deleteAdvanceExceptionType(12));
    }

    @Test
    public void testGetAdvanceExceptionTypeReportHeaders() {
        assertEquals(
                "validating advance exception type report header",
                getAdvanceExceptionTypeReportHeadersDummy(),
                advanceExceptionTypeService.getAdvanceExceptionTypeReportHeaders());
    }

    @Test
    public void testGetReportData() {
        assertEquals(
                "validating advance exception type get report data",
                getReportDataDummy(),
                advanceExceptionTypeService.getReportData());
    }

    @Test(expected = NotFoundException.class)
    public void testGetAdvanceExceptionTypeById() {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        when(advanceExceptionTypeDao.getAdvanceExceptionTypeByExceptionTypeId(12))
                .thenReturn(advanceExceptionTypeDB);
        assertNotSame(
                "validating get advance exception type by id",
                advanceExceptionTypeResource,
                advanceExceptionTypeService.getAdvanceExceptionTypeById(12));
    }

    private static Map<String, String> getAdvanceExceptionTypeReportHeadersDummy() {
        Map<String, String> reportHeaders = new LinkedHashMap<>();
        reportHeaders.put("advanceExceptionTypeCode", "CODE");
        reportHeaders.put("advanceExceptionTypeDescription", "DESCRIPTION");
        return reportHeaders;
    }

    private static String getReportDataDummy() {
        JSONObject records = new JSONObject();
        JSONArray report;
        List<AdvanceExceptionTypeResource> advanceExceptionTypeResources = advanceExceptionTypeService
                .getAdvanceExceptionTypeData();
        report = new JSONArray();
        for (AdvanceExceptionTypeResource advanceExceptionTypeResource : advanceExceptionTypeResources) {
            report.put(advanceExceptionTypeResource.toJson());
        }
        records.put("records", report);
        return records.toString();

    }

    @Test(expected = NotFoundException.class)
    public void testdeleteExceptionTypeNotFoundException() {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = advanceExceptionTypeDao
                .getAdvanceExceptionTypeByExceptionTypeId(12);
        when(advanceExceptionTypeDao.getAdvanceExceptionTypeByExceptionTypeId(12))
                .thenReturn(advanceExceptionTypeDB);
        advanceExceptionTypeService.deleteAdvanceExceptionType(12);
    }

}
