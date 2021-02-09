package com.xworkz.modules.service;

import java.util.List;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.dto.LoginDTO;
import com.xworkz.modules.dto.ResetDTO;
import com.xworkz.modules.exception.RepositoryException;
import com.xworkz.modules.exception.ServiceException;

public interface ServiceDAO {

	String validateAndSave(EcommerceDTO commerceDTO) throws ServiceException;

	String validateAndLogin(EcommerceDTO dto, LoginDTO ldto) throws ServiceException;

	boolean isValidUser(EcommerceDTO dto) throws ServiceException;

	boolean resetPassword(EcommerceDTO dto) throws ServiceException;

	String validateAndUpdatePassword(ResetDTO resetDTO) throws ServiceException;

	List<EcommerceDTO> loginDetails(EcommerceDTO dto) throws RepositoryException;

}
