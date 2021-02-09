package com.xworkz.modules.service;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.modules.dao.EcommerceDAO;
import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.dto.LoginDTO;
import com.xworkz.modules.dto.ResetDTO;
import com.xworkz.modules.exception.RepositoryException;
import com.xworkz.modules.exception.ServiceException;
import com.xworkz.modules.mailservice.SpringMailService;

@Service
public class ServiceDAOImpl implements ServiceDAO{
	
	static Logger logger = Logger.getLogger(ServiceDAOImpl.class);

	@Autowired
	private EcommerceDAO dao;

	@Autowired
	SpringMailService emailService;

	@Autowired
	PasswordResetService passwordResetService;

	public ServiceDAOImpl() {
		// logger.debug("Created " + this.getClass().getSimpleName());
		logger.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateAndSave(EcommerceDTO dto) throws ServiceException {
		String message = "NA";
		boolean valid = false;

		System.out.println("Invoked validate and save method.");
		if (Objects.nonNull(dto)) {
			String fname = dto.getFirstName();
			if (!fname.isEmpty() && fname.length() > 3) {
				System.out.println("fname is valid");
				valid = true;
			} else {
				System.out.println("fname is not valid");
				valid = false;
			}
		}

		if (valid) {
			String lname = dto.getFirstName();
			if (!StringUtils.isEmpty(lname) && lname.length() > 3) {
				System.out.println("Last name is valid");
				valid = true;
			} else {
				System.out.println(" Last name is invalid");
				valid = false;

			}
		}
		if (valid) {
			String email = dto.getEmail();
			if (!StringUtils.isEmpty(email)) {
				String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
						+ "A-Z]{2,7}$";

				boolean result = email.matches(regex);
				System.out.println("Email is valid");

				valid = true;
			} else {
				System.out.println("Email is invalid");
				valid = false;

			}

		}

		if (valid) {
			String password = dto.getPassword();
			if (password.length() > 4) {
				System.out.println("Password is valid");
				valid = true;

			} else {
				System.out.println("Password is invalid");
				valid = false;

			}

		}
		if (valid) {
			String password = dto.getPassword();
			String cpwd = dto.getConfirmPassword();
			if (password.equals(cpwd)) {
				System.out.println("Passwords are matching and  valid");
				valid = true;

			} else {
				System.out.println("Password are not matching and invalid");
				valid = false;

			}

		}

		if (valid) {

			System.out.println("data is ready to save to DB");
			try {
				if (dao.fetchEmailCount(dto) > 0) {
					message = "email is not valid";
				} else {
					dao.save(dto);
					System.out.println("inputs are valid and saving");
					message = "saved";
				}
			} catch (RepositoryException e) {
				//throw new ServiceException(e.getMessage());

			} catch (Exception e) {
				throw new ServiceException(e.getMessage());

			}
		} else {
			System.out.println("Inputs are invalid and notsaving");
		}

		return message;
	}


	
	
	@Override
	public List<EcommerceDTO> loginDetails(EcommerceDTO dto) throws RepositoryException{
		List<EcommerceDTO> list=dao.fetchRow(dto);
		for(EcommerceDTO object:list) {
		System.out.println(object);
		}
		return list;
		
		
	}

	public String validateAndLogin(EcommerceDTO dto,LoginDTO loginDTO) throws ServiceException {
		String message=null;
		try {
			List<EcommerceDTO> list = dao.fetchRow(dto);
			String p = dao.fetchPassword(dto);
			
			
			if (list.size() == 1) {

				for (EcommerceDTO eCommerceDTO : list) {

					logger.debug(eCommerceDTO.getFirstName());
					logger.debug(list.size());
					System.out.println(eCommerceDTO.getFirstName());


					if (eCommerceDTO.getPassword().equals(loginDTO.getPassword())) {
						logger.debug("password and confirm password matching");
						System.out.println("password and confirm are password matching");
						message="matching";
					}

					else {
						logger.debug(eCommerceDTO);
						logger.debug("password and confirm password not matching");
						
						message= "notMatching";
					}
				}
			} else {
				
				logger.debug("User not registered");
				message= "notRegistered";
			}
			

		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return message;

	}

	@Override
	public boolean isValidUser(EcommerceDTO dto) throws ServiceException {

		try {
			boolean validUser = dao.isValidUser(dto);
			if (validUser)
				return true;
		} catch (RepositoryException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean resetPassword(EcommerceDTO dto) throws ServiceException {
		logger.debug("Invoked reset password method");
		try {
			long count = dao.fetchEmailCount(dto);
			logger.debug(count);
			if (count == 1) {
				String oTP = dao.updatePassword(dto);
				List<EcommerceDTO>list= dao.fetchRow(dto);
				for (EcommerceDTO eCommerceDTO : list) {
					boolean sent = passwordResetService.sendMail(eCommerceDTO, oTP);
					logger.debug("Email sent " + sent);
				}
				
				

				return true;
			}
		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}
		return false;

	}

	@Override
	public String validateAndUpdatePassword( ResetDTO resetDTO) throws ServiceException {

		logger.debug("invoked validateAndUpdatePassword");
		String message = "NA";
		boolean valid = false;
		try {
			if (!resetDTO.getPassword().isEmpty() && !resetDTO.getNewPassword().isEmpty()
					&& !resetDTO.getCPassword().isEmpty()) {
				valid = true;
			}
			if (valid) {
				if (resetDTO.getNewPassword().equals( resetDTO.getCPassword())) {

					boolean validOtp = dao.isValidOtp(resetDTO);
					logger.debug(validOtp);
					
					if (validOtp) {
						dao.resetPassword( resetDTO);
						logger.debug("otp is valid and password updated");
						return "valid";
					} else {
						logger.debug("Invalid otp");

						return "invalid";
					}

				} else {
					logger.debug("password and confirm password not matching...");
					return "notMatching";
				}
			} else {
				logger.debug("fields can't be blank");
				return message;
			}

		} catch (RepositoryException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
