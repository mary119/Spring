package com.xworkz.modules.mailservice;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.exception.ServiceException;

public interface SpringMailService {
	
	public boolean sendMail(EcommerceDTO commercedto) throws ServiceException ;

}
