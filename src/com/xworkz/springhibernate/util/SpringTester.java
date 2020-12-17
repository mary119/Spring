package com.xworkz.springhibernate.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.springhibernate.dao.VaccineDAO;
import com.xworkz.springhibernate.dto.VaccineDTO;
import com.xworkz.springhibernate.service.ServiceDAO;

import lombok.Data;
@Data
public class SpringTester {

	public static void main(String[] args) {


		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/spring.xml")) {

			VaccineDAO dao = container.getBean(VaccineDAO.class);

			VaccineDTO dto = new VaccineDTO();
			dto.setCountryName("USA");		
			dto.setVaccineId(2);
			dto.setVaccineName("Pfizer");
			dto.setReadyToUse(true);
			
			dao.save(dto);
			dao.updateNameById("covaxin", 2);
			dao.fetchDtls(2);
			dao.deleteById(3);
			
			//server side validations 
            ServiceDAO service= container.getBean(ServiceDAO.class);
			String value= service.validateAndSave(dto) ;
			System.out.println(value);
			if("FAILED".equals(value)) {
				System.out.println("data was not saved");
			}
		}
	}

}
