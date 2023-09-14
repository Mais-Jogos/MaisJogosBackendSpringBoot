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

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClienteEntity implements UserDetails{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String nome;
	private String sobrenome;
	private String email;
	private String dataNasc;
	private String senha;
	private String confirmarSenha;
	private UseRole role;
	
	
	
	
	
	
	public ClienteEntity(String id, String nome, String sobrenome, String email, String dataNasc, String senha,
			String confirmarSenha, UseRole role) {
	
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNasc = dataNasc;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
		this.role = role;
	}
	public ClienteEntity(String nome, String sobrenome, String email, String dataNasc, String senha,
			String confirmarSenha, UseRole role) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNasc = dataNasc;
		this.senha = senha;
		this.confirmarSenha = confirmarSenha;
		this.role = role;
	}
	public ClienteEntity() {
	
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == role.CLIENTE)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else 
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
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
