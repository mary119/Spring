package com.xworkz.springCommon.mailservice;

import com.xworkz.springCommon.dto.EcommerceDTO;
import com.xworkz.springCommon.exception.ServiceException;

public interface SpringMailService {
	
	public boolean sendMail(EcommerceDTO commercedto) throws ServiceException ;

}
