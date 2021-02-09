package com.xworkz.modules.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Data;

@Data
public class ResetDTO implements Serializable{
	
	static Logger logger = Logger.getLogger(ResetDTO.class);

	private String password;
	private String newPassword;
	private String cPassword;

	public ResetDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}

}
