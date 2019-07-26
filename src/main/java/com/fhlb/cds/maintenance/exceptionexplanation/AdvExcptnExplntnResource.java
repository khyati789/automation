package com.fhlb.cds.maintenance.exceptionexplanation;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fhlb.cds.maintenance.error.ErrorMessage;

/**
 * This is just a resource class with getters and setters
 * 
 * @author o-rajput
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvExcptnExplntnResource implements Serializable {

	private static final long serialVersionUID = -6593786161424631742L;

	private int id;

	@NotBlank(message = ErrorMessage.DESC_REQUIRED)
	@Size(max = 60, message = ErrorMessage.DESC_TOO_LONG)
	private String advExcptnExplntnDesc;

	public AdvExcptnExplntnResource() {
		/**
		 * Default Constructor
		 */
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * advExcptnExplntnDesc : Advance Exception Explanation Description
	 * 
	 */
	public String getAdvExcptnExplntnDesc() {
		return advExcptnExplntnDesc; 
	}

	public void setAdvExcptnExplntnDesc(String advExcptnExplntnDesc) {
		this.advExcptnExplntnDesc = advExcptnExplntnDesc.trim().replaceAll("\\s{1,}", " ");
	}

	public JSONObject toJson() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("desc", advExcptnExplntnDesc);
		return new JSONObject(map);
	}
}
