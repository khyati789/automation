package com.fhlb.cds.maintenance.advancepurposetype;

/**
 * This class perform all database operations.
 */

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AdvancePurposeTypeDao {

	private SessionFactory sessionFactory;

	@Autowired
	public AdvancePurposeTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get the data from advance purpose type database table
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AdvancePurposeTypeDB> getAdvancePurposeTypeData() {
		return sessionFactory.getCurrentSession().createQuery("FROM AdvancePurposeTypeDB ORDER BY id ASC").list();
	}

	/**
	 * Create a new advance purpose type
	 *
	 * @param advancePurposeTypeDB
	 * @return
	 */
	public AdvancePurposeTypeDB createPurposeType(AdvancePurposeTypeDB advPurposeTypeDB) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.save(advPurposeTypeDB);
		session.flush();
		return advPurposeTypeDB;
	}

	/***
	 * Get advancePurposeTypeDB by id
	 *
	 * @param id
	 * @return
	 */
	public AdvancePurposeTypeDB getPurposeTypeId(int id) {
		return sessionFactory.getCurrentSession().get(AdvancePurposeTypeDB.class, id);
	}

	/**
	 * Updating the advance purpose type record
	 * 
	 * @param advancepurposeTypeDB
	 * @return
	 */
	public AdvancePurposeTypeDB updatePurposeType(AdvancePurposeTypeDB advancePurposeTypeDB) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.update(advancePurposeTypeDB);
		session.flush();
		return advancePurposeTypeDB;
	}

	/***
	 * Get resource of advance purpose type by id
	 *
	 * @param id
	 * @param advancePurposeTypeResource
	 * @return
	 * 
	 * 		Delete a purpose type
	 */
	public AdvancePurposeTypeDB deletePurposeType(int id) {
		Session session;
		session = sessionFactory.getCurrentSession();
		AdvancePurposeTypeDB advancePurposeTypeDB = session.get(AdvancePurposeTypeDB.class, id);
		session.delete(advancePurposeTypeDB);
		session.flush();
		return advancePurposeTypeDB;
	}

	/**
	 * Update time check advance purpose type code is already exist or not
	 * 
	 * @return
	 */
	public boolean getPurposeTypeCode(String code) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM AdvancePurposeTypeDB where advPurposeTypeCode = :code").setParameter("code", code)
				.uniqueResult() != null;
	}
}
