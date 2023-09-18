package com.br.maisjogos.dto;

import com.br.maisjogos.entity.UseRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDTO {
	private String nome;
	private String sobrenome;
	private String login;
	private String dataNasc;
	private String password;
	private String confirmarSenha;
	private UseRole role;
	
	public RegisterDTO(String nome, String sobrenome, String login, String dataNasc, String password,
			String confirmarSenha, UseRole role) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.dataNasc = dataNasc;
		this.password = password;
		this.confirmarSenha = confirmarSenha;
		this.role = role;
	}
	
	
	
}
