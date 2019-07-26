package com.fhlb.cds.maintenance.advanceexceptiontype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fhlb.cds.maintenance.advanceexceptiontype.AdvanceExceptionTypeDB;

public class AdvanceExceptionTypeDBTest {
    @Test
    public void testAdvanceExceptionTypeDB() {
        AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
        String desc = "Testing";
        String code = "TTTT";
        advanceExceptionTypeDB.setId(12);

        assertEquals("validating adavanceExceptionTypeId", 12, advanceExceptionTypeDB.getId());
        advanceExceptionTypeDB.setAdvanceExceptionTypeCode(code);
        assertEquals(
                "validationg adavanceExceptionTypeCode",
                code,
                advanceExceptionTypeDB.getAdvanceExceptionTypeCode());
        advanceExceptionTypeDB.setAdvanceExceptionTypeDesc(desc);
        assertEquals(
                "validating adavanceExceptionTypeDesc",
                desc,
                advanceExceptionTypeDB.getAdvanceExceptionTypeDesc());
    }

}
