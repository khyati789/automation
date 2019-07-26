package com.fhlb.cds.maintenance.advanceexceptiontype;

import org.springframework.stereotype.Component;

/**
 * This class use for mapping between entity class to resource class
 * 
 * @author o-doraba
 *
 */
@Component
public class AdvanceExceptionTypeMapper {
	/**
	 * Setting data to resource from entity
	 * 
	 * @param advanceExceptionTypeDB
	 * @return
	 */
	public AdvanceExceptionTypeResource fromEntity(AdvanceExceptionTypeDB advanceExceptionTypeDB) {

		AdvanceExceptionTypeResource advanceExceptionTypeResource = new AdvanceExceptionTypeResource();
		advanceExceptionTypeResource.setId(advanceExceptionTypeDB.getId());
		advanceExceptionTypeResource.setAdvanceExceptionTypeCode(advanceExceptionTypeDB.getAdvanceExceptionTypeCode());
		advanceExceptionTypeResource
				.setAdvanceExceptionTypeDescription(advanceExceptionTypeDB.getAdvanceExceptionTypeDesc());
		return advanceExceptionTypeResource;
	}

	/**
	 * Setting data to entity from resource
	 * 
	 * @param advanceExceptionTypeResource
	 * @return
	 */
	public AdvanceExceptionTypeDB fromResource(AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		AdvanceExceptionTypeDB advanceExceptionTypeDB = new AdvanceExceptionTypeDB();
		advanceExceptionTypeDB.setId(advanceExceptionTypeResource.getId());
		advanceExceptionTypeDB.setAdvanceExceptionTypeCode(advanceExceptionTypeResource.getAdvanceExceptionTypeCode());
		advanceExceptionTypeDB
				.setAdvanceExceptionTypeDesc(advanceExceptionTypeResource.getAdvanceExceptionTypeDescription());
		return advanceExceptionTypeDB;
	}

	/**
	 * Updating the data to entity from resource
	 * 
	 * @param advanceExceptionTypeDB
	 * @param advanceExceptionTypeResource
	 * @return
	 */
	public AdvanceExceptionTypeDB getUpdatedEntityFromResource(AdvanceExceptionTypeDB advanceExceptionTypeDB,
			AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		advanceExceptionTypeDB.setAdvanceExceptionTypeCode(advanceExceptionTypeResource.getAdvanceExceptionTypeCode());
		advanceExceptionTypeDB
				.setAdvanceExceptionTypeDesc(advanceExceptionTypeResource.getAdvanceExceptionTypeDescription());
		return advanceExceptionTypeDB;
	}

}
