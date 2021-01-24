package com.xworkz.springCommon.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class LoginDTO  implements Serializable{
	
	private String email;
	private String password;
 
}
