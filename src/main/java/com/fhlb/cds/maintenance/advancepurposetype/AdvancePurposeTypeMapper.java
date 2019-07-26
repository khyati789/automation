package com.fhlb.cds.maintenance.advancepurposetype;

/**
 * This class use for mapping between entity class to resource class
 */

import org.springframework.stereotype.Component;

@Component
public class AdvancePurposeTypeMapper {

	/**
	 * Setting data to resource from entity
	 * 
	 * @param advancePurposeTypeDB
	 * @return
	 */
	public AdvancePurposeTypeResource fromEntity(AdvancePurposeTypeDB advancePurposeTypeDB) {
		AdvancePurposeTypeResource advancePurposeTypeResource;
		advancePurposeTypeResource = new AdvancePurposeTypeResource();
		advancePurposeTypeResource.setId(advancePurposeTypeDB.getId());
		advancePurposeTypeResource.setAdvPurposeTypeCode(advancePurposeTypeDB.getAdvPurposeTypeCode());
		advancePurposeTypeResource.setAdvPurposeTypeDescription(advancePurposeTypeDB.getAdvPurposeTypeDescription());
		return advancePurposeTypeResource;
	}

	/**
	 * Setting data to entity from resource
	 * 
	 * @param advancePurposeTypeResource
	 * @return
	 */
	public AdvancePurposeTypeDB fromResource(AdvancePurposeTypeResource advancePurposeTypeResource) {
		AdvancePurposeTypeDB advancePurposeTypeDB;
		advancePurposeTypeDB = new AdvancePurposeTypeDB();
		advancePurposeTypeDB.setId(advancePurposeTypeResource.getId());
		advancePurposeTypeDB.setAdvPurposeTypeCode(advancePurposeTypeResource.getAdvPurposeTypeCode());
		advancePurposeTypeDB.setAdvPurposeTypeDescription(advancePurposeTypeResource.getAdvPurposeTypeDescription());
		return advancePurposeTypeDB;
	}

	/**
	 * Updating the data to entity from resource
	 * 
	 * @param advancePurposeTypeDB
	 * @param advancePurposeTypeResource
	 * @return
	 */
	public AdvancePurposeTypeDB updatefromEntity(AdvancePurposeTypeDB advancePurposeTypeDB,
			AdvancePurposeTypeResource advancePurposeTypeResource) {
		advancePurposeTypeDB.setAdvPurposeTypeCode(advancePurposeTypeResource.getAdvPurposeTypeCode());
		advancePurposeTypeDB.setAdvPurposeTypeDescription(advancePurposeTypeResource.getAdvPurposeTypeDescription());
		return advancePurposeTypeDB;
	}
}
