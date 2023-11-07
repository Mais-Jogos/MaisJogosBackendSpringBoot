package com.br.maisjogos.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.maisjogos.entity.Avatar;
import com.br.maisjogos.entity.Jogo;
import com.br.maisjogos.repository.JogoRepository;

import jakarta.validation.Valid;

@Service
public class JogoService {
	private JogoRepository jogoRepository;


	Logger logger = LogManager.getLogger(this.getClass());
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo cadastroJogoService(@Valid Jogo jogo) {
		return this.jogoRepository.save(jogo);
	}

	public Jogo atualizarJogo(String id, MultipartFile file)  throws IOException {
		 Optional<Jogo> jogoOp = this.jogoRepository.findById(id);

		    if (jogoOp.isPresent()) {
		        Jogo jogo = jogoOp.get();

		        // Obter informações sobre o novo arquivo
		        String nome = file.getOriginalFilename();
		        byte[] conteudo = file.getBytes();

		        // Atualize os campos necessários do Avatar
		        //avatar.setNome(nome);
		        jogo.setJogo(conteudo);

		        // Salve as mudanças no banco de dados
		        jogo = jogoRepository.save(jogo);

		        logger.info(">>>>>> Serviço para atualizar Avatar executado");
		        return jogo;
		    } else {
		        // O Avatar com o ID especificado não foi encontrado
		        return null;
		    }
		
		    
	}
	public List<Jogo> retornaTodosOsJogosServices() {
		return this.jogoRepository.findAll();
	}

}
