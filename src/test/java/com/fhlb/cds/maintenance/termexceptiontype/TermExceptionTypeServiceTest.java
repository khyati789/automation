package com.fhlb.cds.maintenance.termexceptiontype;

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

import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeDB;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeMapper;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeResource;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeDao;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeService;
import com.fhlb.commons.exception.FieldRequiredException;

@RunWith(MockitoJUnitRunner.class)
public class TermExceptionTypeServiceTest {

    @InjectMocks
    private TermExceptionTypeService termexceptiontypeService;

    @Mock
    private TermExceptionTypeDao termexceptiontypeDao;

    @Mock
    private TermExceptionTypeMapper termexceptiontypeMapper;

    @Test
    public void testTermExceptionTypeService() {
        TermExceptionTypeService termexceptiontypeService = new TermExceptionTypeService(termexceptiontypeDao,
                termexceptiontypeMapper);
        assertNotSame(
                "validaiting TermExceptionTypeService validating",
                termexceptiontypeService,
                new TermExceptionTypeService(termexceptiontypeDao, termexceptiontypeMapper));
    }

    @Test
    public void testGetTermExceptiontype() {
        List<TermExceptionTypeDB> termExceptionTypeDBList = new ArrayList<>();
        List<TermExceptionTypeResource> termExceptionTypeResourceList = new ArrayList<>();
        when(termexceptiontypeDao.getAllTermexceptiontype()).thenReturn(termExceptionTypeDBList);
        assertNotSame(
                "validating Get Term ExceptionType",
                termExceptionTypeResourceList,
                termexceptiontypeService.getTermexceptiontype());
    }

    @Test(expected = FieldRequiredException.class)
    public void testCreateTermexceptiontype2() {
        TermExceptionTypeResource termexceptiontypeResource = new TermExceptionTypeResource();
        termexceptiontypeResource.setTermExceptionTypeCode("ABBBBBBBBBBBBBBBB");
        assertNotSame(
                termexceptiontypeService.createTermexceptiontype(termexceptiontypeResource),
                 termexceptiontypeResource);
    }

    @Test(expected = FieldRequiredException.class)
    public void testCreateTermexceptiontypeDuplicate() {
        TermExceptionTypeResource termexceptiontypeResource = new TermExceptionTypeResource();
        termexceptiontypeResource.setTermExceptionTypeCode(
                "gfreugrtghtruguhgrtughuyrtughhfjdbjhfgkrutrhvbvuygkjvdbruytgrbuyvtguse");
        when(
                termexceptiontypeDao.getTermExceptionTypeCode(
                        "gfreugrtghtruguhgrtughuyrtughhfjdbjhfgkrutrhvbvuygkjvdbruytgrbuyvtguse"))
                                .thenReturn(false);
        termexceptiontypeResource.setTermExceptionTypeDescription(
                "gfreugrtghtruguhgrtughuyrtughhfjdbjhfgkrutrhvbvuygkjvdbruytgrbuyvtguse");

        assertNotSame(
                termexceptiontypeService.createTermexceptiontype(termexceptiontypeResource),
                termexceptiontypeResource);
    }
    /*
     * @Test public void testCreateTermExceptionTypeData() { TermExceptionTypeDB
     * termExceptionTypeDB = new TermExceptionTypeDB();
     * TermExceptionTypeResource termExceptionTypeResource = new
     * TermExceptionTypeResource(); when(
     * termexceptiontypeService.createTermexceptiontype(
     * termexceptiontypeMapper.fromTermExceptionTypeEntity(termExceptionTypeDB))
     * ) .thenReturn(termExceptionTypeResource); assertNotSame(
     * "validating create Term exceptiontype data", termExceptionTypeResource,
     * termexceptiontypeService.createTermexceptiontype(
     * termExceptionTypeResource));
     * 
     * }
     */

    @Test
    public void testGetListReportHeader() {
        assertNotSame(
                "validating GetListReportHeaders",
                getListReportHeaderDummy(),
                termexceptiontypeService.getTermExceptionTypeReportHeaders());
    }

    @Test
    public void testGetReportData() {
        assertEquals("validating Report data", getReportDataTestDummy(), termexceptiontypeService.getReportData());
    }

    public static Map<String, String> getListReportHeaderDummy() {
        Map<String, String> reportHeaders = new LinkedHashMap<>();
        reportHeaders.put("termExceptionTypeCode", "CODE");
        reportHeaders.put("termExceptionTypeNo", "NO");
        reportHeaders.put("termExceptionTypeDescription", "Description");
        return reportHeaders;
    }

    public String getReportDataTestDummy() {
        JSONObject records = new JSONObject();
        JSONArray report;
        List<TermExceptionTypeResource> termExceptionTypeResources = termexceptiontypeService
                .getTermexceptiontype();
        report = new JSONArray();
        for (TermExceptionTypeResource termExceptionTypeResource : termExceptionTypeResources) {
            report.put(termExceptionTypeResource.toJson());
        }
        records.put("records", report);
        return records.toString();

    }

}
