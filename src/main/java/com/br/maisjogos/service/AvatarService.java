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

import com.br.maisjogos.entity.Avatar;
import com.br.maisjogos.repository.AvatarRepository;


@Service
public class AvatarService {
	Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	 private  AvatarRepository avatarRepository;
	private Environment environment = null;
	 
	 public	AvatarService(AvatarRepository avatarRepository, Environment environment) {
		 this.avatarRepository = avatarRepository;
		 this.environment = environment;
	 } 
	 
	 public Avatar salvar(MultipartFile arquivo) throws IOException {
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
		Path caminhoArquivo = Paths.get("avatares/" + nome);
		Avatar imagem = new Avatar();
		imagem.setNome(arquivo.getOriginalFilename());
		imagem.setCaminho(caminhoArquivo.toString());
		imagem.setArquivo(arquivo.getBytes());
		logger.info(">>>>>> servico mantem imagem salvar - no disco e no db executado");
		//***********************************************************
		// salva no disco e no db
		//***********************************************************
		Files.write(caminhoArquivo, arquivo.getBytes());
		return avatarRepository.save(imagem); 
	 }

	public List<Avatar> retornaTodosOsAvataresServices() {
		return this.avatarRepository.findAll();
	}

	public Avatar retornaAvatarService(Long id) {
		if (this.avatarRepository.existsById(id)) {
			return this.avatarRepository.findById(id).get();			
		}
		return null;
	}
}
