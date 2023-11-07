package com.br.maisjogos.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.br.maisjogos.enums.UseRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDevDTO {
	private String nome;
	private String login;
	private String dataNasc;
	private String password;
	private String confirmarSenha;
	private UseRole role;
	private String sobre;
	
	public RegisterDevDTO(String nome, String login, String dataNasc, String password, String confirmarSenha,
			UseRole role, String sobre) {
		super();
		this.nome = nome;
		this.login = login;
		this.dataNasc = dataNasc;
		this.password = password;
		this.confirmarSenha = confirmarSenha;
		this.role = role;
		this.sobre = sobre;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	
}
