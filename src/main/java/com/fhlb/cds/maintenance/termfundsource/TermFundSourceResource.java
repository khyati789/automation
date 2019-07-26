package com.fhlb.cds.maintenance.termfundsource;

/*
 *  This class defines form resource for Term Fund Source 
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fhlb.cds.maintenance.error.ErrorMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermFundSourceResource implements Serializable {

	private static final long serialVersionUID = 2886445831353977185L;

	@NotNull(message = ErrorMessage.CODE_REQUIRED)
	@Size(min = 1, max = 1, message = ErrorMessage.FUND_SOURCE_CODE_LENGTH)
	private String termFundSrcCode;

	@Size(max = 40, message = ErrorMessage.FUND_SOURCE_DESCRITION_LENGTH)
	private String termFundSrcDesc;

	@NotNull(message = ErrorMessage.NOT_FOUND)
	private int id;

	TermFundSourceResource() {
		/** Default constructor **/
	}

	/**
	 * Get the termFundSrcCode
	 * 
	 * @return
	 */
	public String getTermFundSrcCode() {
		return termFundSrcCode.toUpperCase();
	}

	/**
	 * Set the termFundSrcCode
	 * 
	 * @return
	 */
	public void setTermFundSrcCode(String termFundSrcCode) {
		this.termFundSrcCode = termFundSrcCode.toUpperCase();
	}

	/**
	 * Get the termFundSrcDesc
	 * 
	 * @return
	 */
	public String getTermFundSrcDesc() {
		return termFundSrcDesc;
	}

	/**
	 * Set the termFundSrcDesc
	 * 
	 * @return
	 */
	public void setTermFundSrcDesc(String termFundSrcDesc) {
		this.termFundSrcDesc = termFundSrcDesc;
	}

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
	 * @return
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
		Map<String, String> map = new HashMap<>();
		map.put("termFundSrcCode", termFundSrcCode);
		map.put("termFundSrcDesc", termFundSrcDesc);
		return new JSONObject(map);
	}

}