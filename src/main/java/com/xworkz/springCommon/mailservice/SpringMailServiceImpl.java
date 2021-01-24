package com.xworkz.springCommon.mailservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.springCommon.dto.EcommerceDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SpringMailServiceImpl implements SpringMailService {

	@Autowired
	private JavaMailSender mailSender;
	Logger logger =Logger.getLogger(SpringMailServiceImpl.class);
	
	@Override
	public boolean sendMail(EcommerceDTO commercedto) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(commercedto.getEmail());
		mailMessage.setSubject("registering common module");
		mailMessage.setText("Hi " + commercedto.getFirstname() + "\n" + "\n"
				+ " your registraion is successful please login with username and password" + "\n" + "\n" + "\n"
				+ "Thanks," + "\n" + "X-workz");

		try {
			mailSender.send(mailMessage);
			return true;
		} catch (MailException e) {
			System.out.println("mail not sent");
			logger.debug("Mail not sent");

		}

		return false;

	}
}
