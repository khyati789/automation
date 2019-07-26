package com.fhlb.cds.maintenance.termexceptiontype;

import java.util.List;
import java.util.Optional;

import org.hibernate.NonUniqueResultException;
/**
 * This class perform database operations
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhlb.cds.maintenance.error.TermExceptionTypeError;
import com.fhlb.commons.exception.FieldRequiredException;

@Repository
public class TermExceptionTypeDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public TermExceptionTypeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Get all records from table
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TermExceptionTypeDB> getAllTermexceptiontype() {
		return sessionFactory.getCurrentSession().createQuery("SELECT c " + "FROM TermExceptionTypeDB c ").list();
	}

	/**
	 * Get the particular record based on id
	 * 
	 * @param id
	 * @return
	 */
	public Optional<TermExceptionTypeDB> getTermexceptiontypeById(int id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().get(TermExceptionTypeDB.class, id));
	}

	/**
	 * inserting new record
	 * 
	 * @param termexceptiontype
	 * @return
	 */
	public TermExceptionTypeDB createTermexceptiontype(TermExceptionTypeDB termexceptiontype) {
		Session session;

		session = sessionFactory.getCurrentSession();
		session.save(termexceptiontype);
		session.flush();

		return termexceptiontype;
	}

	/**
	 * Edit the particular record
	 * 
	 * @param termexceptiontype
	 * @return
	 */
	public TermExceptionTypeDB updateTermexceptiontype(TermExceptionTypeDB termexceptiontype) {
		Session session;

		session = sessionFactory.getCurrentSession();
		session.update(termexceptiontype);
		session.flush();
		return termexceptiontype;
	}

	/**
	 * Deleting the record
	 * 
	 * @param termexceptiontype
	 */
	public void deleteTermexceptiontype(TermExceptionTypeDB termexceptiontype) {
		sessionFactory.getCurrentSession().delete(termexceptiontype);
	}

	/**
	 * This method checks code is duplicated or not
	 * 
	 * @param code
	 * @return
	 */
	public boolean getTermExceptionTypeCode(String code) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM TermExceptionTypeDB c where c.termExceptionTypeCode = :code")
				.setParameter("code", code).uniqueResult() != null;
	}

	/**
	 * This method checks particular have unique code or not
	 * 
	 * @param id
	 * @param code
	 * @return
	 */
	public boolean checkDuplicate(int id, String code) {
		try{
		return sessionFactory.getCurrentSession()
				.createQuery("FROM TermExceptionTypeDB c " + "where c.id=:id or " + "c.termExceptionTypeCode=:code")
				.setParameter("id", id).setParameter("code", code).uniqueResult() != null;
	}
		catch(NonUniqueResultException n)
		{
			 throw new FieldRequiredException(TermExceptionTypeError.DUPLICATE_CODE);
		}
	}
}
