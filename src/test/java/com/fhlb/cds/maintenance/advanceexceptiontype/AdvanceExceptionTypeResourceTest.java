package com.fhlb.cds.maintenance.advanceexceptiontype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeResource;

public class AdvanceExceptionTypeResourceTest {
    @Test
    public void advanceExceptionTypeTest() {
        AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
        String code = "TTT";
        String desc = "Testing purpose";
        advanceExceptionTypeResource.setId(12);
        assertEquals("Validating advanceExceptionTypeId", 12, advanceExceptionTypeResource.getId());
        advanceExceptionTypeResource.setAdvanceExceptionTypeCode(code);
        assertEquals(
                "validationg advanceExceptionTypecode",
                code,
                advanceExceptionTypeResource.getAdvanceExceptionTypeCode());
        advanceExceptionTypeResource.setAdvanceExceptionTypeDescription(desc);
        assertEquals(
                "validating advanceExceptionTypeDesc",
                desc,
                advanceExceptionTypeResource.getAdvanceExceptionTypeDescription());
        assertNotSame("Validating Json", advanceExceptionTypeResource.toJson(), toJsonDummy());
    }

    static JSONObject toJsonDummy() {
        Map<String, String> map = new HashMap<>();
        map.put("advanceExceptionTypeCode", "advanceExceptionTypeCode");
        map.put("advanceExceptionTypeDescription", "advanceExceptionTypeDescription");
        return new JSONObject(map);
    }

}
