package com.br.maisjogos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercadopago.net.HttpStatus;

@Controller
@RequestMapping("/")
public class TemplateController {
	@Value("${mercado_pago_sample_public_key}")
    private String mercadoPagoSamplePublicKey;

	 @GetMapping("/public-key")
	    public ResponseEntity<String> getMercadoPagoPublicKey() {
	        try {
	            // Retorna a chave pública do Mercado Pago
	            return ResponseEntity.ok(mercadoPagoSamplePublicKey);
	        } catch (Exception e) {
	            // Manipula exceções e retorna um erro interno do servidor (500)
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
	        }
	    }
}
