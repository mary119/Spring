package com.xworkz.corona.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
@Table(name="covid_table")
public class CovidDTO {

	public CovidDTO() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}
	
	@Id
	@GenericGenerator(name= "ref", strategy="increment")
	@GeneratedValue(generator = "ref")
	private int id;
	private String name;
	private int age;
	private long mno;
	private String email;
	private String result;
	private String state;
	
	
}
