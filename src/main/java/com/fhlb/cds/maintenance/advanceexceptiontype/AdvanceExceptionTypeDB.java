package com.fhlb.cds.maintenance.advanceexceptiontype;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fhlb.commons.Constants;

/**
 * This is a entity class for database table
 * 
 * @author o-doraba
 * 
 */
@Entity
@Table(name = "adv_excptn_type", schema = Constants.SCHEMA, catalog = Constants.CATALOG)
public class AdvanceExceptionTypeDB implements Serializable {
	private static final long serialVersionUID = -2056875843055134001L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adv_excptn_type_id")
	private int id;
	@Column(name = "adv_excptn_type_code")
	private String advanceExceptionTypeCode;
	@Column(name = "adv_excptn_type_desc")
	private String advanceExceptionTypeDesc;

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
		this.advanceExceptionTypeCode = advanceExceptionTypeCode;
	}

	/**
	 * Get the advanceExceptiontype Description
	 * 
	 * @return
	 */
	public String getAdvanceExceptionTypeDesc() {
		return advanceExceptionTypeDesc;
	}

	/**
	 * Set the advanceExceptionType Description
	 * 
	 * @param advanceExceptionTypeDesc
	 */
	public void setAdvanceExceptionTypeDesc(String advanceExceptionTypeDesc) {
		this.advanceExceptionTypeDesc = advanceExceptionTypeDesc;
	}
}
