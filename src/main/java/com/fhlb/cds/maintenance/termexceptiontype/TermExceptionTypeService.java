package com.fhlb.cds.maintenance.termexceptiontype;

/**
 * This class contains services
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhlb.cds.maintenance.error.TermExceptionTypeError;
import com.fhlb.cds.maintenance.exception.NotFoundException;
import com.fhlb.commons.exception.FieldRequiredException;

@Service
@Transactional
public class TermExceptionTypeService {

	private final TermExceptionTypeDao termexceptiontypeDao;
	private final TermExceptionTypeMapper termexceptiontypeMapper;

	@Autowired
	public TermExceptionTypeService(TermExceptionTypeDao termexceptiontypeDao,
			TermExceptionTypeMapper termexceptiontypeMapper) {
		this.termexceptiontypeDao = termexceptiontypeDao;
		this.termexceptiontypeMapper = termexceptiontypeMapper;
	}

	/**
	 * Get the list of data
	 * 
	 * @return
	 */
	public List<TermExceptionTypeResource> getTermexceptiontype() {
		return termexceptiontypeDao.getAllTermexceptiontype().stream()
				.map(termexceptiontypeMapper::fromTermExceptionTypeEntity).collect(Collectors.toList());
	}

	/**
	 * Get the particular record
	 * 
	 * @param id
	 * @return
	 */
	public TermExceptionTypeResource getTermexceptiontypeById(int id) {
		return termexceptiontypeDao.getTermexceptiontypeById(id)
				.map(termexceptiontypeMapper::fromTermExceptionTypeEntity).orElseThrow(() -> new NotFoundException(id));
	}

	/**
	 * Adding new record
	 * 
	 * @param termexceptiontypeResource
	 * @return
	 */
	public TermExceptionTypeResource createTermexceptiontype(TermExceptionTypeResource termexceptiontypeResource) {
		if (termexceptiontypeResource.getTermExceptionTypeCode() == null) {
			throw new FieldRequiredException(TermExceptionTypeError.CODE_REQUIRED);
		} else if (!(termexceptiontypeResource.getTermExceptionTypeCode().length() > 1
				&& termexceptiontypeResource.getTermExceptionTypeCode().length() < 9)) {
			throw new FieldRequiredException(TermExceptionTypeError.CODE_TOO_LONG);
		} else if (termexceptiontypeDao
				.getTermExceptionTypeCode(termexceptiontypeResource.getTermExceptionTypeCode()) == true) {
			throw new FieldRequiredException(TermExceptionTypeError.DUPLICATE_CODE);
		} else if (!(termexceptiontypeResource.getTermExceptionTypeDescription().length() < 1
				&& termexceptiontypeResource.getTermExceptionTypeCode().length() > 70)) {
			throw new FieldRequiredException(TermExceptionTypeError.DESC_TOO_LONG);
		}
		return termexceptiontypeMapper.fromTermExceptionTypeEntity(termexceptiontypeDao.createTermexceptiontype(
				termexceptiontypeMapper.fromTermExceptionTypeResource(termexceptiontypeResource)));
	}

	/**
	 * Updating particular record
	 * 
	 * @param id
	 * @param termexceptiontypeResource
	 * @return
	 */
	public TermExceptionTypeResource updateTermexceptiontype(int id,
			TermExceptionTypeResource termexceptiontypeResource){
		TermExceptionTypeDB termExceptionType;

		termExceptionType = termexceptiontypeDao.getTermexceptiontypeById(id)
				.orElseThrow(() -> new NotFoundException(id));
		if (termexceptiontypeResource.getTermExceptionTypeCode() == null) {
			throw new FieldRequiredException(TermExceptionTypeError.CODE_REQUIRED);

		} else if (termexceptiontypeResource.getTermExceptionTypeCode().length() < 1
				|| termexceptiontypeResource.getTermExceptionTypeCode().length() > 8) {
			throw new FieldRequiredException(TermExceptionTypeError.CODE_TOO_LONG);
		} else if (!termexceptiontypeDao.checkDuplicate(id, termexceptiontypeResource.getTermExceptionTypeCode())) {
			throw new FieldRequiredException(TermExceptionTypeError.DUPLICATE_CODE);

		} else if (termexceptiontypeResource.getTermExceptionTypeDescription().length() < 1
				&& termexceptiontypeResource.getTermExceptionTypeCode().length() > 70) {
			throw new FieldRequiredException(TermExceptionTypeError.DESC_TOO_LONG);
		}

		return termexceptiontypeMapper.fromTermExceptionTypeEntity(termexceptiontypeDao.updateTermexceptiontype(
				termexceptiontypeMapper.getUpdatedEntityFromResource(termExceptionType, termexceptiontypeResource)));

	}

	/**
	 * Deleting particular record
	 * 
	 * @param id
	 * @return
	 */
	public TermExceptionTypeResource deleteTermexceptiontype(int id) {
		TermExceptionTypeDB termExceptionType;

		termExceptionType = termexceptiontypeDao.getTermexceptiontypeById(id)
				.orElseThrow(() -> new NotFoundException(id));

		termexceptiontypeDao.deleteTermexceptiontype(termExceptionType);

		return termexceptiontypeMapper.fromTermExceptionTypeEntity(termExceptionType);
	}

	/**
	 * Get the report data
	 * 
	 * @return
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report;
		List<TermExceptionTypeResource> termExceptionTypeResources = getTermexceptiontype();
		report = new JSONArray();
		for (TermExceptionTypeResource termExceptionTypeResource : termExceptionTypeResources) {
			report.put(termExceptionTypeResource.toJson());
		}
		records.put("records", report);
		return records.toString();

	}

	/**
	 * Report headers in key and value pair
	 * 
	 * @return
	 */
	public Map<String, String> getTermExceptionTypeReportHeaders() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("termExceptionTypeCode", "CODE");
		reportHeaders.put("termExceptionTypeNo", "NO");
		reportHeaders.put("termExceptionTypeDescription", "Description");
		return reportHeaders;
	}

}
