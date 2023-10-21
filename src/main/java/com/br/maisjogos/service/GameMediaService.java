package com.br.maisjogos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.br.maisjogos.entity.GameMedia;
import com.br.maisjogos.repository.GameMediaRepository;



@Service
public class GameMediaService {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	 private  GameMediaRepository gameMediaRepository;
	private Environment environment = null;
	 
	 public	GameMediaService(GameMediaRepository gameMediaRepository, Environment environment, JogoService jogoS) {
	 this.gameMediaRepository = gameMediaRepository;
	 this.environment = environment;
	 } 
	 
	 public GameMedia salvar(MultipartFile arquivo) throws IOException {
		// **********************************************************
			// Obter informações sobre o arquivo
			// **********************************************************
			String nome = arquivo.getOriginalFilename();
			String tipo = arquivo.getContentType();
			long tamanho = arquivo.getSize();
			byte[] conteudo = arquivo.getBytes(); // Obtem o conteúdo do arquivo
			// *********************************************************
			// Processar o arquivo
			// *********************************************************
			// String nomeArquivo = UUID.randomUUID().toString() + "_" + arquivo.getOriginalFilename();
			// String caminhoArquivo = environment.getProperty("imagem.upload-dir") + "/" + nomeArquivo;
			// Path caminhoCompleto = Paths.get(caminhoArquivo).toAbsolutePath().normalize();
			Path caminhoArquivo = Paths.get("jogos/" + nome);
			GameMedia imagem = new GameMedia();
			imagem.setNome(arquivo.getOriginalFilename());
			imagem.setCaminho(caminhoArquivo.toString());
			imagem.setArquivo(arquivo.getBytes());
			logger.info(">>>>>> servico mantem imagem salvar - no disco e no db executado");
			//***********************************************************
			// salva no disco e no db
			//***********************************************************
			Files.write(caminhoArquivo, arquivo.getBytes());
			return gameMediaRepository.save(imagem); 
		 }

	public List<GameMedia> retornaTodosOsJogosServices() {
		
		return this.gameMediaRepository.findAll();
	}

	public GameMedia retornaJogoService(Long id) {
			if(this.gameMediaRepository.existsById(id)) {
				return this.gameMediaRepository.findById(id).get();			
			}
			return null;
	}
	 
}
