package com.fhlb.cds.maintenance.prepaymentfeetype;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.json.JSONObject;

import com.fhlb.cds.maintenance.error.ErrorMessage;

public class AdvPrepymtFeeTypeResource implements Serializable {

	private static final long serialVersionUID = -9018963912011181582L;
	private int id;
	@NotBlank(message = ErrorMessage.CODE_REQUIRED)
	@Size(max = 3, message = ErrorMessage.CODE_TOO_LONG)
	private String advPrepymtFeeCalcCode;
	@NotBlank(message = ErrorMessage.DESC_REQUIRED)
	@Size(max = 30, message = ErrorMessage.DESC_REQUIRED)
	private String advPrepymtFeeDesc;
	private String indFeeCalcFlag;
	private String actFeeCalcFlag;
	private String actReplRateFlag;

	public AdvPrepymtFeeTypeResource() {
		/** Default Constructor */
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdvPrepymtFeeCalcCode() {
		return advPrepymtFeeCalcCode;
	}

	public void setAdvPrepymtFeeCalcCode(String advPrepymtFeeCalcCode) {
		this.advPrepymtFeeCalcCode = advPrepymtFeeCalcCode;
	}

	public String getAdvPrepymtFeeDesc() {
		return advPrepymtFeeDesc;
	}

	public void setAdvPrepymtFeeDesc(String advPrepymtFeeDesc) {
		this.advPrepymtFeeDesc = advPrepymtFeeDesc.trim().replaceAll("\\s{2,}", " ");
	}

	public String getIndFeeCalcFlag() {
		return indFeeCalcFlag;
	}

	public void setIndFeeCalcFlag(String indFeeCalcFlag) {
		this.indFeeCalcFlag = indFeeCalcFlag;
	}

	public String getActFeeCalcFlag() {
		return actFeeCalcFlag;
	}

	public void setActFeeCalcFlag(String actFeeCalcFlag) {
		this.actFeeCalcFlag = actFeeCalcFlag;
	}

	public String getActReplRateFlag() {
		return actReplRateFlag;
	}

	public void setActReplRateFlag(String actReplRateFlag) {
		this.actReplRateFlag = actReplRateFlag;
	}

	public JSONObject toJson() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("code", advPrepymtFeeCalcCode);
		map.put("desc", advPrepymtFeeDesc);
		map.put("indFeeCalcFlag", indFeeCalcFlag);
		map.put("actFeeCalcFlag", actFeeCalcFlag);
		map.put("actReplRateFlag", actReplRateFlag);
		return new JSONObject(map);
	}
}
