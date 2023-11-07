package com.br.maisjogos.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.maisjogos.entity.Avatar;
import com.br.maisjogos.entity.Jogo;
import com.br.maisjogos.service.AvatarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/release-avatares")
public class AvatarController {
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	AvatarService avatarService;
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Avatar cadastroAvatar(@Valid @RequestBody Avatar avatar) {
		return this.avatarService.cadastrarAvatar(avatar);
	}
	
	@CrossOrigin
	@PatchMapping("/{id}")
	public ResponseEntity<String> handleFileUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
	    logger.info(">>>>>> api manipula file upload chamado");
	    if (file != null && !file.isEmpty()) {
	        logger.info(">>>>>> api manipula file upload file nao esta vazio");
	        try {
	            logger.info(">>>>>> api manipula file upload chamou servico salvar");
	            
	            avatarService.atualizarAvatar(id, file);
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
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Arquivo vazio");
	    }
	}
	
	@GetMapping
	public List<Avatar> retornaTodosOsAvatares(){
		return this.avatarService.retornaTodosOsAvataresServices();
	}
	
	@GetMapping("/{id}")
	public Avatar retornaAvatar(@PathVariable Long id) {
		return this.avatarService.retornaAvatarService(id);
	}
}