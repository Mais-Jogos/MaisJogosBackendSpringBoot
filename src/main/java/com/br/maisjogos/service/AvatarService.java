package com.br.maisjogos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.maisjogos.entity.Avatar;
import com.br.maisjogos.repository.AvatarRepository;

import jakarta.validation.Valid;


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
	 
	 public Avatar atualizarAvatar(Long id, MultipartFile arquivo) throws IOException {
		    Optional<Avatar> avatarOptional = this.avatarRepository.findById(id);

		    if (avatarOptional.isPresent()) {
		        Avatar avatar = avatarOptional.get();

		        // Obter informações sobre o novo arquivo
		        String nome = arquivo.getOriginalFilename();
		        byte[] conteudo = arquivo.getBytes();

		        // Atualize os campos necessários do Avatar
		        //avatar.setNome(nome);
		        avatar.setArquivo(conteudo);

		        // Salve as mudanças no banco de dados
		        avatar = avatarRepository.save(avatar);

		        logger.info(">>>>>> Serviço para atualizar Avatar executado");
		        return avatar;
		    } else {
		        // O Avatar com o ID especificado não foi encontrado
		        return null;
		    }
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

	public Avatar cadastrarAvatar(@Valid Avatar avatar) {
		// TODO Auto-generated method stub
		return this.avatarRepository.save(avatar);
	}
}