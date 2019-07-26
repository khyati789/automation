package com.fhlb.cds.maintenance.termexceptiontype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeResource;

public class TermExceptionTypeResourceTest {

    @Test
    public void termExceptionTypeResourceTest() {
        TermExceptionTypeResource termExceptionTypeResource=new TermExceptionTypeResource();
        String code="AAAAA";
        short no=12;
        String desc="ASDFgfd";
        termExceptionTypeResource.setId(12);
        assertEquals("validating termExceptionTypeId",12,termExceptionTypeResource.getId());
        termExceptionTypeResource.setTermExceptionTypeCode(code);
        assertEquals("validating termExceptionTypeCode",code,termExceptionTypeResource.getTermExceptionTypeCode());
        termExceptionTypeResource.setTermExceptionTypeNo(no);
        assertEquals("validating termExceptionTypeNO",no,termExceptionTypeResource.getTermExceptionTypeNo());
        termExceptionTypeResource.setTermExceptionTypeDescription(desc);
        assertEquals("validating termExceptionTypeDesc",desc,termExceptionTypeResource.getTermExceptionTypeDescription());
        assertNotSame("validatiing json",toJsonDummy(),termExceptionTypeResource.toJson());
    }
    static JSONObject toJsonDummy() {
        Map<String,Object> map = new HashMap<>();
        map.put("termExceptionTypeCode", "termExceptionTypeCode");
        map.put("termExceptionTypeNo",123);
        map.put("termExceptionTypeDescription", "advanceExceptionTypeDescription");
        return new JSONObject(map);
    }

}
