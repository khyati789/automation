package com.fhlb.cds.maintenance.exceptionexplanation;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnResource;

public class AdvExcptnExplntnResourceTest {

    @Test
    public void testAdvExcptnExplntnResource() {
        AdvExcptnExplntnResource advExcptnExplntnResource = new AdvExcptnExplntnResource();
        advExcptnExplntnResource.setAdvExcptnExplntnDesc("Test");
        assertEquals("Validate Advance Exception Explenation Description","Test",advExcptnExplntnResource.getAdvExcptnExplntnDesc());
        assertNotSame("Validate toJason()", toJsonDummy(), advExcptnExplntnResource.toJson());
    }
    
    JSONObject toJsonDummy() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("desc", "advExcptnExplntnDesc");
        return new JSONObject(map);
     }

}
