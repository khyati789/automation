package com.fhlb.cds.maintenance.advanceexceptiontype;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhlb.cds.maintenance.error.AdvanceMaintenanceError;
import com.fhlb.commons.exception.NotFoundException;

/**
 * 
 * @author o-doraba
 *
 */
@Service
public class AdvanceExceptionTypeService {

	private AdvanceExceptionTypeDao advanceExceptionTypeDao;
	private AdvanceExceptionTypeMapper advanceExceptionTypeMapper;

	@Autowired
	public AdvanceExceptionTypeService(AdvanceExceptionTypeDao advanceExceptionTypeDao,
			AdvanceExceptionTypeMapper advanceExceptionTypeMapper) {
		super();
		this.advanceExceptionTypeDao = advanceExceptionTypeDao;
		this.advanceExceptionTypeMapper = advanceExceptionTypeMapper;
	}

	/**
	 * Get advanceExceptionType Data
	 * 
	 * @return
	 */
	public List<AdvanceExceptionTypeResource> getAdvanceExceptionTypeData() {

		return advanceExceptionTypeDao.getAdvanceExceptionTypeData().stream()
				.map(advanceExceptionTypeMapper::fromEntity).collect(Collectors.toList());
	}

	/**
	 * Create the advance ExceptionType record
	 * 
	 * @param advanceExceptionTypeResource
	 * @return
	 * @throws Exception
	 */
	public AdvanceExceptionTypeResource createAdvanceExceptionTypeData(
			AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		return advanceExceptionTypeMapper.fromEntity(advanceExceptionTypeDao
				.createAdvanceExceptionType(advanceExceptionTypeMapper.fromResource(advanceExceptionTypeResource)));
	}

	/**
	 * Update the advanceExceptionType record by advance exceptionTypeId
	 * 
	 * @param advanceExceptionTypeId
	 * @param advanceExceptionTypeResource
	 * @return
	 */
	public AdvanceExceptionTypeResource updateAdvanceExceptionTypeData(int advanceExceptionTypeId,
			AdvanceExceptionTypeResource advanceExceptionTypeResource) {
		AdvanceExceptionTypeDB advanceExceptionTypeDB;
		advanceExceptionTypeDB = advanceExceptionTypeDao
				.getAdvanceExceptionTypeByExceptionTypeId(advanceExceptionTypeId);
		if (advanceExceptionTypeDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.RECORD_NOT_FOUND, advanceExceptionTypeId);
		} else {
			return advanceExceptionTypeMapper
					.fromEntity(advanceExceptionTypeDao.updateAdvanceExceptionType(advanceExceptionTypeMapper
							.getUpdatedEntityFromResource(advanceExceptionTypeDB, advanceExceptionTypeResource)));
		}
	}

	/**
	 * Delete advanceExceptionType record by advanceExceptionType id
	 * 
	 * @param advanceExceptionTypeId
	 * @return
	 */
	public AdvanceExceptionTypeResource deleteAdvanceExceptionType(int advanceExceptionTypeId) {
		AdvanceExceptionTypeDB advanceExceptionTypeDB;
		advanceExceptionTypeDB = advanceExceptionTypeDao
				.getAdvanceExceptionTypeByExceptionTypeId(advanceExceptionTypeId);
		if (advanceExceptionTypeDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.RECORD_NOT_FOUND, advanceExceptionTypeId);
		} else {
			advanceExceptionTypeDao.deleteAdvanceExceptionTypeData(advanceExceptionTypeDB);
		}
		return advanceExceptionTypeMapper.fromEntity(advanceExceptionTypeDB);
	}

	/**
	 * Get the advance ExceptionType report headers
	 * 
	 * @return
	 */
	public Map<String, String> getAdvanceExceptionTypeReportHeaders() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("advanceExceptionTypeCode", "CODE");
		reportHeaders.put("advanceExceptionTypeDescription", "DESCRIPTION");
		return reportHeaders;
	}

	/**
	 * Get the report data of advanceExceptionType
	 * 
	 * @return
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report;
		List<AdvanceExceptionTypeResource> advanceExceptionTypeResources = getAdvanceExceptionTypeData();
		report = new JSONArray();
		for (AdvanceExceptionTypeResource advanceExceptionTypeResource : advanceExceptionTypeResources) {
			report.put(advanceExceptionTypeResource.toJson());
		}
		records.put("records", report);
		return records.toString();

	}

	/**
	 * Get the advanceExceptionType record based on advanceExceptionType Id
	 * 
	 * @param advanceExceptionTypeId
	 * @return
	 */
	public AdvanceExceptionTypeResource getAdvanceExceptionTypeById(int advanceExceptionTypeId) {
		AdvanceExceptionTypeResource advanceExceptionTypeResource = advanceExceptionTypeMapper
				.fromEntity(advanceExceptionTypeDao.getAdvanceExceptionTypeByExceptionTypeId(advanceExceptionTypeId));
		if (advanceExceptionTypeResource == null) {
			throw new NotFoundException(AdvanceMaintenanceError.RECORD_NOT_FOUND, advanceExceptionTypeId);
		} else {
			return advanceExceptionTypeResource;
		}

	}

}
