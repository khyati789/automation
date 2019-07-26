package com.fhlb.cds.maintenance.advancepurposetype;

/**
 * This class defines Restful Web Services for Advance Purpose Type
 **/

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhlb.cds.exception.CodeValueChangeException;
import com.fhlb.cds.exception.FieldValueDuplicateException;
import com.fhlb.cds.exception.LengthCheckException;
import com.fhlb.cds.maintenance.error.AdvanceMaintenanceError;
import com.fhlb.commons.exception.FieldRequiredException;
import com.fhlb.commons.exception.NotFoundException;

@Service
@Transactional
public class AdvancePurposeTypeService {

	private AdvancePurposeTypeDao advancePurposeTypeDao;

	private AdvancePurposeTypeMapper advancePurposeTypeMapper;

	@Autowired
	public AdvancePurposeTypeService(AdvancePurposeTypeMapper advancePurposeTypeMapper,
			AdvancePurposeTypeDao advancePurposeTypeDao) {
		super();
		this.advancePurposeTypeMapper = advancePurposeTypeMapper;
		this.advancePurposeTypeDao = advancePurposeTypeDao;
	}

	/**
	 * Get advancePurposeType Data
	 * 
	 * @return
	 */
	public List<AdvancePurposeTypeResource> getAdvancePurposeTypeData() {
		return advancePurposeTypeDao.getAdvancePurposeTypeData().stream().map(advancePurposeTypeMapper::fromEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Create the advance PurposeType record
	 * 
	 * @param advancePurposeTypeResource
	 * @return
	 * @throws Exception
	 */
	public AdvancePurposeTypeResource createPurposeType(AdvancePurposeTypeResource advPurposeTypeResource) {

		if (advPurposeTypeResource.getAdvPurposeTypeCode() == null) {
			throw new FieldRequiredException(AdvanceMaintenanceError.PURPOSE_TYPE_CODE_REQUIRED);
		}

		else if (advancePurposeTypeDao.getPurposeTypeCode(advPurposeTypeResource.getAdvPurposeTypeCode())) {
			throw new FieldValueDuplicateException(AdvanceMaintenanceError.PURPOSE_TYPE_CODE_DUPLICATE,
					advPurposeTypeResource.getAdvPurposeTypeCode());
		}

		else if (advPurposeTypeResource.getAdvPurposeTypeDescription().length() < 1
				|| advPurposeTypeResource.getAdvPurposeTypeDescription().length() > 20) {
			throw new LengthCheckException(AdvanceMaintenanceError.PURPOSE_TYPE_DESC_TOO_LONG,
					advPurposeTypeResource.getAdvPurposeTypeDescription());
		}

		return advancePurposeTypeMapper.fromEntity(
				advancePurposeTypeDao.createPurposeType(advancePurposeTypeMapper.fromResource(advPurposeTypeResource)));
	}

	/**
	 * Update the advancePurposeType record by advance purposeTypeId
	 * 
	 * @param advancePurposeTypeId
	 * @param advancePurposeTypeResource
	 * @return
	 */
	public AdvancePurposeTypeResource updatePurposeType(int advPurposeTypeId,
			AdvancePurposeTypeResource advPurposeTypeResource) {

		AdvancePurposeTypeDB advancePurposeTypeDB = advancePurposeTypeDao.getPurposeTypeId(advPurposeTypeId);
		if (advancePurposeTypeDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.PURPOSE_TYPE_ID_NOT_FOUND, advPurposeTypeId);
		}

		else if (advPurposeTypeResource.getAdvPurposeTypeDescription().length() < 1
				|| advPurposeTypeResource.getAdvPurposeTypeDescription().length() > 20) {
			throw new LengthCheckException(AdvanceMaintenanceError.PURPOSE_TYPE_DESC_TOO_LONG,
					advPurposeTypeResource.getAdvPurposeTypeDescription());
		}

		else if (!advPurposeTypeResource.getAdvPurposeTypeCode().equals(advancePurposeTypeDB.getAdvPurposeTypeCode())) {
			throw new CodeValueChangeException(AdvanceMaintenanceError.PURPOSE_TYPE_CODE_NOT_CHANGE,
					advPurposeTypeResource.getAdvPurposeTypeCode());
		}

		return advancePurposeTypeMapper.fromEntity(advancePurposeTypeDao.updatePurposeType(
				advancePurposeTypeMapper.updatefromEntity(advancePurposeTypeDB, advPurposeTypeResource)));
	}

	/**
	 * Delete advancePurposeType record by advancePurposeType id
	 * 
	 * @param advancePurposeTypeId
	 * @return
	 */
	public AdvancePurposeTypeResource deletePurposeType(int id) {
		AdvancePurposeTypeDB advancePurposeTypeDB = advancePurposeTypeDao.getPurposeTypeId(id);
		if (advancePurposeTypeDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.PURPOSE_TYPE_ID_NOT_FOUND, id);
		}

		return advancePurposeTypeMapper.fromEntity(advancePurposeTypeDao.deletePurposeType(id));
	}

	/**
	 * Get the advance PurposeType report headers
	 * 
	 * @return
	 */
	public Map<String, String> getAdvancePurposeTypeReportHeaders() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("advancePurposeTypeCode", "CODE");
		reportHeaders.put("advancePurposeTypeDescription", "DESCRIPTION");
		return reportHeaders;
	}

	/**
	 * Get the report data of advancePurposeType
	 * 
	 * @return
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report;
		List<AdvancePurposeTypeResource> advancePurposeTypeResources = getAdvancePurposeTypeData();
		report = new JSONArray();
		for (AdvancePurposeTypeResource advancePurposeTypeResource : advancePurposeTypeResources) {
			report.put(advancePurposeTypeResource.toJson());
		}
		records.put("records", report);
		return records.toString();
	}

	/**
	 * Get the advancePurposeType record based on advancePurposeType Id
	 * 
	 * @param advancePurposeTypeId
	 * @return
	 */
	public AdvancePurposeTypeResource getAdvancePurposeTypeById(int id) {
		return advancePurposeTypeMapper.fromEntity(advancePurposeTypeDao.getPurposeTypeId(id));
	}
}
