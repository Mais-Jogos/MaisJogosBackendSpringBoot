package com.br.maisjogos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticationDTO {
	String login;
	String password;
	
	
	public AuthenticationDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	
	
	
}
