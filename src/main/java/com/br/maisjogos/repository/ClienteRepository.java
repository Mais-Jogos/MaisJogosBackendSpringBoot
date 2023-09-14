package com.br.maisjogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.maisjogos.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String>{
	
	UserDetails findByEmail(String email);

}
