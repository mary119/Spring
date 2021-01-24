package com.xworkz.springCommon.dao;

import java.util.List;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.dto.LoginDTO;
import com.xworkz.springCommon.exception.RepositoryException;

public interface EcommerceDAO {
	
	public long save(EcommerceDTO dto) throws RepositoryException;
	public long fetchEmailCount(EcommerceDTO dto)throws RepositoryException;
	
	public List<EcommerceDTO> fetchRowDtls(LoginDTO edto,EcommerceDTO dto) throws RepositoryException;


}
