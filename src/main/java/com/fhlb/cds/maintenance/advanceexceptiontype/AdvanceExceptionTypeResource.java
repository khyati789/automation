package com.fhlb.cds.maintenance.advanceexceptiontype;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.json.JSONObject;

import com.fhlb.cds.maintenance.error.ErrorMessage;

/**
 * This is a resource class for form or ui
 * 
 * @author o-doraba
 *
 */
public class AdvanceExceptionTypeResource {

	private int id;
	@NotBlank(message = ErrorMessage.CODE_REQUIRED)
	@Size(max = 8, message = ErrorMessage.CODE_TOO_LONG)
	private String advanceExceptionTypeCode;
	@NotBlank(message = ErrorMessage.DESC_REQUIRED)
	@Size(max = 70, message = ErrorMessage.DESC_TOO_LONG)
	private String advanceExceptionTypeDescription;

	/**
	 * Get the id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the advanceExceptionTypeCode
	 * 
	 * @return
	 */
	public String getAdvanceExceptionTypeCode() {
		return advanceExceptionTypeCode;
	}

	/**
	 * Set the advanceExceptionTypeCode
	 * 
	 * @param advanceExceptionTypeCode
	 */
	public void setAdvanceExceptionTypeCode(String advanceExceptionTypeCode) {
		this.advanceExceptionTypeCode = advanceExceptionTypeCode.trim().replaceAll("\\s+", "");
	}

	/**
	 * Get the advanceExcetionType description
	 * 
	 * @return
	 */
	public String getAdvanceExceptionTypeDescription() {
		return advanceExceptionTypeDescription;
	}

	/**
	 * Set the advanceExceptionType description
	 * 
	 * @param advanceExceptionTypeDescription
	 */
	public void setAdvanceExceptionTypeDescription(String advanceExceptionTypeDescription) {
		this.advanceExceptionTypeDescription = advanceExceptionTypeDescription.trim().replaceAll("\\s{2,}", " ");
	}

	/**
	 * This for setting json in key value format of report generating
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		Map<String, String> map = new HashMap<>();
		map.put("advanceExceptionTypeCode", advanceExceptionTypeCode);
		map.put("advanceExceptionTypeDescription", advanceExceptionTypeDescription);
		return new JSONObject(map);
	}

}
