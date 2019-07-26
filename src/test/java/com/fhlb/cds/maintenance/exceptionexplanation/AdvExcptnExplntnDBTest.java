package com.fhlb.cds.maintenance.exceptionexplanation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fhlb.cds.maintenance.exceptionexplanation.AdvExcptnExplntnDB;

public class AdvExcptnExplntnDBTest {

    @Test
    public void testAdvExcptnExplntnDB() {
        AdvExcptnExplntnDB advExcptnExplntnDB = new AdvExcptnExplntnDB();
        advExcptnExplntnDB.setAdvExcptnExplntnDesc("Test");
        assertEquals("Validate Advance Exception Explenation Description","Test",advExcptnExplntnDB.getAdvExcptnExplntnDesc());
    }

}
