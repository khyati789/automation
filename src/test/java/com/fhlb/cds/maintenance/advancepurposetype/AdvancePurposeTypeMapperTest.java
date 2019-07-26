package com.fhlb.cds.maintenance.advancepurposetype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeDB;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeMapper;
import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeResource;

public class AdvancePurposeTypeMapperTest {
    AdvancePurposeTypeMapper advancePurposeTypeMapper = new AdvancePurposeTypeMapper();
    AdvancePurposeTypeDB advancePurposeTypeDB = new AdvancePurposeTypeDB();
    AdvancePurposeTypeResource advancePurposeTypeResource = new AdvancePurposeTypeResource();

    @Test
    public void testFromEntity() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("qqqq");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        assertNotSame(
                "validating from entity db data",
                advancePurposeTypeResource,
                advancePurposeTypeMapper.fromEntity(advancePurposeTypeDB));
    }

    @Test
    public void testFromResource() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("qqqq");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123");
        assertNotSame(
                "validating from resource data",
                advancePurposeTypeDB,
                advancePurposeTypeMapper.fromResource(advancePurposeTypeResource));
    }

    @Test
    public void testUpdateFromEntity() {
        advancePurposeTypeDB.setId(14);
        advancePurposeTypeDB.setAdvPurposeTypeCode("A");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("qqqq");
        advancePurposeTypeResource.setId(14);
        advancePurposeTypeResource.setAdvPurposeTypeCode("A");
        advancePurposeTypeResource.setAdvPurposeTypeDescription("123");
        assertEquals(
                "validating get updated entity fromresource",
                advancePurposeTypeDB,
                advancePurposeTypeMapper.updatefromEntity(advancePurposeTypeDB, advancePurposeTypeResource));

    }
}
