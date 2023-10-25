package com.br.maisjogos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.maisjogos.entity.Desenvolvedor;
import com.br.maisjogos.repository.DesenvolvedorRepository;

import jakarta.validation.Valid;

@Service
public class DesenvolvedorService {
	
	private final DesenvolvedorRepository desenvolvedorRepository;
	
	public DesenvolvedorService(DesenvolvedorRepository desenvolvedorRepository) {
		this.desenvolvedorRepository = desenvolvedorRepository;
	}
	
	public Desenvolvedor cadastroDesenvolvedorService(@Valid Desenvolvedor desenvolvedor) {
		return this.desenvolvedorRepository.save(desenvolvedor);
	}

	public List<Desenvolvedor> retornaTodosOsDesenvolvedoresService() {
		// TODO Auto-generated method stub
		return this.desenvolvedorRepository.findAll();
	}

	public Desenvolvedor retornaDesenvolvedorService(Long id) {
		if(this.desenvolvedorRepository.existsById(id)) {
			return this.desenvolvedorRepository.findById(id).get();			
		}
		return null;
	}

	public Desenvolvedor alterarDesenvolvedor(Long id, @Valid Desenvolvedor desenvolvedor) {
		
		if(this.desenvolvedorRepository.existsById(id)) {
			Desenvolvedor desenvolvedorAlterado = this.desenvolvedorRepository.findById(id).get();
			desenvolvedor.setId(id);
			if(desenvolvedor.getNome() == null) {
				desenvolvedor.setNome(desenvolvedorAlterado.getNome());				
			}
			
			if(desenvolvedor.getEmail() == null) {
				desenvolvedor.setEmail(desenvolvedorAlterado.getEmail());				
			}
			if(desenvolvedor.getDescricao() == null) {
				desenvolvedor.setDescricao(desenvolvedorAlterado.getDescricao());				
			}
			
			return this.desenvolvedorRepository.save(desenvolvedor);
		}
		return null;
	}

	public Desenvolvedor deletarDesenvolvedorService(Long id) {
		if(this.desenvolvedorRepository.existsById(id)) {
			this.desenvolvedorRepository.deleteById(id);
		}
		return null;
	}
}
