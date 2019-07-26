package com.fhlb.cds.maintenance.termfundsource;

/**
 * This class perform all database operations.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TermFundSourceDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public TermFundSourceDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get the data from term fund source database table
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TermFundSourceDB> getAllTermFundSource() {
		return sessionFactory.getCurrentSession().createQuery("FROM TermFundSourceDB ORDER BY id ASC ").list();
	}

	/***
	 * Get termFundSourceDB by id
	 *
	 * @param id
	 * @return
	 */
	public TermFundSourceDB getTermFundSourceById(int id) {
		return sessionFactory.getCurrentSession().get(TermFundSourceDB.class, id);
		// return
		// sessionFactory.getCurrentSession().get(AdvancePurposeTypeDB.class,
		// id);
	}

	/**
	 * Create a new term fund source
	 *
	 * @param termFundSourceDB
	 * @return
	 */
	public TermFundSourceDB createTermFundSource(TermFundSourceDB termFundSource) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.save(termFundSource);
		session.flush();
		return termFundSource;
	}

	/**
	 * Updating the term fund source record
	 * 
	 * @param termFundSourceDB
	 * @return
	 */
	public TermFundSourceDB updateTermFundSource(TermFundSourceDB termFundSource) {
		Session session;
		session = sessionFactory.getCurrentSession();
		session.update(termFundSource);
		session.flush();
		return termFundSource;
	}

	/***
	 * Delete resource of term fund source
	 *
	 * @param termFundSourceResource
	 * @return
	 * 
	 */
	/*
	 * public void deleteTermFundSource(TermFundSourceDB termFundSource) {
	 * sessionFactory.getCurrentSession() .delete(termFundSource); }
	 */
	public TermFundSourceDB deleteTermFundSource(int id) {
		Session session;
		session = sessionFactory.getCurrentSession();
		TermFundSourceDB termFundSource = session.get(TermFundSourceDB.class, id);
		session.delete(termFundSource);
		session.flush();
		return termFundSource;
	}

	/**
	 * Create and Edit time check term fund source code is already exist or not
	 * 
	 * @return
	 */
	public boolean getTermFundSourceCode(String code) {
		return sessionFactory.getCurrentSession().createQuery("FROM TermFundSourceDB where termFundSrcCode = :code")
				.setParameter("code", code).uniqueResult() != null;
	}

	/**
	 * Update time check term fund source code is already exist or not
	 * 
	 * @return
	 */
	/*
	 * public boolean getEditCodeDuplicate(TermFundSourceResource
	 * termFundSourceResource) { return sessionFactory.getCurrentSession()
	 * .createQuery("FROM TermFundSourceDB where termFundSrcCode = :code AND id != id"
	 * ) .setParameter("code",
	 * termFundSourceResource.getTermFundSrcCode()).setParameter("id",
	 * termFundSourceResource.getId()).uniqueResult() != null; }
	 */
}
