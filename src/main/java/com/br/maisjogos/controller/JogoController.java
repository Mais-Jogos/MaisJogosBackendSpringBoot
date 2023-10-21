package com.br.maisjogos.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.entity.Jogo;
import com.br.maisjogos.service.JogoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/jogos")
public class JogoController {
	Logger logger = LogManager.getLogger(this.getClass());
	private JogoService jogoService;
	
	@Autowired
	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Jogo cadastroJogo(@Valid @RequestBody Jogo jogo) {
		return this.jogoService.cadastroJogoService(jogo);
	}
	
	
	@GetMapping("/{id}")
	public Jogo retornaJogo(@PathVariable Long id) {
		return this.jogoService.retornaJogoService(id);
	}
	
	@PutMapping("/{id}")
	public Jogo alterarJogo(@PathVariable Long id, @Valid @RequestBody Jogo jogo) {
		return this.jogoService.alterarJogo(id, jogo);
		
	}
	
	@DeleteMapping("/{id}")
	public Jogo deletarJogo(@PathVariable Long id) {
		return this.jogoService.deletarJogoService(id);
	}
	
}
