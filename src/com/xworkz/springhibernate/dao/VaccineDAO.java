package com.xworkz.springhibernate.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.xworkz.springhibernate.dto.VaccineDTO;


public class VaccineDAO {
	
	private SessionFactory factory;
	
	public VaccineDAO(SessionFactory factory) {
		System.out.println(this.getClass().getSimpleName() + " created");
		this.factory = factory;

	}
	
	public void save(VaccineDTO dto) {
		Session session= null;
		Transaction tx = null;
		
		try{
//			/Configuration con= new Configuration();
//		con.configure("resources/hibernate.cfg.xml");
//		factory = con.buildSessionFactory();
		session = factory.openSession();
		tx= session.beginTransaction();
		session.save(dto);
		tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
	//	if(factory!=null)
	//		factory.close();

		}
	}
	public VaccineDTO updateNameById(String vaccineName, int vaccineId) {
		Session session = null;
		Transaction tx = null;
		VaccineDTO vaccineDTO=null;

		try{
			session = factory.openSession();
		    tx = session.beginTransaction();
		    vaccineDTO = session.get(VaccineDTO.class, vaccineId);
		    if (vaccineDTO != null) {
			vaccineDTO.setVaccineName(vaccineName);
			session.update(vaccineDTO);
		    }
		session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(session!=null) {
				session.close();
			}

		}
		return vaccineDTO;

	}
	
	public VaccineDTO fetchDtls(int vaccineId) {

		Session session = null;
		Transaction tx = null;
		VaccineDTO vaccineDTO=null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			 vaccineDTO = session.get(VaccineDTO.class, vaccineId);
			System.out.println(vaccineDTO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.close();

			}
		}
		return vaccineDTO;
	}
	
	public void deleteById(int vaccineId) {
		Session session=null;
		try{
			 session = factory.openSession();
		Transaction tx = session.beginTransaction();
		VaccineDTO vaccineDTO = session.get(VaccineDTO.class, vaccineId);
		if (vaccineDTO != null) {
			session.delete(vaccineDTO);
		}
		session.getTransaction().commit();
		}catch (Exception e) {
          e.printStackTrace();		
			if(session !=null) {
		      session.close();
			}
	}
	}



}
