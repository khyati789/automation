package com.fhlb.cds.maintenance.termexceptiontype;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fhlb.cds.maintenance.termexceptiontype.TermExceptionTypeDB;

public class TermExceptionTypeDBTest {
    @Test
    public void testTermExceptionTypeDB()
    {
        TermExceptionTypeDB termExceptionTypeDB=new TermExceptionTypeDB();
        String code="AAA";
       short no=123;
        String desc="dskdhdjkfhwsi";
        termExceptionTypeDB.setId(12);
        assertEquals("validating termExceptionTypeId", 12, termExceptionTypeDB.getId());
        termExceptionTypeDB.setTermExceptionTypeCode(code);
        assertEquals("validating termExceptionTypeCode",code,termExceptionTypeDB.getTermExceptionTypeCode());
        termExceptionTypeDB.setTermExceptionTypeNo(no);
        assertEquals("validating termExceptionTypeNo",no,termExceptionTypeDB.getTermExceptionTypeNo());
        termExceptionTypeDB.setTermExceptionTypeDescription(desc);
        assertEquals("validating termExceptionTypeDesc",desc,termExceptionTypeDB.getTermExceptionTypeDescription());
        
    }
 
}
