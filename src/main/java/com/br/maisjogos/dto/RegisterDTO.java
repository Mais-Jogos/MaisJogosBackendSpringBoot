package com.br.maisjogos.dto;

import com.br.maisjogos.enums.UseRole;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public UseRole getRole() {
		return role;
	}

	public void setRole(UseRole role) {
		this.role = role;
	}
	
	
	
}
