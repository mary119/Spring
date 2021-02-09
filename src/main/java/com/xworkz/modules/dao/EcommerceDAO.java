package com.xworkz.modules.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.dto.LoginDTO;
import com.xworkz.modules.dto.ResetDTO;
import com.xworkz.modules.exception.RepositoryException;

public interface EcommerceDAO {

	public int save(EcommerceDTO dto) throws RepositoryException;

	public long fetchEmailCount(EcommerceDTO dto) throws RepositoryException;

	public List<EcommerceDTO> fetchRow(EcommerceDTO dto) throws RepositoryException;

	public String fetchPassword(EcommerceDTO dto) throws RepositoryException;

	public boolean isValidUser(EcommerceDTO dto) throws RepositoryException;

	List<EcommerceDTO> fetchTable(EcommerceDTO dto) throws RepositoryException;

	String updatePassword(EcommerceDTO commerceDTO) throws RepositoryException;

	boolean isValidOtp(ResetDTO dto) throws RepositoryException;

	boolean resetPassword(ResetDTO resetDTO) throws RepositoryException;
	
	public Integer updateLoginFailCount(LoginDTO loginDTO) throws RepositoryException;

	public boolean updateAccountLocked(LoginDTO loginDTO)throws RepositoryException;

	public void updateLoginFailCountToZero(String email) throws RepositoryException;

	public void updateAccountLockedToFalse(String email) throws RepositoryException;

	void accountUnlocking(String email) throws RepositoryException;

}
