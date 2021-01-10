package com.xworkz.springCommon.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.springCommon.dto.EcommerceDTO;

@Repository
public class EcommerceDAOImpl implements EcommerceDAO{

	public EcommerceDAOImpl() {
		System.out.println(this.getClass().getSimpleName() +"created");
	}
	private SessionFactory factory;
	
	@Autowired
	public EcommerceDAOImpl(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() +"crated");
		this.factory=factory;
	}
	
	
	@Override
	public long save(EcommerceDTO dto) {
		Session session = null;
		Transaction transaction = null;
		long id=dto.getId();
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			id=(long) session.save(dto);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

}
