package com.fhlb.cds.maintenance.exceptionexplanation;

import org.springframework.stereotype.Component;

/**
 * 
 * @author o-rajput
 *
 */
@Component
public class AdvExcptnExplntnMapper {
	/**
	 * Converts Resource to DB
	 * 
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB fromResource(AdvExcptnExplntnResource advExcptnExplntnResource) {
		AdvExcptnExplntnDB advExcptnExplntnDB;
		advExcptnExplntnDB = new AdvExcptnExplntnDB();

		advExcptnExplntnDB.setId(advExcptnExplntnResource.getId());
		advExcptnExplntnDB.setAdvExcptnExplntnDesc(advExcptnExplntnResource.getAdvExcptnExplntnDesc());
		return advExcptnExplntnDB;
	}

	/**
	 * Converts DB to resource
	 * 
	 * @param advExcptnExplntnDB
	 * @return advExcptnExplntnResource
	 */
	public AdvExcptnExplntnResource fromEntity(AdvExcptnExplntnDB advExcptnExplntnDB) {
		AdvExcptnExplntnResource advExcptnExplntnResource;
		advExcptnExplntnResource = new AdvExcptnExplntnResource();

		advExcptnExplntnResource.setId(advExcptnExplntnDB.getId());
		advExcptnExplntnResource.setAdvExcptnExplntnDesc(advExcptnExplntnDB.getAdvExcptnExplntnDesc());
		return advExcptnExplntnResource;
	}

	/**
	 * Uppdating the data of resource to entity
	 * 
	 * @param advExcptnExplntnDB
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB updateFromResource(AdvExcptnExplntnResource advExcptnExplntnResource,
			AdvExcptnExplntnDB advExcptnExplntnDB) {
		advExcptnExplntnDB.setAdvExcptnExplntnDesc(advExcptnExplntnResource.getAdvExcptnExplntnDesc());
		return advExcptnExplntnDB;
	}
}
