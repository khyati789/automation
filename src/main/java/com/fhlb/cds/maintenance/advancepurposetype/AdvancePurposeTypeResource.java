package com.fhlb.cds.maintenance.advancepurposetype;

/*
 *  This class defines form resource for Advances Purpose Type 
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fhlb.cds.maintenance.error.ErrorMessage;

@JsonInclude(value = Include.NON_NULL)
public class AdvancePurposeTypeResource implements Serializable {

	private static final long serialVersionUID = -580159332836620219L;

	private int id;

	@NotNull(message = ErrorMessage.CODE_REQUIRED)
	@NotBlank(message = ErrorMessage.CODE_REQUIRED)
	@Size(min = 1, max = 1)
	private String advPurposeTypeCode;

	@NotNull(message = ErrorMessage.DESC_REQUIRED)
	@NotBlank(message = ErrorMessage.DESC_REQUIRED)
	@Size(min = 1, max = 20)
	private String advPurposeTypeDescription;

	/**
	 * Get the advPurposeTypeId
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the advPurposeTypeId
	 * 
	 * @return
	 */
	public void setId(int advPurposeTypeId) {
		this.id = advPurposeTypeId;
	}

	/**
	 * Get the advPurposeTypeCode
	 * 
	 * @return
	 */
	public String getAdvPurposeTypeCode() {
		return advPurposeTypeCode;
	}

	/**
	 * Set the advPurposeTypeCode
	 * 
	 * @return
	 */
	public void setAdvPurposeTypeCode(String advPurposeTypeCode) {
		this.advPurposeTypeCode = advPurposeTypeCode;
	}

	/**
	 * Get the advPurposeTypeDescription
	 * 
	 * @return
	 */
	public String getAdvPurposeTypeDescription() {
		return advPurposeTypeDescription;
	}

	/**
	 * Set the advPurposeTypeDescription
	 * 
	 * @return
	 */
	public void setAdvPurposeTypeDescription(String advPurposeTypeDescription) {
		this.advPurposeTypeDescription = advPurposeTypeDescription.trim().replaceAll("\\s{2,}", " ");
	}

	/**
	 * This for setting json in key value format of report generating
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		Map<String, String> map = new HashMap<>();
		map.put("advancePurposeTypeCode", advPurposeTypeCode);
		map.put("advancePurposeTypeDescription", advPurposeTypeDescription);
		return new JSONObject(map);
	}
}
