package com.xworkz.spring.service;

import java.util.List;

import com.xworkz.spring.dao.ElectionResultsDAOImpl;
import com.xworkz.spring.dto.ElectionResultsDTO;

public class ElectionServiceImpl implements ElectionServices {

	private ElectionResultsDAOImpl erImpl;
	
	public ElectionServiceImpl(ElectionResultsDAOImpl erImpl) {
		System.out.println("created" + this.getClass().getSimpleName());
		this.erImpl=erImpl;
	}
	
	public String validateAndSave(ElectionResultsDTO dto) {
		System.out.println("invoke validate and save ");
		String message="NA";
		boolean valid=false;
		if(dto!=null ) {
			System.out.println("dto is an object");
			int id= dto.getEId();
			String pname=dto.getPartyName();
			String cname= dto.getCandidateName();
			int wardno= dto.getWardNo();
			int wonby=dto.getWonBy();
			
			if(id>0) {
				System.out.println("Id is valid");
				valid =true;
			}else {
				System.out.println("Id is not valid");
				valid=false;
			}
			
			if (valid) {
				if (pname != null && pname.length() >= 3 && pname.length() <= 15) {
					System.out.println("pname is valid");
					valid = true;
				} else {
					System.out.println("pname is not valid");
					valid = false;
				}
			}
			
			if (valid) {
				if (cname != null && !cname.isEmpty()) {
					System.out.println("cnamme is valid");
					valid = true;
				} else {
					System.out.println("cname is not valid");
				}
			}
			if (valid) {
				if (wardno >= 1 && wardno <= 500) {
					System.out.println("wradno is valid");
				} else {
					System.out.println("not valid");
				}
			}
			
			if (valid) {
				if (wonby > 0) {
					System.out.println("wonBy is valid");
					valid = true;
				} else {
					System.out.println("wonBy is not valid");
				}
			}
			if(valid) {
				System.out.println("save the object");
				 message= "success";
				 erImpl.save(dto);
			}else {
				System.out.println("dto is not saved");
				message="failed";
			}
		}
		return message;
		
	}
	
	@Override
	public void deleteById(int eId) {

		erImpl.deleteById(eId);
		System.out.println("deleted by id");
	}

	@Override
	public void updateWadrdNoById(int wardNo, int eId) {
      erImpl.updateWardNoById(eId, wardNo);
      System.out.println("updated ward no by id");
		
	}

	@Override
	public ElectionResultsDTO getByPartyName(String partyName) {
		return erImpl.getByPartyName(partyName);
		 
	}

	@Override
	public List<ElectionResultsDTO> getList() {
		return erImpl.getList();
	}

	
	
	
	
}
