package com.xworkz.springCommon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.service.ServiceDAO;

@Controller
@RequestMapping("/")
public class EcommerceController {
	
	public EcommerceController() {
		System.out.println("created" +this.getClass().getSimpleName());
	}
	@Autowired
	private ServiceDAO service;
	
	@RequestMapping(value="/landing.do",method=RequestMethod.POST)
	public String loginDetails(@ModelAttribute EcommerceDTO dto,Model model){
		System.out.println("invoke on save");
		boolean saved = service.validateAndSave(dto);
		if (saved) {
			String msg="Saved succesfully ";
			System.out.println(dto);
			return "SaveSuccess";
		}else
			System.out.println("dto is not saved");

		return "Landing";

	}

}


