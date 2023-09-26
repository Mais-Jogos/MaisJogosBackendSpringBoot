package com.br.maisjogos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.maisjogos.entity.Cliente;
import com.br.maisjogos.repository.ClienteRepository;

@Service
public class ClienteService implements UserDetailsService{
	
	@Autowired
	ClienteRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByLogin(username);
	}

	public Optional<Cliente> getById(String id) {
		
		return repository.findById(id);
	}

}
