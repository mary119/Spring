package com.xworkz.modules.dao;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.dto.ResetDTO;
import com.xworkz.modules.exception.RepositoryException;

@Repository
public class EcommerceDAOImpl implements EcommerceDAO{
	
	static Logger logger = Logger.getLogger(EcommerceDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public EcommerceDAOImpl() {
		logger.info("Ceated " + this.getClass().getSimpleName());
	}

	public int save(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		int id = dto.getId();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			id = (int) session.save(dto);
			logger.debug(id);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {

			throw new RepositoryException(e.getMessage());

		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		long l;
		String email = dto.getEmail();
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from EcommerceDTO where email=:e ");
			query.setParameter("e", email);
			l = (Long) query.uniqueResult();
			logger.debug(l);
			logger.debug(l);
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {

			throw new RepositoryException(e.getMessage());

		}finally {
			if (session != null)
				session.close();
		}
		return l;
	}

	@Override
	public List<EcommerceDTO> fetchTable(EcommerceDTO dto) throws RepositoryException {
		List<EcommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EcommerceDTO ");

			list = (List<EcommerceDTO>) query.list();

		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<EcommerceDTO> fetchRow(EcommerceDTO dto) throws RepositoryException {
		List<EcommerceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EcommerceDTO where email=:e");
			query.setParameter("e", dto.getEmail());
			list = (List<EcommerceDTO>) query.list();

		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public String fetchPassword(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		String password = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select password from EcommerceDTO where email=:e");
			query.setParameter("e", dto.getEmail());
			password = (String) query.uniqueResult();

		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return password;
	}

	@Override
	public boolean isValidUser(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(1) from EcommerceDTO where email=:e and password=:p");
			query.setParameter("e", dto.getEmail());
			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public String updatePassword(EcommerceDTO commerceDTO) throws RepositoryException {
		Session session = null;
		String randomString = null;
		Transaction transaction = null;
		randomString = RandomStringUtils.random(5, true, false);
		logger.debug(randomString);
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set password=:p where email=:e");
			query.setParameter("e", commerceDTO.getEmail());
			query.setParameter("p", randomString);

			int status = query.executeUpdate();
			logger.debug(status);
			transaction.commit();
			return randomString;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		

	}

	@Override
	public boolean isValidOtp(ResetDTO dto) throws RepositoryException {
		Session session = null;
		long count = 0;
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from EcommerceDTO where password=:p");

			query.setParameter("p", dto.getPassword());

			count = (long) query.uniqueResult();
			if (count > 0)
				return true;
		} catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		}catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean resetPassword( ResetDTO resetDTO) throws RepositoryException {
		Session session = null;

		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("update EcommerceDTO set password=:p where password=:q");
			query.setParameter("p", resetDTO.getNewPassword());
			query.setParameter("q", resetDTO.getPassword());
			
			
			int status = query.executeUpdate();
			logger.debug(status);
			transaction.commit();
			return true;
		}catch (HibernateException e) {

			throw new RepositoryException(e.getMessage());

		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		} finally {
			session.close();
		}
		
	}


}
