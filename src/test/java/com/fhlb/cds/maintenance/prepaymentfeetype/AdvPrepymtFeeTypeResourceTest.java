package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Test;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeResource;

public class AdvPrepymtFeeTypeResourceTest {

	@Test
	public void testAdvPrepymtFeeTypeResource() {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
		advPrepymtFeeTypeResource.setId(50);
		assertEquals("validate Id", 50, advPrepymtFeeTypeResource.getId());
		advPrepymtFeeTypeResource.setAdvPrepymtFeeCalcCode("TST");
		assertEquals("validate AdvPrepymtFeeCalcCode", "TST", advPrepymtFeeTypeResource.getAdvPrepymtFeeCalcCode());
		advPrepymtFeeTypeResource.setAdvPrepymtFeeDesc("Testing Purpose");
		assertEquals("validate AdvPrepymtFeeDesc", "Testing Purpose", advPrepymtFeeTypeResource.getAdvPrepymtFeeDesc());
		advPrepymtFeeTypeResource.setIndFeeCalcFlag("Y");
		assertEquals("validate IndFeeCalcFlag", "Y", advPrepymtFeeTypeResource.getIndFeeCalcFlag());
		advPrepymtFeeTypeResource.setActFeeCalcFlag("Y");
		assertEquals("validate ActFeeCalcFlag", "Y", advPrepymtFeeTypeResource.getActFeeCalcFlag());
		advPrepymtFeeTypeResource.setActReplRateFlag("Y");
		assertEquals("validate ActReplRateFlag", "Y", advPrepymtFeeTypeResource.getActReplRateFlag());
		assertNotSame("Validate toJson()", toJsonDummy(), advPrepymtFeeTypeResource.toJson());

	}

	JSONObject toJsonDummy() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("code", "advPrepymtFeeCalcCode");
		map.put("desc", "advPrepymtFeeDesc");
		map.put("indFeeCalcFlag", "indFeeCalcFlag");
		map.put("actFeeCalcFlag", "actFeeCalcFlag");
		map.put("actReplRateFlag", "actReplRateFlag");
		return new JSONObject(map);
	}
}
