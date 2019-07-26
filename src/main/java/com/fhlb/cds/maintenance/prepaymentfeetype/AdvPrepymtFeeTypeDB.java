package com.fhlb.cds.maintenance.prepaymentfeetype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fhlb.commons.Constants;

@Entity
@Table(name = "adv_prepymt_fee_type", schema = Constants.SCHEMA, catalog = Constants.CATALOG)
public class AdvPrepymtFeeTypeDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adv_prepymt_fee_id")
	private int idDB;

	@Column(name = "adv_prepymt_fee_calc_code")
	private String advPrepymtFeeCalcCodeDB;

	@Column(name = "adv_prepymt_fee_desc")
	private String advPrepymtFeeDescDB;

	@Column(name = "ind_fee_calc_flag")
	private String indFeeCalcFlagDB;

	@Column(name = "act_fee_calc_flag")
	private String actFeeCalcFlagDB;

	@Column(name = "act_repl_rate_flag")
	private String actReplRateFlagDB;

	public AdvPrepymtFeeTypeDB() {
		// Default Constructor
	}

	public int getIdDB() {
		return idDB;
	}

	public void setIdDB(int idDB) {
		this.idDB = idDB;
	}

	public String getAdvPrepymtFeeCalcCodeDB() {
		return advPrepymtFeeCalcCodeDB.trim();
	}

	public void setAdvPrepymtFeeCalcCodeDB(String advPrepymtFeeCalcCodeDB) {
		this.advPrepymtFeeCalcCodeDB = advPrepymtFeeCalcCodeDB;
	}

	public String getAdvPrepymtFeeDescDB() {
		return advPrepymtFeeDescDB;
	}

	public void setAdvPrepymtFeeDescDB(String advPrepymtFeeDescDB) {
		this.advPrepymtFeeDescDB = advPrepymtFeeDescDB;
	}

	public String getIndFeeCalcFlagDB() {
		return indFeeCalcFlagDB;
	}

	public void setIndFeeCalcFlagDB(String indFeeCalcFlagDB) {
		this.indFeeCalcFlagDB = indFeeCalcFlagDB;
	}

	public String getActFeeCalcFlagDB() {
		return actFeeCalcFlagDB;
	}

	public void setActFeeCalcFlagDB(String actFeeCalcFlagDB) {
		this.actFeeCalcFlagDB = actFeeCalcFlagDB;
	}

	public String getActReplRateFlagDB() {
		return actReplRateFlagDB;
	}

	public void setActReplRateFlagDB(String actReplRateFlagDB) {
		this.actReplRateFlagDB = actReplRateFlagDB;
	}

}
