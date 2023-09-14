package com.br.maisjogos.entity;

public enum UseRole {
	CLIENTE("cliente"),
	DESENVOLVEDOR("dev");
	
	
	private String role;
	
	UseRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
}
