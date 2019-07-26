package com.fhlb.cds.maintenance.termfundsource;

/**
 * This class use for mapping between entity class to resource class
 */

import org.springframework.stereotype.Component;

@Component
public class TermFundSourceMapper {

	/**
	 * Setting data to resource from entity
	 * 
	 * @param termFundSourceDB
	 * @return
	 */
	public TermFundSourceResource fromTermFundSourceEntity(TermFundSourceDB termFundSourceDB) {
		TermFundSourceResource termFundSourceResource;
		termFundSourceResource = new TermFundSourceResource();
		termFundSourceResource.setTermFundSrcCode(termFundSourceDB.getTermFundSrcCode());
		termFundSourceResource.setTermFundSrcDesc(termFundSourceDB.getTermFundSrcDesc());
		termFundSourceResource.setId(termFundSourceDB.getId());
		return termFundSourceResource;
	}

	/**
	 * Setting data to entity from resource
	 * 
	 * @param termFundSourceResource
	 * @return
	 */
	public TermFundSourceDB fromTermFundSourceResource(TermFundSourceResource termFundSourceResource) {
		TermFundSourceDB termFundSourceDB;
		termFundSourceDB = new TermFundSourceDB();
		termFundSourceDB.setTermFundSrcCode(termFundSourceResource.getTermFundSrcCode());
		termFundSourceDB.setTermFundSrcDesc(termFundSourceResource.getTermFundSrcDesc());
		termFundSourceDB.setId(termFundSourceResource.getId());
		return termFundSourceDB;
	}

	/**
	 * Updating the data to entity from resource
	 * 
	 * @param termFundSourceDB
	 * @param termFundSourceResource
	 * @return
	 */
	public TermFundSourceDB getUpdatedEntityFromResource(TermFundSourceDB termFundSource,
			TermFundSourceResource termFundSourceResource) {
		termFundSource.setTermFundSrcCode(termFundSourceResource.getTermFundSrcCode());
		termFundSource.setTermFundSrcDesc(termFundSourceResource.getTermFundSrcDesc());
		return termFundSource;
	}
	// bean
}
