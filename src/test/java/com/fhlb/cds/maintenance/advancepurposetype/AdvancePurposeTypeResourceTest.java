package com.fhlb.cds.maintenance.advancepurposetype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;

import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeResource;

public class AdvancePurposeTypeResourceTest {

    AdvancePurposeTypeResource advancePurposeTypeResource = new AdvancePurposeTypeResource();

    @Test
    public void testAdvancePuposeTypeResourceConstructor() {
        assertNotSame(
                "validate constructor",
                advancePurposeTypeResource,
                new AdvancePurposeTypeResource());
    }

    @Test
    public void testAdvancePurposeTypeResource() {
        String advPurposeTypeCode = "B";
        String advPurposeTypeDescription = "Description testing";
        advancePurposeTypeResource.setId(12);
        advancePurposeTypeResource.setAdvPurposeTypeCode("B");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("Description testing");
        assertEquals("validate Advance Purpose Type Id", 12, advancePurposeTypeResource.getId());
        assertEquals(
                "validate Advance Purpose Type Code",
                advPurposeTypeCode,
                advancePurposeTypeResource.getAdvPurposeTypeCode());
        assertEquals(
                "validate Advance Purpose Type Code",
                advPurposeTypeDescription,
                advancePurposeTypeResource.getAdvPurposeTypeDescription());

        assertNotSame(toJsonDummy(), advancePurposeTypeResource.toJson());
    }

    private JSONObject toJsonDummy() {
        Map<String, String> map = new HashMap<>();
        map.put("advancePurposeTypeCode", "advPurposeTypeCode");
        map.put("advancePurposeTypeDescription", "advPurposeTypeDescription");
        return new JSONObject(map);
    }
}
