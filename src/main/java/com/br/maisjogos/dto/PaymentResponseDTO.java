package com.br.maisjogos.dto;

import jakarta.persistence.Entity;


public class PaymentResponseDTO {
    private Long id;
    private String status;
    private String detail;
    private String idCliente;
    public PaymentResponseDTO(Long id, String status, String detail, String idCliente) {
        this.id = id;
        this.status = status;
        this.detail = detail;
        this.idCliente = idCliente;
    }
    public PaymentResponseDTO(Long id, String status, String detail) {
        this.id = id;
        this.status = status;
        this.detail = detail;
      
    }
    public PaymentResponseDTO() {
    	
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
