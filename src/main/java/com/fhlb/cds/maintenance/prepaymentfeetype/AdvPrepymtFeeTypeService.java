package com.fhlb.cds.maintenance.prepaymentfeetype;

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
import com.fhlb.commons.exception.NotFoundException;

@Service
@Transactional
public class AdvPrepymtFeeTypeService {

	@Autowired
	private AdvPrepymtFeeTypeDao advPrepymtFeeTypeDao;

	@Autowired
	private AdvPrepymtFeeTypeMapper advPrepymtFeeTypeMapper;

	public AdvPrepymtFeeTypeService() {
		/** Default Constructor */
	}

	/**
	 * get Advance Prepayment Fee Type By Id
	 *
	 * @param id
	 *            to fetch the specific record
	 * @return advPrepymtFeeTypeResource
	 */
	public AdvPrepymtFeeTypeResource getAdvPrepymtFeeTypeById(int id) {
		return advPrepymtFeeTypeMapper.fromEntity(advPrepymtFeeTypeDao.getAdvPrepymtFeeTypeById(id));
	}

	/**
	 * Insert Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeResource
	 * @return advPrepymtFeeTypeResource
	 */
	public AdvPrepymtFeeTypeResource createAdvPrepymtFeeType(AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource) {
		return advPrepymtFeeTypeMapper.fromEntity(advPrepymtFeeTypeDao
				.createAdvPrepymtFeeType(advPrepymtFeeTypeMapper.fromResource(advPrepymtFeeTypeResource)));
	}

	/**
	 * update Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeResource
	 * @return advPrepymtFeeTypeResource
	 */
	public AdvPrepymtFeeTypeResource updateAdvPrepymtFeeType(AdvPrepymtFeeTypeResource advPrepymtFeeTypeResource,
			int id) {
		return advPrepymtFeeTypeMapper.fromEntity(advPrepymtFeeTypeDao
				.updateAdvPrepymtFeeType(advPrepymtFeeTypeMapper.fromResource(advPrepymtFeeTypeResource)));
	}

	/**
	 * delete Advance Prepayment Fee Type
	 *
	 * @param id
	 *            to delete the records
	 * @return advPrepymtFeeTypeResource
	 */
	public AdvPrepymtFeeTypeResource deleteAdvPrepymtFeeType(int id) {
		AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB;
		advPrepymtFeeTypeDB = advPrepymtFeeTypeDao.getAdvPrepymtFeeTypeById(id);
		if (advPrepymtFeeTypeDB == null) {
			throw new NotFoundException(AdvanceMaintenanceError.RECORD_NOT_FOUND, id);
		}
		return advPrepymtFeeTypeMapper.fromEntity(advPrepymtFeeTypeDao.deleteAdvPrepymtFeeType(advPrepymtFeeTypeDB));
	}

	/**
	 * Get a list of all Prepayment Fee Type
	 *
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AdvPrepymtFeeTypeResource> getAllAdvPrepymtFeeType() {

		List<AdvPrepymtFeeTypeResource> advPrepymtFeeTypeResources = new ArrayList();
		advPrepymtFeeTypeResources.addAll(advPrepymtFeeTypeDao.getAdvPrepymtFeeType().stream()
				.map(advPrepymtFeeTypeMapper::fromEntity).collect(Collectors.toList()));
		return advPrepymtFeeTypeResources;
	}

	/**
	 * Return Prepayment Fee Type report headers
	 *
	 * @return
	 */
	public Map<String, String> getListReportHeader() {

		Map<String, String> reportHeaders = new LinkedHashMap<>();
		reportHeaders.put("code", "Code");
		reportHeaders.put("desc", "Description");
		reportHeaders.put("indFeeCalcFlag", "Ind Fee Calc Flag");
		reportHeaders.put("actFeeCalcFlag", "Act Fee Calc Flag");
		reportHeaders.put("actReplRateFlag", "Act Repl Rate Flag");

		return reportHeaders;
	}

	/**
	 * Bind report data into JSON Object
	 */
	public String getReportData() {
		JSONObject records = new JSONObject();
		JSONArray report;
		List<AdvPrepymtFeeTypeResource> advPrepymtFeeTypeResource = getAllAdvPrepymtFeeType();
		report = new JSONArray();

		for (AdvPrepymtFeeTypeResource prepymentFeeType : advPrepymtFeeTypeResource) {
			report.put(prepymentFeeType.toJson());
		}
		records.put("records", report);

		return records.toString();
	}

}
