package com.br.maisjogos.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.maisjogos.enums.UseRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
@SuppressWarnings("serial")
@Entity(name = "devs")
@Getter
@AllArgsConstructor
public class Desenvolvedor implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String dataNasc;
	private String password;
	private String confirmarSenha;
	private String sobre;
	private UseRole role;
		
		
		
	
	
	public Desenvolvedor(String nome, String login, String dataNasc, String password, String confirmarSenha,
				String sobre, UseRole role) {
		
			this.nome = nome;
			this.login = login;
			this.dataNasc = dataNasc;
			this.password = password;
			this.confirmarSenha = confirmarSenha;
			this.sobre = sobre;
			this.role = role;
		}
	
	public Desenvolvedor() {
		
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


	public String getConfirmarSenha() {
		return confirmarSenha;
	}


	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}


	public String getSobre() {
		return sobre;
	}


	public void setSobre(String sobre) {
		this.sobre = sobre;
	}


	public UseRole getRole() {
		return role;
	}


	public void setRole(UseRole role) {
		this.role = role;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UseRole.DESENVOLVEDOR)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else 
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
}
