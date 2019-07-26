package com.fhlb.cds.maintenance.advanceexceptiontype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeDB;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeMapper;
import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeResource;

public class AdvanceExceptionTypeMapperTest {
    AdvanceExceptionTypeMapper advanceExceptionTypeMapper = new AdvanceExceptionTypeMapper();
    AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
    AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
    @Test
    public void testFromEntity() {
        advanceExceptionTypeDB.setId(12);
        advanceExceptionTypeDB.setAdvanceExceptionTypeCode("CODE");
        advanceExceptionTypeDB.setAdvanceExceptionTypeDesc("sample data");
        assertNotSame(
                "validating from entity db data",
                advanceExceptionTypeResource,
                advanceExceptionTypeMapper.fromEntity(advanceExceptionTypeDB));
    }

    @Test
    public void testFromResource() {
        advanceExceptionTypeResource.setId(12);
        advanceExceptionTypeResource.setAdvanceExceptionTypeCode("CODE");
        advanceExceptionTypeResource.setAdvanceExceptionTypeDescription("sample data");
        assertNotSame(
                "validating from resource data",
                advanceExceptionTypeDB,
                advanceExceptionTypeMapper.fromResource(advanceExceptionTypeResource));
    }

    @Test
    public void testGetUpdateEntityFromResource() {
        advanceExceptionTypeDB.setId(12);
        advanceExceptionTypeDB.setAdvanceExceptionTypeCode("CODE");
        advanceExceptionTypeDB.setAdvanceExceptionTypeDesc("sample data");
        advanceExceptionTypeResource.setId(12);
        advanceExceptionTypeResource.setAdvanceExceptionTypeCode("CODE");
        advanceExceptionTypeResource.setAdvanceExceptionTypeDescription("sample data");
        assertEquals(
                "validating get updated entity fromresource",
                advanceExceptionTypeDB,
                advanceExceptionTypeMapper
                        .getUpdatedEntityFromResource(advanceExceptionTypeDB, advanceExceptionTypeResource));

    }

}
