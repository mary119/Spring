package com.xworkz.springCommon.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.springCommon.dao.EcommerceDAO;
import com.xworkz.springCommon.dao.EcommerceDAOImpl;
import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.dto.LoginDTO;
import com.xworkz.springCommon.exception.RepositoryException;
import com.xworkz.springCommon.exception.ServiceException;

@Service
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private EcommerceDAO dao;
	private JavaMailSender mailSender;

	public ServiceDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}

	@Override
	public String validateAndSave(EcommerceDTO dto) throws ServiceException {
		String message = "NA";
		boolean valid = false;

		System.out.println("Invoked validate and save method.");
		if (Objects.nonNull(dto)) {
			String fname = dto.getFirstname();
			if (!StringUtils.isEmpty(fname) && fname.length() > 3) {
				System.out.println("fname is valid");
				valid = true;
			} else {
				System.out.println("fname is not valid");
				valid = false;
			}
		}

		if (valid) {
			String lname = dto.getLastname();
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
			String cpwd = dto.getConfirmpassword();
			if (password.equals(cpwd)) {
				System.out.println("Password is valid");
				valid = true;

			} else {
				System.out.println("Password is invalid");
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
				throw new ServiceException(e.getMessage());

			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
		} else {
			System.out.println("Inputs are invalid and notsaving");
		}

		return message;
	}

	public List<EcommerceDTO> validateAndLogin(LoginDTO edto,EcommerceDTO dto) throws ServiceException {
		List<EcommerceDTO> list = null;
		System.out.println("invoking validate and login method");
		try {
			list = dao.fetchRowDtls(edto,dto);
			for (EcommerceDTO object : list) {
				System.out.println(object);

			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;

	}

}
