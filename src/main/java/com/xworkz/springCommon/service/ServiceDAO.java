package com.xworkz.springCommon.service;

import java.util.List;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.dto.LoginDTO;
import com.xworkz.springCommon.exception.ServiceException;

public interface ServiceDAO {

	public String validateAndSave(EcommerceDTO dto)throws ServiceException;
	//public boolean sendMail(EcommerceDTO dto );

	public List<EcommerceDTO> validateAndLogin(LoginDTO edto,EcommerceDTO dto) throws ServiceException ;

}
