package com.fhlb.cds.maintenance.prepaymentfeetype;

import org.springframework.stereotype.Component;

@Component
public class AdvPrepymtFeeTypeMapper {

	/**
	 * Convert AdvPrepymtFeeTypeResource to AdvPrepymtFeeTypeDB
	 *
	 * @param advPrepymtFeeTypeResource
	 * @return advPrepymtFeeTypeDB
	 */
	public AdvPrepymtFeeTypeDB fromResource(AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource) {
		AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB;
		advPrepymtFeeTypeDB = new AdvPrepymtFeeTypeDB();

		advPrepymtFeeTypeDB.setIdDB(advPrepymtFeeTypeResource.getId());
		advPrepymtFeeTypeDB.setAdvPrepymtFeeCalcCodeDB(advPrepymtFeeTypeResource.getAdvPrepymtFeeCalcCode());
		advPrepymtFeeTypeDB.setActFeeCalcFlagDB(advPrepymtFeeTypeResource.getActFeeCalcFlag());
		advPrepymtFeeTypeDB.setActReplRateFlagDB(advPrepymtFeeTypeResource.getActReplRateFlag());
		advPrepymtFeeTypeDB.setAdvPrepymtFeeDescDB(advPrepymtFeeTypeResource.getAdvPrepymtFeeDesc());
		advPrepymtFeeTypeDB.setIndFeeCalcFlagDB(advPrepymtFeeTypeResource.getIndFeeCalcFlag());
		return advPrepymtFeeTypeDB;
	}

	/**
	 * Convert AdvPrepymtFeeTypeDB to AdvPrepymtFeeTypeResource
	 *
	 * @param AdvPrepymtFeeTypeDB
	 * @return AdvPrepymtFeeTypeResource
	 */
	public AdvPrepymtFeeTypeResource fromEntity(AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB) {
		AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource;
		advPrepymtFeeTypeResource = new AdvPrepymtFeeTypeResource();

		advPrepymtFeeTypeResource.setId(advPrepymtFeeTypeDB.getIdDB());
		advPrepymtFeeTypeResource.setAdvPrepymtFeeCalcCode(advPrepymtFeeTypeDB.getAdvPrepymtFeeCalcCodeDB());
		advPrepymtFeeTypeResource.setActFeeCalcFlag(advPrepymtFeeTypeDB.getActFeeCalcFlagDB());
		advPrepymtFeeTypeResource.setActReplRateFlag(advPrepymtFeeTypeDB.getActReplRateFlagDB());
		advPrepymtFeeTypeResource.setAdvPrepymtFeeDesc(advPrepymtFeeTypeDB.getAdvPrepymtFeeDescDB());
		advPrepymtFeeTypeResource.setIndFeeCalcFlag(advPrepymtFeeTypeDB.getIndFeeCalcFlagDB());
		return advPrepymtFeeTypeResource;
	}
}
