package com.xworkz.modules.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "ecommerce_table")
public class EcommerceDTO implements Serializable {

	static Logger logger = Logger.getLogger(EcommerceDTO.class);

	@Id
	@GenericGenerator(name="ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@Transient
	private String confirmPassword;

	public EcommerceDTO() {
		logger.info("Created " + this.getClass().getSimpleName());
	}
}
