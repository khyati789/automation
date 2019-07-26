package com.fhlb.cds.maintenance.exceptionexplanation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fhlb.commons.Constants;

/**
 * This is just a DB class with getters and setters
 * 
 * @author o-rajput
 *
 */
@Entity
@Table(name = "adv_excptn_explntn", schema = Constants.SCHEMA, catalog = Constants.CATALOG)
public class AdvExcptnExplntnDB {

	public AdvExcptnExplntnDB() {
		/**
		 * Default Constructor
		 */
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adv_excptn_explntn_id")
	private int id;

	@Column(name = "adv_excptn_explntn_desc")
	private String advExcptnExplntnDesc;

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
		this.advExcptnExplntnDesc = advExcptnExplntnDesc;
	}

}
