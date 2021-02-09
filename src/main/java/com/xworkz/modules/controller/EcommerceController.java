package com.xworkz.modules.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.dto.LoginDTO;
import com.xworkz.modules.dto.ResetDTO;
import com.xworkz.modules.exception.ControllerException;
import com.xworkz.modules.exception.RepositoryException;
import com.xworkz.modules.exception.ServiceException;
import com.xworkz.modules.mailservice.SpringMailService;
import com.xworkz.modules.service.ServiceDAO;

@Controller
@RequestMapping("/")
public class EcommerceController {

	static Logger logger = Logger.getLogger(EcommerceController.class);

	@Autowired
	ServiceDAO service;
	
	@Autowired
	SpringMailService mailService;

	public EcommerceController() {
		// logger.debug("Created "+this.getClass().getSimpleName());
		logger.info("Created " + this.getClass().getSimpleName());
	}

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
	
	// @SessionScope("name")
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute EcommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
			throws ControllerException {
		try {
			List<EcommerceDTO> list=service.loginDetails(dto);
			String message = service.validateAndLogin(dto,loginDTO);
			
			for (EcommerceDTO eCommerceDTO : list) {
				
				logger.debug(message);
				if(message.equals("matching")){
					m.addAttribute("message","Hi "+eCommerceDTO.getFirstName());
					return "Home";
				}
			}
			
			if(message.equals("notMatching")){
				m.addAttribute("message","password and confirm password matching");
				return "Login";
			}if(message.equals("notRegistered")){
				m.addAttribute("message","This is not a registered email");
				return "Login";
			}

		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		} catch (Exception e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(@ModelAttribute EcommerceDTO dto, @ModelAttribute LoginDTO loginDTO, Model m)
			throws ControllerException {

		try {
			boolean validUser = service.isValidUser(dto);
			if (validUser) {
				m.addAttribute("message", "Login Success");
				m.addAttribute("name", "Hi " + loginDTO.getEmail());
				return "Home";
			} else {
				m.addAttribute("message", "user name or password not matching");
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Login";

	}
	
	@RequestMapping(value="/forgot.do", method=RequestMethod.POST)
	public String forgot(@ModelAttribute EcommerceDTO commerceDTO, Model m) throws ControllerException{
		
		try {
			System.out.println("Hello");
			boolean reset=service.resetPassword(commerceDTO);
			if(!reset){
				m.addAttribute("message","This email is not registered");
				return "ForgetPassword";
				
			}
		} catch (ServiceException e) {
		}
		return "Reset";
		
	}
	
	@RequestMapping(value="reset.do", method=RequestMethod.POST)
	public String resetPassword(@ModelAttribute ResetDTO dto,@ModelAttribute EcommerceDTO commerceDTO, Model m) throws ControllerException{
		try {
			String vaildAndUpdated=service.validateAndUpdatePassword( dto);
			
			if(vaildAndUpdated.equals("valid")){
			m.addAttribute("reset","Password updated");
			}
			else if(vaildAndUpdated.equals("invalid")){
			m.addAttribute("reset","Invalid otp");	
			}
			else if(vaildAndUpdated.equals("notMatching")){
				m.addAttribute("reset","Password and confirm password not matching");	
			}
			else if(vaildAndUpdated.equals("NA")){
				m.addAttribute("reset","Please fill fields with valid data");	
			}
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		return "Reset";
	}
}
