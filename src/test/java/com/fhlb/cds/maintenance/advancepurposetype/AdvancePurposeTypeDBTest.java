package com.fhlb.cds.maintenance.advancepurposetype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.fhlb.cds.maintenance.advancepurposetype.AdvancePurposeTypeDB;

public class AdvancePurposeTypeDBTest {

    @Test
    public void testAdvancePuposeTypeDBConstructor() {
        int advPurposeTypeId = 0;
        String advPurposeTypeCode = null;
        String advPurposeTypeDescription = null;
        AdvancePurposeTypeDB advancePurposeTypeDB = new AdvancePurposeTypeDB(advPurposeTypeId, advPurposeTypeCode,
                advPurposeTypeDescription);

        assertNotSame(
                "validate constructor",
                advancePurposeTypeDB,
                new AdvancePurposeTypeDB(advPurposeTypeId, advPurposeTypeCode, advPurposeTypeDescription));
    }

    @Test
    public void testAdvancePuposeTypeDB() {
        AdvancePurposeTypeDB advancePurposeTypeDB = new AdvancePurposeTypeDB();
        advancePurposeTypeDB.setId(12);
        advancePurposeTypeDB.setAdvPurposeTypeCode("B");
        advancePurposeTypeDB.setAdvPurposeTypeDescription("Description Testing");
        assertEquals("validate Advance Purpose Type Id", 12, advancePurposeTypeDB.getId());
        assertEquals("validate Advance Purpose Type Code", "B", advancePurposeTypeDB.getAdvPurposeTypeCode());
        assertEquals(
                "validate Advance Purpose Type Code",
                "Description Testing",
                advancePurposeTypeDB.getAdvPurposeTypeDescription());
    }

}
