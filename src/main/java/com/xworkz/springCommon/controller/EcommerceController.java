package com.xworkz.springCommon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.dto.LoginDTO;
import com.xworkz.springCommon.exception.ServiceException;
import com.xworkz.springCommon.mailservice.SpringMailService;
import com.xworkz.springCommon.service.ServiceDAO;

@Controller
@RequestMapping("/")
public class EcommerceController {

	public EcommerceController() {
		System.out.println("created" + this.getClass().getSimpleName());
	}
	static Logger logger= Logger.getLogger(EcommerceController.class);

	@Autowired
	private ServiceDAO service;

	@Autowired
	private SpringMailService mailService;

	@RequestMapping(value = "/landing.do", method = RequestMethod.POST)
	public String loginDetails(@ModelAttribute EcommerceDTO dto, Model model, HttpServletRequest req) {
		System.out.println("invoke on save");

		try {
			String saved = service.validateAndSave(dto);
			//System.out.println);

			if (saved.equals("email is not valid")) {
				model.addAttribute("not valid","Email is duplicte");
				System.out.println("Not saved");

			}

			if (saved.equals("saved")) {
				model.addAttribute("success", "Registration Success");
				// System.out.println("Saved success");
				logger.debug("succesFully Saved");
				boolean sent = mailService.sendMail(dto);
				if (sent) {
					// System.out.println("Sent succesfully");
					model.addAttribute("message", "Mail sent successfully");
					logger.debug("Mail sent");
				} else {
					// System.out.println("Sending failed");
					model.addAttribute("msg", "Sending failed");
					logger.debug("Sending failed");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Landing";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginDtls(@ModelAttribute LoginDTO edto,@ModelAttribute EcommerceDTO dto,Model model) {
		System.out.println("invoking logindtls");
		try {
			List<EcommerceDTO> list=service.validateAndLogin(edto,dto);
			System.out.println(dto);
			for(EcommerceDTO object:list) {
               //  System.out.println("Helo is it working");
				if(object.getPassword().equals(edto.getPassword())) {
					System.out.println("Passwords are matching, Login suceesful");
					model.addAttribute("login", "Login success");
					model.addAttribute("name","Hi "+dto.getFirstname());
					
				}else{
					model.addAttribute("login", "Login failed ");
					System.out.println("Email/Password are incorrect, Login failed");
					return "Landing";
				}

		}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Login";
		
	}
}
