package com.fhlb.cds.maintenance.termexceptiontype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeDB;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeMapper;
import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeResource;

public class TermExceptionTypeMapperTest {

    TermExceptionTypeResource termExceptionTypeResource = new TermExceptionTypeResource();
    TermExceptionTypeMapper termExceptionTypeMapper = new TermExceptionTypeMapper();
    TermExceptionTypeDB termExceptionTypeDB = new TermExceptionTypeDB();

    @Test
    public void testFromEntity() {
    	short a=123;
        termExceptionTypeDB.setId(12);
        termExceptionTypeDB.setTermExceptionTypeCode("AAA");
        termExceptionTypeDB.setTermExceptionTypeNo(a);
        termExceptionTypeDB.setTermExceptionTypeDescription("Description of sample");
        assertNotSame(
                "validating fromEntity of mapper",
                termExceptionTypeResource,
                termExceptionTypeMapper.fromTermExceptionTypeEntity(termExceptionTypeDB));
    }

    @Test
    public void testFromResource() {
    	short a=123;
        termExceptionTypeResource.setId(12);
        termExceptionTypeResource.setTermExceptionTypeCode("AAA");
        termExceptionTypeResource.setTermExceptionTypeNo(a);
        termExceptionTypeResource.setTermExceptionTypeDescription("Description of sampel");
        assertNotSame(
                "validating FromResource of mapper",
                termExceptionTypeDB,
                termExceptionTypeMapper.fromTermExceptionTypeResource(termExceptionTypeResource));
    }

    @Test
    public void testUpdatingTermException() {
    	short a=123;
        termExceptionTypeDB.setId(12);
        termExceptionTypeDB.setTermExceptionTypeCode("AAA");
        termExceptionTypeDB.setTermExceptionTypeNo(a);
        termExceptionTypeDB.setTermExceptionTypeDescription("Description of sample");
        termExceptionTypeResource.setId(12);
        termExceptionTypeResource.setTermExceptionTypeCode("AAA");
       termExceptionTypeResource.setTermExceptionTypeNo(a);
        termExceptionTypeResource.setTermExceptionTypeDescription("Description of sampel");
        assertEquals(
                "validating updatingTermExceptionType",
                termExceptionTypeDB,
                termExceptionTypeMapper
                        .getUpdatedEntityFromResource(termExceptionTypeDB, termExceptionTypeResource));
    }
 
}
