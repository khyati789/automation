package com.fhlb.cds.maintenance.advanceexceptiontype;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class perform all database operations.
 * 
 * @author o-doraba
 *
 */
@Repository
@Transactional
public class AdvanceExceptionTypeDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public AdvanceExceptionTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get the data from advance exception type database table
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AdvanceExceptionTypeDB> getAdvanceExceptionTypeData() {
		return sessionFactory.getCurrentSession().createQuery("FROM AdvanceExceptionTypeDB").list();
	}

	/**
	 * Delete the advance exception type record
	 * 
	 * @param advanceExceptionTypeDB
	 */
	public void deleteAdvanceExceptionTypeData(AdvanceExceptionTypeDB advanceExceptionTypeDB) {
		sessionFactory.getCurrentSession().delete(advanceExceptionTypeDB);
	}

	/**
	 * Get the record of advance exception type by advance exception type id
	 * 
	 * @param advanceExceptionTypeId
	 * @return
	 */
	public AdvanceExceptionTypeDB getAdvanceExceptionTypeByExceptionTypeId(int advanceExceptionTypeId) {
		return sessionFactory.getCurrentSession().get(AdvanceExceptionTypeDB.class, advanceExceptionTypeId);
	}

	/**
	 * Updating the advance exception type record
	 * 
	 * @param advanceExceptionTypeDB
	 * @return
	 */
	public AdvanceExceptionTypeDB updateAdvanceExceptionType(AdvanceExceptionTypeDB advanceExceptionTypeDB) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.update(advanceExceptionTypeDB);
		return advanceExceptionTypeDB;
	}

	/**
	 * Creating new Advance exception type record
	 * 
	 * @param advanceExceptionTypeDB
	 * @return
	 */
	public AdvanceExceptionTypeDB createAdvanceExceptionType(AdvanceExceptionTypeDB advanceExceptionTypeDB) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.save(advanceExceptionTypeDB);
		session.flush();
		return advanceExceptionTypeDB;

	}
}
