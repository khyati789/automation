package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeDB;

public class AdvPrepymtFeeTypeDBTest {

	@Test
	public void testAdvPrepymtFeeTypeDB() {
		AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB = new AdvPrepymtFeeTypeDB();
		advPrepymtFeeTypeDB.setIdDB(50);
		assertEquals("validate Id", 50, advPrepymtFeeTypeDB.getIdDB());
		advPrepymtFeeTypeDB.setAdvPrepymtFeeCalcCodeDB("TST");
		assertEquals("validate AdvPrepymtFeeCalcCode", "TST", advPrepymtFeeTypeDB.getAdvPrepymtFeeCalcCodeDB());
		advPrepymtFeeTypeDB.setAdvPrepymtFeeDescDB("Testing Purpose");
		assertEquals("validate AdvPrepymtFeeDesc", "Testing Purpose", advPrepymtFeeTypeDB.getAdvPrepymtFeeDescDB());
		advPrepymtFeeTypeDB.setIndFeeCalcFlagDB("Y");
		assertEquals("validate IndFeeCalcFlag", "Y", advPrepymtFeeTypeDB.getIndFeeCalcFlagDB());
		advPrepymtFeeTypeDB.setActFeeCalcFlagDB("Y");
		assertEquals("validate ActFeeCalcFlag", "Y", advPrepymtFeeTypeDB.getActFeeCalcFlagDB());
		advPrepymtFeeTypeDB.setActReplRateFlagDB("Y");
		assertEquals("validate ActReplRateFlag", "Y", advPrepymtFeeTypeDB.getActReplRateFlagDB());
	}

}
