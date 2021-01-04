package com.xworkz.corona.service;

import com.xworkz.corona.dto.CovidDTO;


public interface ServiceDAO {
	
	public boolean validateAndSave(CovidDTO coronaDTO);

}
