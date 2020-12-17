package com.xworkz.springhibernate.util;

import com.xworkz.springhibernate.dao.VaccineDAO;
import com.xworkz.springhibernate.dto.VaccineDTO;

public class VaccineTester {

	public static void main(String[] args) {

		VaccineDTO dto =new VaccineDTO();
		dto.setVaccineId(1);
		dto.setVaccineName("Pfizer");
		dto.setCountryName("USA");
		dto.setReadyToUse(true);
		
		//VaccineDAO dao = new VaccineDAO();
		//dao.save(dto);
	}

}
