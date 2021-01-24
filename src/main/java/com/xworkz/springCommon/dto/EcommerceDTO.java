package com.xworkz.springCommon.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="co_tab")
public class EcommerceDTO implements Serializable{
	
	@Id
	@GenericGenerator(name="ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	@Transient
	private String confirmpassword;

	
	

}
