package com.br.maisjogos.service;

import org.springframework.stereotype.Service;

import com.br.maisjogos.entity.Jogo;
import com.br.maisjogos.repository.JogoRepository;

import jakarta.validation.Valid;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;
	
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo cadastroJogoService(@Valid Jogo jogo) {
		return this.jogoRepository.save(jogo);
	}

}
