package com.xworkz.spring.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="election_table")
public class ElectionResultsDTO implements Serializable{

	
	@Id
	//@GenericGenerator(name="ref", strategy="increment")
	//@GeneratedValue(generator = "ref")
	private int eId;
	private String partyName;
	private String candidateName;
	private int wardNo;
	private int wonBy;
	
	
	public  ElectionResultsDTO() {
		System.out.println("created" + this.getClass().getSimpleName());
	}
	
}
