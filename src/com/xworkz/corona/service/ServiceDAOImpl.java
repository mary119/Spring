package com.xworkz.corona.service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sun.corba.se.impl.util.Utility;
import com.xworkz.corona.dao.CoronaDAO;
import com.xworkz.corona.dto.CovidDTO;

@Service
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private CoronaDAO coronaDAO;

	public ServiceDAOImpl() {
		System.out.println("created" + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(CovidDTO dto) {
		System.out.println("invoked validateAndSave in CoronaService");
		boolean valid = false;
		if (Objects.nonNull(dto)) {
			String name = dto.getName();
			if (!StringUtils.isEmpty(name) && name.length() >= 3 && name.length() <= 10) {
				System.out.println("name is valid");
				valid = true;
			} else {
				System.out.println("name is not valid");
				valid = false;
			}

			int age = dto.getAge();
			if (valid) {
				if (age >= 0) {
					System.out.println("Age is valid");
					valid = true;
				} else {
					System.out.println("Age is not valid");
					valid = false;
				}
			}
			if (valid) {
				String email = dto.getEmail();
				if (!StringUtils.isEmpty(email)) {
					String regex = "^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
							+ "A-Z]{2,7}$";

					boolean result = email.matches(regex);
					if (result == true) {
						System.out.println("Email is valid");

						valid = true;
					} else {
						System.out.println("Email is invalid");
						valid = false;

					}

				}
			}
			if (valid) {
				long mno = dto.getMno();
				if (mno >= 10) {
					System.out.println("mobile number is valid");
					valid = true;

				} else {
					System.out.println("mobile number  is invalid");
					valid = false;

				}

			}
			if (valid) {
				String states = dto.getState();
				if (!StringUtils.isEmpty(states)) {
					System.out.println("State is valid");
					valid = true;
				} else {
					System.out.println("State is invalid");
					valid = false;
				}
			}
			if (valid) {
				long p=coronaDAO.save(dto);
				System.out.println("data is valid, u can save data");
			} else {
				System.out.println("not valid data, so cannot save the data");
			}

		}

		return valid;
	}
}
