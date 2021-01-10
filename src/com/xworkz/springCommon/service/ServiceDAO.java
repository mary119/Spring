package com.xworkz.springCommon.service;

import com.xworkz.springCommon.dto.EcommerceDTO;

public interface ServiceDAO {

	public boolean validateAndSave(EcommerceDTO dto);
}
