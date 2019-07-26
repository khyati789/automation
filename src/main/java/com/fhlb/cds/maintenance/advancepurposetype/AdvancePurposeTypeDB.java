package com.fhlb.cds.maintenance.advancepurposetype;

/**
 *  This class defines form bean for Advances Purpose Type 
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fhlb.commons.Constants;

@Entity
@Table(name = "adv_purp_type", schema = Constants.SCHEMA, catalog = Constants.CATALOG)
public class AdvancePurposeTypeDB implements Serializable {

	private static final long serialVersionUID = 2886445831353977185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adv_purp_type_id")
	private int id;

	@Column(name = "adv_purp_code", nullable = false, length = 1)
	private String advPurposeTypeCode;

	@Column(name = "adv_purp_desc", nullable = false, length = 20)
	private String advPurposeTypeDescription;

	public AdvancePurposeTypeDB() {
		super();
		// Default constructor
	}

	public AdvancePurposeTypeDB(int advPurposeTypeId, String advPurposeTypeCode, String advPurposeTypeDescription) {
		super();
		this.id = advPurposeTypeId;
		this.advPurposeTypeCode = advPurposeTypeCode;
		this.advPurposeTypeDescription = advPurposeTypeDescription;
	}

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
		this.advPurposeTypeDescription = advPurposeTypeDescription;
	}
}
