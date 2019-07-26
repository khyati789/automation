package com.fhlb.cds.maintenance.exceptionexplanation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fhlb.cds.maintenance.error.AdvanceMaintenanceError;
import com.fhlb.commons.exception.FieldRequiredException;
import com.fhlb.commons.exception.NotFoundException;

@Service
@Transactional
public class AdvExcptnExplntnService {

	@Autowired
	private AdvExcptnExplntnDao advExcptnExplntnDao;

	@Autowired
	private AdvExcptnExplntnMapper advExcptnExplntnMapper;

	private AdvExcptnExplntnDB advExcptnExplntnDB;

	/**
	 * Get list of Exception Explanation
	 * 
	 * @return advExcptnExplntnResources
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AdvExcptnExplntnResource> getAdvExcptnExplntn() {

		List<AdvExcptnExplntnResource> advExcptnExplntnResources = new ArrayList<>();
		advExcptnExplntnResources.addAll(advExcptnExplntnDao.getAdvExcptnExplntn().stream()
				.map(advExcptnExplntnMapper::fromEntity).collect(Collectors.toList()));
		return advExcptnExplntnResources;
	}

	/**
	 * Get Exception Explanation by id
	 * 
	 * @param id
	 * @return advExcptnExplntnResources
	 */
	public AdvExcptnExplntnResource getAdvExcptnExplntnById(int id) {
		advExcptnExplntnDB = advExcptnExplntnDao.getAdvExcptnExplntnById(id);
		if (advExcptnExplntnDB == null) {
			throw new NotFoundException(id);
		}
		return advExcptnExplntnMapper.fromEntity(advExcptnExplntnDao.getAdvExcptnExplntnById(id));
	}

	/**
	 * Create new Exception Explanation Description
	 * 
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnResources
	 */
	public AdvExcptnExplntnResource createAdvExcptnExplntn(AdvExcptnExplntnResource advExcptnExplntnResource) {
		advExcptnExplntnDB = advExcptnExplntnDao.getAdvExcptnExplntnById(advExcptnExplntnResource.getId());
		if (advExcptnExplntnDB == null) {
			throw new NotFoundException(advExcptnExplntnResource.getId());
		} else if (advExcptnExplntnDao.isDuplicate(advExcptnExplntnResource.getAdvExcptnExplntnDesc()) != null) {
			throw new FieldRequiredException(AdvanceMaintenanceError.RECORD_ALREADY_EXIST);
		} else if (advExcptnExplntnResource.getAdvExcptnExplntnDesc() == null
				|| advExcptnExplntnResource.getAdvExcptnExplntnDesc() == ""
				|| advExcptnExplntnResource.getAdvExcptnExplntnDesc().length() <= 0) {
			throw new FieldRequiredException(AdvanceMaintenanceError.NOT_NULL);
		} else if (advExcptnExplntnResource.getAdvExcptnExplntnDesc().length() > 60) {
			throw new FieldRequiredException(AdvanceMaintenanceError.MAX_LENGTH);
		}

		return advExcptnExplntnMapper.fromEntity(advExcptnExplntnDao
				.createAdvExplntnExcptn(advExcptnExplntnMapper.fromResource(advExcptnExplntnResource)));
	}

	/**
	 * Update Exception Explanation Description
	 * 
	 * @param advExcptnExplntnResource
	 * @return advExcptnExplntnResources
	 */
	public AdvExcptnExplntnResource updateAdvExcptnExplntn(int id, AdvExcptnExplntnResource advExcptnExplntnResource) {
		advExcptnExplntnDB = advExcptnExplntnDao.getAdvExcptnExplntnById(id);
		if (advExcptnExplntnDB == null) {
			throw new NotFoundException(advExcptnExplntnResource.getId());
		} else if (advExcptnExplntnDao.isDuplicate(advExcptnExplntnResource.getAdvExcptnExplntnDesc()) != null) {
			throw new FieldRequiredException(AdvanceMaintenanceError.RECORD_ALREADY_EXIST);
		} else if (advExcptnExplntnResource.getAdvExcptnExplntnDesc() == null
				|| advExcptnExplntnResource.getAdvExcptnExplntnDesc() == ""
				|| advExcptnExplntnResource.getAdvExcptnExplntnDesc().length() <= 0) {
			throw new FieldRequiredException(AdvanceMaintenanceError.NOT_NULL);
		} else if (advExcptnExplntnResource.getAdvExcptnExplntnDesc().length() > 60) {
			throw new FieldRequiredException(AdvanceMaintenanceError.MAX_LENGTH);
		}

		return advExcptnExplntnMapper.fromEntity(advExcptnExplntnDao.updateAdvExcptnExplntn(
				advExcptnExplntnMapper.updateFromResource(advExcptnExplntnResource, advExcptnExplntnDB)));
	}

	/**
	 * Delete Exception Explanation Description
	 * 
	 * @param id
	 * @return advExcptnExplntnResources
	 */
	public AdvExcptnExplntnResource deleteAdvExcptnExplntn(int id) {
		advExcptnExplntnDB = advExcptnExplntnDao.getAdvExcptnExplntnById(id);
		if (advExcptnExplntnDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.MAX_LENGTH, id);
		}

		return advExcptnExplntnMapper.fromEntity(advExcptnExplntnDao.deleteAdvExcptnExplntn(advExcptnExplntnDB));
	}

	/**
	 * Return Exception Explanation Description report headers
	 */
	public Map<String, String> getListReportHeader() {
		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("desc", "Explanation Description");
		return reportHeaders;
	}

	/**
	 * Bind report data into JSON Object
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report = new JSONArray();
		List<AdvExcptnExplntnResource> advExcptnExplntnResources = getAdvExcptnExplntn();

		for (AdvExcptnExplntnResource excptnExplntn : advExcptnExplntnResources) {
			report.put(excptnExplntn.toJson());
		}
		records.put("records", report);

		return records.toString();
	}
}
