package com.xworkz.springCommon.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.dto.LoginDTO;
import com.xworkz.springCommon.exception.RepositoryException;

@Repository
public class EcommerceDAOImpl implements EcommerceDAO {

	public EcommerceDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}

	private SessionFactory factory;

	@Autowired
	public EcommerceDAOImpl(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + "crated");
		this.factory = factory;
	}

	@Override
	public long save(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		Transaction transaction = null;
		long id = dto.getId();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			id = (long) session.save(dto);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RepositoryException(e.getMessage());

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException {
		Session session = null;
		long l = 0;
		String email = dto.getEmail();
		try {
			session = factory.openSession();
			Query query = session.createQuery("select count(*) from EcommerceDTO  where email=:em");
			query.setParameter("em", email);
			l = (long) query.uniqueResult();
			// l = (Long)query.uniqueResult();
			System.out.println(l);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return l;
	}

	@Override
	public List<EcommerceDTO> fetchRowDtls(LoginDTO edto,EcommerceDTO dto) throws RepositoryException {
		List<EcommerceDTO> list = null;
		Session session = null;
		try {
			System.out.println(edto.getEmail());
			session = factory.openSession();
			Query query = session.createQuery("from EcommerceDTO where email=:e");
			query.setParameter("e", edto.getEmail());
			list = (List<EcommerceDTO>) query.list();
			//System.out.println(list);
			for (EcommerceDTO object : list) {
				System.out.println(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

//	@Override
//	public List<EcommerceDTO> fetchRowDtls(EcommerceDTO dto) throws RepositoryException {
//		Session session = null;
//        List<EcommerceDTO> ecommerceDTO=null;
//      // String email= dto.getEmail();
//		try {
//			session = factory.openSession();
//			Query query=session.createQuery("from EcommerceDTO  where email=:e");
//			query.setParameter("e",dto.getEmail());
//			ecommerceDTO=(List<EcommerceDTO>)query.list();
////			for(EcommerceDTO object:ecommerceDTO){
////				System.out.println(object);
////		    }
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RepositoryException(e.getMessage());
//		}finally {
//		if(session!=null) {
//				session.close();
//			}
//		}
//		return ecommerceDTO;
//	}	

}
