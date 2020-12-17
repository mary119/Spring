package com.xworkz.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.xworkz.spring.dto.ElectionResultsDTO;

public class ElectionResultsDAOImpl implements ElecionResultsDAO {

	private SessionFactory factory;
	public ElectionResultsDAOImpl(SessionFactory factory) {
         System.out.println(this.getClass().getSimpleName());
         this.factory=factory;
	}
	
	//LocalSessionFactoryBean
	@Override
	public void save(ElectionResultsDTO dto) {
		
		Session session =null;
		Transaction tx = null;
		try {
			/*Configuration con = new Configuration();
			con.configure("resources/hibernate.cfg.xml");
			factory=con.buildSessionFactory();*/
			session= factory.openSession();
			tx=session.beginTransaction();
			session.save(dto);
			tx.commit();
		}catch (Exception e) {
            e.printStackTrace();		
            if(tx!=null) {
            	tx.rollback();
            }
            
		}finally {
			if(session!=null) {
            	session.close();
            }
			if(factory!=null) {
				factory.close();
			}
		}

		
	}

	@Override
	public String deleteById(int eId) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			ElectionResultsDTO dto = session.get(ElectionResultsDTO.class, eId);
			if (dto != null) {
				dto.setEId(eId);
				session.delete(dto);
			}
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void updateWardNoById(int eId, int wardNo) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			ElectionResultsDTO dto = session.get(ElectionResultsDTO.class, eId);
			if (dto != null) {
				dto.setEId(eId);
				dto.setWardNo(wardNo);
			}
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (session != null) {
				session.close();
			 }

		
	     }
   
	}

	@Override
	public ElectionResultsDTO getByPartyName(String partyName) {
       Session session = null;
       ElectionResultsDTO eDTO=null;
       try {
    	   session=factory.openSession();
    	   Query query = session.createQuery("from ElectionResultsDTO where partyName=:pn");
			query.setParameter("pn", partyName);
    	   eDTO=(ElectionResultsDTO) query.uniqueResult();
    	   //System.out.println(eDTO);
    	   
       }catch(HibernateException e) {
    	   e.printStackTrace();
    	   if(session!=null) {
    		   session.close();
    	   }
       }
		
		return eDTO;
	}

	@Override
	public List<ElectionResultsDTO> getList() {
        Session session =null;
       List<ElectionResultsDTO> dto=null;

        try {
        	session= factory.openSession();
        	Query query=session.createQuery("from ElectionResultsDTO");
        		dto = query.list();
        	}catch (HibernateException e) {
        		e.printStackTrace();
        		}finally {
        	if(session!=null) 
        		session.close();
        	}
        return dto;
       }
	
}
