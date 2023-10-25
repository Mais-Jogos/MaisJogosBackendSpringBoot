package com.br.maisjogos.controller;

import java.util.List;

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
import com.br.maisjogos.entity.Desenvolvedor;
import com.br.maisjogos.service.DesenvolvedorService;

import jakarta.validation.Valid;

	
@RestController
@RequestMapping("/desenvolvedor")
	public class DesenvolvedorController {
	private DesenvolvedorService desenvolvedorService;
	
	@Autowired
	public DesenvolvedorController(DesenvolvedorService desenvolvedorService) {
		this.desenvolvedorService = desenvolvedorService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Desenvolvedor cadastrodesenvolvedor(@Valid @RequestBody Desenvolvedor desenvolvedor) {
		return this.desenvolvedorService.cadastroDesenvolvedorService(desenvolvedor);
	}
	
	@GetMapping
	public List<Desenvolvedor> retornaTodosOsDesenvolvedores(){
		return this.desenvolvedorService.retornaTodosOsDesenvolvedoresService();
	}
	
	@GetMapping("/{id}")
	public Desenvolvedor retornaDesenvolvedor(@PathVariable Long id) {
		return this.desenvolvedorService.retornaDesenvolvedorService(id);
	}
	
	@PutMapping("/{id}")
	public Desenvolvedor alterarDesenvolvedor(@PathVariable Long id, @Valid @RequestBody Desenvolvedor desenvolvedor) {
		return this.desenvolvedorService.alterarDesenvolvedor(id, desenvolvedor);
		
	}
	
	@DeleteMapping("/{id}")
	public Desenvolvedor deletarDesenvolvedor(@PathVariable Long id) {
		return this.desenvolvedorService.deletarDesenvolvedorService(id);
	}
	
}
