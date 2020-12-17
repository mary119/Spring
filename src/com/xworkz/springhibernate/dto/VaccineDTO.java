package com.xworkz.springhibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
//@Setter
//@Getter
@Entity
@Table(name="corona_vaccine")
public class VaccineDTO implements Serializable {
	
	@Id
	//@GenericGenerator(name="ref" , strategy="increment")
	//@GeneratedValue(generator = "ref")
	@Column(name="v_id")
	private int vaccineId;
	@Column(name="v_name")
	private String vaccineName;
	@Column(name="v_country")
	private String countryName;
	@Column(name="v_readyTo_use")
	private boolean isReadyToUse;
	
	

}
