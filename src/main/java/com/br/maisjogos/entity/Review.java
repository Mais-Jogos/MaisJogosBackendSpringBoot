package com.br.maisjogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "review")
public class Review {
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message = "O campo id é obrigatótio")
    private String id;

    private Jogo jogoReview;

    private Cliente clienteReview;

    @NotNull(message = "A nota da Review é obrigatória")
    private double notaReview;

    private String dataReview;

    @NotBlank(message="A descrição da Review é obrigatória")
    private String descricaoReview;

    public Review(Jogo jogoReview, double notaReview, String dataReview, String descricaoReview) {
        this.jogoReview = jogoReview;
        this.notaReview = notaReview;
        this.dataReview = dataReview;
        this.descricaoReview = descricaoReview;
    }

    public Review() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setJogoReview(Jogo jogoReview) {
        this.jogoReview = jogoReview;
    }

    public Jogo getJogoReview() {
        return jogoReview;
    }

    public void setClienteReview(Cliente clienteReview) {
        this.clienteReview = clienteReview;
    }

    public Cliente getClienteReview() {
        return clienteReview;
    }

    public void setNotaReview(Double notaReview) {
        this.notaReview = notaReview;
    }

    public Double getNotaReview() {
        return notaReview;
    }

    public void setDataReview(String dataReview) {
        this.dataReview = dataReview;
    }

    public String getDataReview() {
        return dataReview;
    }

    public void setDescricaoReview(String descricaoReview) {
        this.descricaoReview = descricaoReview;
    }
    public String getDescricaoReview() {
        return descricaoReview;
    }

}
