package com.xworkz.springhibernate.service;

import com.xworkz.springhibernate.dao.VaccineDAO;
import com.xworkz.springhibernate.dto.VaccineDTO;

public class ServiceDAO {

	private VaccineDAO dao;

	public ServiceDAO(VaccineDAO dao) {
		System.out.println("created" + this.getClass().getSimpleName());
		this.dao = dao;
	}

	public String validateAndSave(VaccineDTO dto) {
		System.out.println("invoked validate and save" + dto);

		String message = "NA";
		boolean valid = false;
		if (dto != null) {
			System.out.println("dto is an object");
			String name = dto.getVaccineName();
			String country = dto.getCountryName();
			int id = dto.getVaccineId();

			if (name != null && !name.isEmpty()) {
				System.out.println("name is valid");
				valid = true;
			} else {
				System.out.println("name is not valid");
				valid = false;
			}

			if (valid) {
				if (country != null && !country.isEmpty()) {
					System.out.println("country is valid");
					valid = true;
				} else {
					System.out.println("country is not valid");
					valid = false;
				}
			}

			if (valid) {
				if (id > 0) {
					System.out.println("id is valid");
					valid = true;
				} else {
					System.out.println("id is not valid");
					valid = false;
				}
			}

			if (valid) {
				if (valid) {
					System.out.println("save the dto");
					dao.save(dto);
					message = "success";
				} else {
					System.out.println("saving is failed");
					message = "failed";
				}
			}
		}
		return message;
	}
}
