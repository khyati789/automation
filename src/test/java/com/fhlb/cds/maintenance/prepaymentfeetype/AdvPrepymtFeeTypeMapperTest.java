package com.fhlb.cds.maintenance.prepaymentfeetype;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeDB;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeMapper;
import com.fhlb.cds.maintenance.prepaymentfeetype.AdvPrepymtFeeTypeResource;

public class AdvPrepymtFeeTypeMapperTest {
    AdvPrepymtFeeTypeMapper advPrepymtFeeTypeMapper = new AdvPrepymtFeeTypeMapper();
    AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();
    AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB = new AdvPrepymtFeeTypeDB();
@Test
	public void  fromResourceDummy() {
advPrepymtFeeTypeResource.setId(12);
advPrepymtFeeTypeResource.setIndFeeCalcFlag("Y");
advPrepymtFeeTypeResource.setActFeeCalcFlag("y");
advPrepymtFeeTypeResource.setActReplRateFlag("y");
advPrepymtFeeTypeResource.setAdvPrepymtFeeCalcCode("AAA");
advPrepymtFeeTypeResource.setAdvPrepymtFeeDesc("sample");
assertNotSame(
        "validating from resource data",
        advPrepymtFeeTypeResource,
        advPrepymtFeeTypeMapper.fromResource(advPrepymtFeeTypeResource));
	}

@Test
public void  fromEntityDummy() {
advPrepymtFeeTypeDB.setIdDB(12);
advPrepymtFeeTypeDB.setActFeeCalcFlagDB("Y");
advPrepymtFeeTypeDB.setActReplRateFlagDB("y");
advPrepymtFeeTypeDB.setAdvPrepymtFeeCalcCodeDB("AAA");
advPrepymtFeeTypeDB.setAdvPrepymtFeeDescDB("sample");
advPrepymtFeeTypeDB.setIndFeeCalcFlagDB("Y");
assertNotSame(
    "validating from resource data",
    advPrepymtFeeTypeDB,
    advPrepymtFeeTypeMapper.fromEntity(advPrepymtFeeTypeDB));
}

}
