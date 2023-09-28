package com.br.maisjogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity //Anotação de entidade
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double notaReview;

    private String dataReview;

    private String descricaoReview;
    
    
    //Construtor geral
	public Review(double notaReview, String dataReview, String descricaoReview){
		this.notaReview = notaReview;
		this.dataReview = dataReview;
		this.descricaoReview = descricaoReview;
	} 
	
	//Construtor vazio
	public Review() {
	}


	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNotaReview() {
		return notaReview;
	}

	public void setNotaReview(double notaReview) {
		this.notaReview = notaReview;
	}

	public String getDataReview() {
		return dataReview;
	}

	public void setDataReview(String dataReview) {
		this.dataReview = dataReview;
	}

	public String getDescricaoReview() {
		return descricaoReview;
	}

	public void setDescricaoReview(String descricaoReview) {
		this.descricaoReview = descricaoReview;
	}

}
