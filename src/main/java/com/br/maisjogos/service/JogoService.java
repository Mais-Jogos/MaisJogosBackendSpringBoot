package com.br.maisjogos.service;

import java.util.List;

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

	public List<Jogo> retornaTodosOsJogosServices() {
		// TODO Auto-generated method stub
		return this.jogoRepository.findAll();
	}

	public Jogo retornaJogoService(Long id) {
		if(this.jogoRepository.existsById(id)) {
			return this.jogoRepository.findById(id).get();			
		}
		return null;
	}

	public Jogo alterarJogo(Long id, @Valid Jogo jogo) {
		
		if(this.jogoRepository.existsById(id)) {
			Jogo jogoAlterado = this.jogoRepository.findById(id).get();
			jogo.setId(id);
			
			if(jogo.getTitulo() == null) {
				jogo.setTitulo(jogoAlterado.getTitulo());				
			}
			
			if(jogo.getDescricao() == null) {
				jogo.setDescricao(jogoAlterado.getDescricao());				
			}
			
			if(jogo.getGenero() == null) {
				jogo.setGenero(jogoAlterado.getGenero());				
			}
			
			if(jogo.getPlataforma() == null) {
				jogo.setPlataforma(jogoAlterado.getPlataforma());				
			}
			
			if(jogo.getSO() == null) {
				jogo.setSO(jogoAlterado.getSO());				
			}
			
			if(jogo.getProcessador() == null) {
				jogo.setProcessador(jogoAlterado.getProcessador());				
			}
			
			if(jogo.getPlacaDeVideo() == null) {
				jogo.setPlacaDeVideo(jogoAlterado.getPlacaDeVideo());				
			}
			
			if(jogo.getQuantMemoria() == null) {
				jogo.setQuantMemoria(jogoAlterado.getQuantMemoria());				
			}
			
			if(jogo.getTipoMemoria() == null) {
				jogo.setTipoMemoria(jogoAlterado.getTipoMemoria());				
			}
			
			if(jogo.getQuantArmazenamento() == null) {
				jogo.setQuantArmazenamento(jogoAlterado.getQuantArmazenamento());				
			}
			
			if(jogo.getTipoArmazenamento() == null) {
				jogo.setTipoArmazenamento(jogoAlterado.getTipoArmazenamento());				
			}
			
			if(jogo.getMidia() == null) {
				jogo.setMidia(jogoAlterado.getMidia());				
			}
			return this.jogoRepository.save(jogo);
		}
		return null;
	}

	public Jogo deletarJogoService(Long id) {
		if(this.jogoRepository.existsById(id)) {
			this.jogoRepository.deleteById(id);
		}
		return null;
	}


	
	
	
	

}
