package com.br.maisjogos.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClienteEntity implements UserDetails{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String nome;
	private String sobrenome;
	private String login;
	private String dataNasc;
	private String password;
	private String confirmarSenha;
	private UseRole role;
	
	
	public ClienteEntity(String nome, String sobrenome, String login, String dataNasc, String password,
			String confirmarSenha, UseRole role) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.dataNasc = dataNasc;
		this.password = password;
		this.confirmarSenha = confirmarSenha;
		this.role = role;
	}
	public ClienteEntity() {
	
	
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UseRole.CLIENTE)
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
	

}
