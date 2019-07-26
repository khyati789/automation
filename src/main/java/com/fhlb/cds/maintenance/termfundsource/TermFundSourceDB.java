package com.fhlb.cds.maintenance.termfundsource;

/**
 *  This class defines form bean for Term Fund Source 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "term_fund_src", schema = "dbo", catalog = "prod01")
public class TermFundSourceDB implements Serializable {

	private static final long serialVersionUID = 2886445831353977185L;

	@Column(name = "term_fund_src_code", nullable = false, length = 1)
	private String termFundSrcCode;

	@Column(name = "fund_src_desc", nullable = false, length = 40)
	private String termFundSrcDesc;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "term_fund_src_id")
	private int id;

	public TermFundSourceDB() {
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
		return termFundSrcDesc.trim();
	}

	/**
	 * Set the termFundSrcDesc
	 * 
	 * @return
	 */
	public void setTermFundSrcDesc(String termFundSrcDesc) {
		this.termFundSrcDesc = termFundSrcDesc.trim();
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

}
