package com.br.maisjogos.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Favorito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Jogo jogo;
	private Cliente cliente;
	
	public Favorito(Jogo jogo, Cliente cliente) {
		this.cliente = cliente;
		this.jogo = jogo;
		
	}
	public Favorito() {	
	}
	
	public void setJogo (Jogo jogo) {
		this.jogo = jogo;
	}
	public Jogo getJogo() {
		return jogo;
	}
	public void setCliente (Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
