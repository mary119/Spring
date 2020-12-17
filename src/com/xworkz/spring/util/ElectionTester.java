package com.xworkz.spring.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.spring.dto.ElectionResultsDTO;
import com.xworkz.spring.service.ElectionServiceImpl;

import lombok.Data;

@Data
public class ElectionTester {

	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("resources/spring.xml");){
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
		
	        ElectionResultsDTO dto= new ElectionResultsDTO();
	        dto.setEId(7);
	        dto.setPartyName("JDS");
			dto.setCandidateName("ks");
			dto.setWardNo(5);
			dto.setWonBy(1500);
			
			ElectionServiceImpl service = container.getBean(ElectionServiceImpl.class);
			//service.validateAndSave(dto);
			
			//service.updateWadrdNoById(10, 2);
			//service.deleteById(1);
			 dto=service.getByPartyName("JDS");
		     System.out.println(dto);
			//System.out.println(value);
			
//			List<ElectionResultsDTO> Dto=service.getList();
//			System.out.println(Dto);
		}
		
	}

}
