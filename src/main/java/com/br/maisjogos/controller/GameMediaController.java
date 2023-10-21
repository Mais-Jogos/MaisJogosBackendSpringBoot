package com.br.maisjogos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.maisjogos.entity.GameMedia;
import com.br.maisjogos.service.GameMediaService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

@RestController
@RequestMapping("/release-jogos")
public class GameMediaController {
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	GameMediaService gameMediaSerivice;

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> handleFileUpload(MultipartFile file) {
		logger.info(">>>>>> api manipula file upload chamado");
		if (!file.isEmpty()) {
			logger.info(">>>>>> api manipula file upload file nao esta vazio");
			try {
				logger.info(">>>>>> api manipula file upload chamou servico salvar");
				
				gameMediaSerivice.salvar(file);
				return ResponseEntity.ok().body("Imagem enviada com sucesso");
			} catch (FileNotFoundException e) {
				logger.info(">>>>>> api manipula file upload arquivo não encontrado");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Arquivo nao encontrado");
			} catch (FileUploadException e) {
				logger.info(">>>>>> api manipula file upload erro no upload");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha ao enviar o arquivo");
			} catch (IOException e) {
				logger.info(">>>>>> api manipula file upload erro de i/o => " + e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Falha erro de I/O");
			}
		} else {
			logger.info(">>>>>> api manipula file arquivo vazio ");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Arquivo vazio");
		}
	}
	@GetMapping
	public List<GameMedia> retornaTodosOsGameJogos(){
		return this.gameMediaSerivice.retornaTodosOsJogosServices();
	}
	@GetMapping("/{id}")
	public GameMedia retornaGameJogos(@PathVariable Long id) {
		return this.gameMediaSerivice.retornaJogoService(id);
	}
}
