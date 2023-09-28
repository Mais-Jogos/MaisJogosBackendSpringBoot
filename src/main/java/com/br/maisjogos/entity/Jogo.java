package com.br.maisjogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity(name = "jogos")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String genero;
	private String plataforma;
	private String SO;
	private String processador;
	private String placaDeVideo;
	private Integer quantMemoria;
	private String tipoMemoria;
	private Integer quantArmazenamento;
	private String tipoArmazenamento;
	private String midia;
	
	public Jogo(String titulo, String descricao, String genero, String plataforma, String SO, String processador,
			String placaDeVideo, Integer quantMemoria, String tipoMemoria, Integer quantArmazenamento,
			String tipoArmazenamento, String midia) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.genero = genero;
		this.plataforma = plataforma;
		this.SO = SO;
		this.processador = processador;
		this.placaDeVideo = placaDeVideo;
		this.quantMemoria = quantMemoria;
		this.tipoMemoria = tipoMemoria;
		this.quantArmazenamento = quantArmazenamento;
		this.tipoArmazenamento = tipoArmazenamento;
		this.midia = midia;
	}
	
	public Jogo() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String SO) {
		this.SO = SO;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getPlacaDeVideo() {
		return placaDeVideo;
	}
	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
	public Integer getQuantMemoria() {
		return quantMemoria;
	}
	public void setQuantMemoria(Integer quantMemoria) {
		this.quantMemoria = quantMemoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	public Integer getQuantArmazenamento() {
		return quantArmazenamento;
	}
	public void setQuantArmazenamento(Integer quantArmazenamento) {
		this.quantArmazenamento = quantArmazenamento;
	}
	public String getTipoArmazenamento() {
		return tipoArmazenamento;
	}
	public void setTipoArmazenamento(String tipoArmazenamento) {
		this.tipoArmazenamento = tipoArmazenamento;
	}
	public String getMidia() {
		return midia;
	}
	public void setMidia(String midia) {
		this.midia = midia;
	}
	
	
	
}
