package com.fhlb.cds.maintenance.termexceptiontype;

/**
 * This is a entity class
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fhlb.commons.Constants;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "term_excptn_type", schema = Constants.SCHEMA, catalog = Constants.CATALOG)
public class TermExceptionTypeDB implements Serializable {

	private static final long serialVersionUID = 2091821319359236911L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "term_excptn_type_id")
	private int id;

	@Column(name = "term_excptn_type_code")
	private String termExceptionTypeCode;

	@Column(name = "term_excptn_no")
	private short termExceptionTypeNo;

	@Column(name = "term_excptn_type_desc")
	private String termExceptionTypeDescription;

	public TermExceptionTypeDB() {
		/** Default constructor **/
	}

	/**
	 * Get the code
	 * 
	 * @return
	 */
	public String getTermExceptionTypeCode() {
		return termExceptionTypeCode;
	}

	/**
	 * Set the code
	 * 
	 * @param termExceptionTypeCode
	 */
	public void setTermExceptionTypeCode(String termExceptionTypeCode) {
		this.termExceptionTypeCode = termExceptionTypeCode;
	}

	/**
	 * Get the termExceptionNO
	 * 
	 * @return
	 */
	public short getTermExceptionTypeNo() {
		return termExceptionTypeNo;
	}

	/**
	 * Set the termExceptionNO
	 * 
	 * @param termExceptionTypeNo
	 */
	public void setTermExceptionTypeNo(short termExceptionTypeNo) {
		this.termExceptionTypeNo = termExceptionTypeNo;
	}

	/**
	 * Get the termExceptionDescription
	 * 
	 * @return
	 */
	public String getTermExceptionTypeDescription() {
		return termExceptionTypeDescription;
	}

	/**
	 * set the termExceptionDescription
	 * 
	 * @param termExceptionTypeDescription
	 */
	public void setTermExceptionTypeDescription(String termExceptionTypeDescription) {
		this.termExceptionTypeDescription = termExceptionTypeDescription;
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

}
