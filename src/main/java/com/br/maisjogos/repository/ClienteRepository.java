package com.br.maisjogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.maisjogos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	UserDetails findByLogin(String login);

}
