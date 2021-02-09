package com.xworkz.modules.mailservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.modules.dto.EcommerceDTO;
import com.xworkz.modules.exception.ServiceException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SpringMailServiceImpl implements SpringMailService {
	static Logger logger=Logger.getLogger(SpringMailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(EcommerceDTO commerceDTO) throws ServiceException {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(commerceDTO.getEmail());
		mailMessage.setSubject("Xworkz common module registration");
		mailMessage.setText("Hi " + commerceDTO.getFirstName() + "\n" + "\n"
				+ " your registraion is successful please login with username and password" + "\n" + "\n" + "\n"
				+ "Thanks," + "\n" + "X-workz");

		try {
			mailSender.send(mailMessage);
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage());

			// throw new ServiceException(e.getMessage());

		}

		return false;

	}

}
