package com.fhlb.cds.maintenance.termfundsource;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

/**
 * This class defines Restful Web Services for Term Fund Source
 **/

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhlb.cds.exception.FieldValueDuplicateException;
import com.fhlb.cds.exception.LengthCheckException;
import com.fhlb.cds.maintenance.error.TermMaintenanceError;
import com.fhlb.commons.exception.FieldRequiredException;
import com.fhlb.commons.exception.NotFoundException;

@Service
@Transactional
public class TermFundSourceService {

	private final TermFundSourceDao termFundSourceDao;
	private final TermFundSourceMapper termFundSourceMapper;

	@Autowired
	public TermFundSourceService(TermFundSourceDao termFundSourceDao, TermFundSourceMapper termFundSourceMapper) {
		this.termFundSourceDao = termFundSourceDao;
		this.termFundSourceMapper = termFundSourceMapper;
	}

	/**
	 * Get termFundSource Data
	 * 
	 * @return
	 */
	public List<TermFundSourceResource> getTermFundSource() {
		return termFundSourceDao.getAllTermFundSource().stream().map(termFundSourceMapper::fromTermFundSourceEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Get the TermFundSource record based on id
	 * 
	 * @param id
	 * @return
	 */
	public TermFundSourceResource getTermFundSourceById(int id) {
		return termFundSourceMapper.fromTermFundSourceEntity(termFundSourceDao.getTermFundSourceById(id));
	}

	/**
	 * Create the Term Fund Source record
	 * 
	 * @param termFundSourceResource
	 * @return
	 * @throws Exception
	 */
	public TermFundSourceResource createTermFundSource(TermFundSourceResource termFundSourceResource) {

		if (termFundSourceResource.getTermFundSrcCode() == null || termFundSourceResource.getTermFundSrcCode() == "") {
			throw new FieldRequiredException(TermMaintenanceError.CODE_REQUIRED);
		}

		else if (termFundSourceDao.getTermFundSourceCode(termFundSourceResource.getTermFundSrcCode())) {
			throw new FieldValueDuplicateException(TermMaintenanceError.CODE_DUPLICATE,
					termFundSourceResource.getTermFundSrcCode());
		}

		return termFundSourceMapper.fromTermFundSourceEntity(termFundSourceDao
				.createTermFundSource(termFundSourceMapper.fromTermFundSourceResource(termFundSourceResource)));

	}

	/**
	 * Update the termFundSource record by id
	 * 
	 * @param termFundSourceId
	 * @param termFundSourceResource
	 * @return
	 */
	public TermFundSourceResource updateTermFundSource(int id, TermFundSourceResource termFundSourceResource) {

		TermFundSourceDB termFundSourceDB = termFundSourceDao.getTermFundSourceById(id);

		if (termFundSourceResource.getTermFundSrcCode() == null) {
			throw new FieldRequiredException(TermMaintenanceError.CODE_REQUIRED);
		}

		else if (termFundSourceDB.getTermFundSrcCode() != termFundSourceResource.getTermFundSrcCode()
				&& termFundSourceDB.getId() == termFundSourceResource.getId()) {
			if (termFundSourceDao.getTermFundSourceCode(termFundSourceResource.getTermFundSrcCode())) {
				throw new FieldValueDuplicateException(TermMaintenanceError.CODE_DUPLICATE,
						termFundSourceResource.getTermFundSrcCode());
			}
		}

		else if (termFundSourceResource.getTermFundSrcDesc().length() > 40) {
			throw new LengthCheckException(TermMaintenanceError.FUND_SOURCE_DESCRITION_LENGTH,
					termFundSourceResource.getTermFundSrcDesc());
		}

		return termFundSourceMapper.fromTermFundSourceEntity(termFundSourceDao.updateTermFundSource(
				termFundSourceMapper.getUpdatedEntityFromResource(termFundSourceDB, termFundSourceResource)));
	}

	/**
	 * Delete TermFundSourceResource record by id
	 * 
	 * @param id
	 * @return
	 */
	public TermFundSourceResource deleteTermFundSource(int id) {
		TermFundSourceDB termFundSourceDB = termFundSourceDao.getTermFundSourceById(id);

		if (termFundSourceDB == null) {
			throw new NotFoundException(TermMaintenanceError.NOT_FOUND, id);
		}

		return termFundSourceMapper.fromTermFundSourceEntity(termFundSourceDao.deleteTermFundSource(id));
	}

	/**
	 * Get the term fund source report headers
	 * 
	 * @return
	 */
	public Map<String, String> getTermFundSourceReportHeaders() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("termFundSrcCode", "CODE");
		reportHeaders.put("termFundSrcDesc", "DESCRIPTION");
		return reportHeaders;
	}

	/**
	 * Get the report data of termFundSource
	 * 
	 * @return
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report;
		List<TermFundSourceResource> termFundSourceResources = getTermFundSource();
		report = new JSONArray();
		for (TermFundSourceResource termFundSourceResource : termFundSourceResources) {
			report.put(termFundSourceResource.toJson());
		}
		records.put("records", report);
		return records.toString();
	}
}
