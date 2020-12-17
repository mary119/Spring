package com.xworkz.spring.util;

import com.xworkz.spring.dao.ElecionResultsDAO;
import com.xworkz.spring.dao.ElectionResultsDAOImpl;
import com.xworkz.spring.dto.ElectionResultsDTO;

public class ResultsTester {

	public static void main(String[] args) {

		ElectionResultsDTO dto = new ElectionResultsDTO();
	
		dto.setPartyName("Congress");
		dto.setCandidateName("Mary");
		dto.setWardNo(5);
		dto.setWonBy(1500);
		
		//ElecionResultsDAO dao = new ElectionResultsDAOImpl();
		//dao.save(dto);
	}

}
