package com.xworkz.spring.dao;

import java.util.List;

import com.xworkz.spring.dto.ElectionResultsDTO;

public interface ElecionResultsDAO {
	
	public void save(ElectionResultsDTO dto);
	
	public String deleteById(int Eid);
	
	public void updateWardNoById(int eId,int wardNo);
	
	public ElectionResultsDTO getByPartyName(String partyName);
	
	List<ElectionResultsDTO> getList();

}
