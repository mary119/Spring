package com.xworkz.corona;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.corona.dto.CovidDTO;
import com.xworkz.corona.service.ServiceDAO;

@Controller
@RequestMapping("/")
public class CovidPatient {
	
	@Autowired
	private ServiceDAO service;

	public CovidPatient() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	private List<CovidDTO> covidto=new ArrayList<CovidDTO>();

	
	@RequestMapping(value="/patient.do",method=RequestMethod.POST)
	public String addCPatientDtls(@ModelAttribute CovidDTO dto,Model model) {
		System.out.println("invoked on save" +dto);
		boolean saved=service.validateAndSave(dto);
			System.out.println("dto saved status" + saved);
			if(saved) {
				model.addAttribute("dto",dto);
				System.out.println("dto navigating to success page");
				return "saveSuccess";

			}
			System.out.println("dto is not saved ");
		return "corona";
	}
}

