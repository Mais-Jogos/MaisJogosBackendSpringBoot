package com.br.maisjogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.maisjogos.entity.Desenvolvedor;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long>{
	UserDetails findByLogin(String login);
}
