package com.fhlb.cds.maintenance.exceptionexplanation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author o-rajput
 *
 */
@Repository
public class AdvExcptnExplntnDao {

	@Autowired
	private SessionFactory sessionFactory;

	public AdvExcptnExplntnDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get list of Exception Explanation
	 * 
	 * @return list of advExcptnExplntnDB
	 */
	@SuppressWarnings("unchecked")
	public List<AdvExcptnExplntnDB> getAdvExcptnExplntn() {
		List<AdvExcptnExplntnDB> list = null;
		list = sessionFactory.getCurrentSession().createQuery("from AdvExcptnExplntnDB ORDER BY id ASC").list();
		return list;
	}

	/**
	 * Get Exception Explanation by id
	 * 
	 * @param id
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB getAdvExcptnExplntnById(int id) {
		AdvExcptnExplntnDB advExcptnExplntnDB;
		advExcptnExplntnDB = sessionFactory.getCurrentSession().get(AdvExcptnExplntnDB.class, id);
		sessionFactory.getCurrentSession().flush();
		return advExcptnExplntnDB;
	}

	/**
	 * Create new Exception Explanation Description
	 * 
	 * @param advExcptnExplntnDB
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB createAdvExplntnExcptn(AdvExcptnExplntnDB advExcptnExplntnDB) {
		sessionFactory.getCurrentSession().save(advExcptnExplntnDB);
		return advExcptnExplntnDB;
	}

	/**
	 * Update Exception Explanation Description
	 * 
	 * @param advExcptnExplntnDB
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB updateAdvExcptnExplntn(AdvExcptnExplntnDB advExcptnExplntnDB) {
		sessionFactory.getCurrentSession().update(advExcptnExplntnDB);
		return advExcptnExplntnDB;
	}

	/**
	 * Delete Exception Explanation Description
	 * 
	 * @param advExcptnExplntnDB
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB deleteAdvExcptnExplntn(AdvExcptnExplntnDB advExcptnExplntnDB) {
		sessionFactory.getCurrentSession().delete(advExcptnExplntnDB);
		return advExcptnExplntnDB;
	}

	/**
	 * Checking duplication
	 * 
	 * @param advExcptnExplntnDesc
	 * @return advExcptnExplntnDB
	 */
	public AdvExcptnExplntnDB isDuplicate(String advExcptnExplntnDesc) {
		AdvExcptnExplntnDB advExcptnExplntnDB;
		advExcptnExplntnDB = (AdvExcptnExplntnDB) sessionFactory.getCurrentSession()
				.createQuery("from AdvExcptnExplntnDB where advExcptnExplntnDesc= :desc")
				.setParameter("desc", advExcptnExplntnDesc).uniqueResult();

		return advExcptnExplntnDB;

	}
}
