package com.fhlb.cds.maintenance.termexceptiontype;

/**
 * This is a resource class
 */
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fhlb.cds.maintenance.error.ErrorMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermExceptionTypeResource implements Serializable {

	private static final long serialVersionUID = -6256846227747173774L;
	private int id;

	private String termExceptionTypeCode;

	@NotNull(message = ErrorMessage.NO_REQUIRED)
	@Digits(integer = 10, message = ErrorMessage.NO_INVALID, fraction = 0)
	private short termExceptionTypeNo;

	private String termExceptionTypeDescription;

	public TermExceptionTypeResource() {
		/** Default constructor **/
	}

	/**
	 * Get the termExceptionTypeCode
	 * 
	 * @return
	 */
	public String getTermExceptionTypeCode() {
		return termExceptionTypeCode;
	}

	/**
	 * Set the termExceptionTypeCode
	 * 
	 * @param termExceptionTypeCode
	 */
	public void setTermExceptionTypeCode(String termExceptionTypeCode) {
		this.termExceptionTypeCode = termExceptionTypeCode.trim().replaceAll("\\s+", "").toUpperCase();
	}

	/**
	 * Get the termExceptionTypeNo
	 * 
	 * @return
	 */
	public short getTermExceptionTypeNo() {
		return termExceptionTypeNo;
	}

	/**
	 * Set the termExceptionTypeNo
	 * 
	 * @param termExceptionTypeNo
	 */
	public void setTermExceptionTypeNo(short termExceptionTypeNo) {
		this.termExceptionTypeNo = termExceptionTypeNo;
	}

	/**
	 * Get the termExceptionTypeDesc
	 * 
	 * @return
	 */
	public String getTermExceptionTypeDescription() {
		return termExceptionTypeDescription;
	}

	/**
	 * Set the termExceptionTypeDesc
	 * 
	 * @param termExceptionTypeDescription
	 */
	public void setTermExceptionTypeDescription(String termExceptionTypeDescription) {
		this.termExceptionTypeDescription = termExceptionTypeDescription.trim().replaceAll("\\s{2,}", " ");
	}

	/**
	 * Get id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This for setting json in key value format of report generating
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("termExceptionTypeCode", termExceptionTypeCode);
		map.put("termExceptionTypeNo", termExceptionTypeNo);
		map.put("termExceptionTypeDescription", termExceptionTypeDescription);
		return new JSONObject(map);
	}

}