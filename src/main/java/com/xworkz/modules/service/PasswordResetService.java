package com.xworkz.modules.service;

import org.springframework.stereotype.Service;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.exception.ServiceException;


public interface PasswordResetService {
	
	public boolean sendMail(EcommerceDTO commerceDTO, String otp) throws ServiceException;


}
