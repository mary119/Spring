package com.xworkz.springCommon.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.springCommon.dao.EcommerceDAO;
import com.xworkz.springCommon.dao.EcommerceDAOImpl;
import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.exception.RepositoryException;
import com.xworkz.springCommon.exception.ServiceException;

@Service
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private EcommerceDAO dao;

	public ServiceDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}

	@Override
	public boolean validateAndSave(EcommerceDTO dto) {
		boolean valid=false;
		try {
		
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
			if (!StringUtils.isEmpty(lname) && lname.length() >3) {
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
			dao.save(dto);
		} else {
			System.out.println("data is invalid plz check the data");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
}
