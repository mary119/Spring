package com.xworkz.spring.service;

import java.util.List;

import com.xworkz.spring.dao.ElectionResultsDAOImpl;
import com.xworkz.spring.dto.ElectionResultsDTO;

public interface ElectionServices {

	public String validateAndSave(ElectionResultsDTO dto);
	
	public void deleteById(int eId);
	
	public void updateWadrdNoById(int wardNo, int eId);
	
	public ElectionResultsDTO getByPartyName(String partyName);

	List<ElectionResultsDTO> getList();

	
}
