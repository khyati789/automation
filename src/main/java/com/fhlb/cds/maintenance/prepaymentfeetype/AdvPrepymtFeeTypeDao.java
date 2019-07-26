package com.fhlb.cds.maintenance.prepaymentfeetype;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdvPrepymtFeeTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public AdvPrepymtFeeTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * get Advance Prepayment Fee Type
	 *
	 * @param
	 * @return List of advPrepymtFeeTypeDB
	 */
	@SuppressWarnings("unchecked")
	public List<AdvPrepymtFeeTypeDB> getAdvPrepymtFeeType() {
		List<AdvPrepymtFeeTypeDB> list = null;
		list = sessionFactory.getCurrentSession().createQuery("from AdvPrepymtFeeTypeDB ORDER BY id ASC").list();
		return list;
	}

	/**
	 * get Advance Prepayment Fee Type By Id
	 *
	 * @param id
	 *            to fetch the specific record
	 * @return advPrepymtFeeTypeDB
	 */
	public AdvPrepymtFeeTypeDB getAdvPrepymtFeeTypeById(int id) {
		AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB;
		advPrepymtFeeTypeDB = sessionFactory.getCurrentSession().get(AdvPrepymtFeeTypeDB.class, id);
		return advPrepymtFeeTypeDB;
	}

	/**
	 * Insert Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeDB
	 * @return advPrepymtFeeTypeDB
	 */
	public AdvPrepymtFeeTypeDB createAdvPrepymtFeeType(AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB) {
		sessionFactory.getCurrentSession().save(advPrepymtFeeTypeDB);
		return advPrepymtFeeTypeDB;
	}

	/**
	 * Update Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeDB
	 * @return advPrepymtFeeTypeDB
	 */
	public AdvPrepymtFeeTypeDB updateAdvPrepymtFeeType(AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB) {
		sessionFactory.getCurrentSession().update(advPrepymtFeeTypeDB);
		return advPrepymtFeeTypeDB;
	}

	/**
	 * delete Advance Prepayment Fee Type
	 *
	 * @param advPrepymtFeeTypeDB
	 * @return dvPrepymtFeeTypeDB
	 */
	public AdvPrepymtFeeTypeDB deleteAdvPrepymtFeeType(AdvPrepymtFeeTypeDB advPrepymtFeeTypeDB) {
		sessionFactory.getCurrentSession().delete(advPrepymtFeeTypeDB);
		return advPrepymtFeeTypeDB;
	}

}
