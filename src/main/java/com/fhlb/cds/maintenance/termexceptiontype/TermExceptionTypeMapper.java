package com.fhlb.cds.maintenance.termexceptiontype;

/**
 * This class for mapping between resource and entity classes
 */
import org.springframework.stereotype.Component;

@Component
public class TermExceptionTypeMapper {
	/**
	 * Get data from entity and return resource data
	 * 
	 * @param termExceptionTypeDB
	 * @return
	 */
	public TermExceptionTypeResource fromTermExceptionTypeEntity(TermExceptionTypeDB termExceptionTypeDB) {
		TermExceptionTypeResource termExceptionTypeResource = new TermExceptionTypeResource();
		termExceptionTypeResource.setTermExceptionTypeCode(termExceptionTypeDB.getTermExceptionTypeCode());
		termExceptionTypeResource.setTermExceptionTypeNo(termExceptionTypeDB.getTermExceptionTypeNo());
		termExceptionTypeResource
				.setTermExceptionTypeDescription(termExceptionTypeDB.getTermExceptionTypeDescription());
		termExceptionTypeResource.setId(termExceptionTypeDB.getId());
		return termExceptionTypeResource;
	}

	/**
	 * Get the data from resource and return entity data
	 * 
	 * @param termExceptionTypeResource
	 * @return
	 */
	public TermExceptionTypeDB fromTermExceptionTypeResource(TermExceptionTypeResource termExceptionTypeResource) {
		TermExceptionTypeDB termExceptionTypeDB = new TermExceptionTypeDB();
		termExceptionTypeDB.setTermExceptionTypeCode(termExceptionTypeResource.getTermExceptionTypeCode());
		termExceptionTypeDB.setTermExceptionTypeNo(termExceptionTypeResource.getTermExceptionTypeNo());
		termExceptionTypeDB
				.setTermExceptionTypeDescription(termExceptionTypeResource.getTermExceptionTypeDescription());
		termExceptionTypeDB.setId(termExceptionTypeResource.getId());
		return termExceptionTypeDB;
	}

	/**
	 * Uppdating the data of resource to entity
	 * 
	 * @param termExceptionType
	 * @param termExceptionTypeResource
	 * @return
	 */
	public TermExceptionTypeDB getUpdatedEntityFromResource(TermExceptionTypeDB termExceptionType,
			TermExceptionTypeResource termExceptionTypeResource) {
		termExceptionType.setTermExceptionTypeCode(termExceptionTypeResource.getTermExceptionTypeCode());
		termExceptionType.setTermExceptionTypeNo(termExceptionTypeResource.getTermExceptionTypeNo());
		termExceptionType.setTermExceptionTypeDescription(termExceptionTypeResource.getTermExceptionTypeDescription());
		return termExceptionType;
	}
	// bean
}
