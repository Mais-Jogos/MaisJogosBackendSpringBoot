package com.br.maisjogos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.config.security.TokenServiceCliente;
import com.br.maisjogos.dto.AuthenticationDTO;
import com.br.maisjogos.dto.ClienteDTO;
import com.br.maisjogos.dto.RegisterClienteDTO;
import com.br.maisjogos.entity.Avatar;
import com.br.maisjogos.entity.Cliente;
import com.br.maisjogos.entity.Review;
import com.br.maisjogos.repository.ClienteRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("auth")
public class ClienteController{
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired 
    private TokenServiceCliente tokenServiceCliente;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
    	var usenamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
    	
    	var auth = this.authenticationManager.authenticate(usenamePassword);
        
    	var token = tokenServiceCliente.generateToken((Cliente) auth.getPrincipal());
 
    	return ResponseEntity.ok(new ClienteDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody @Valid RegisterClienteDTO data) {
        if(this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
          
        String senhaCripto = new BCryptPasswordEncoder().encode(data.getPassword());

        Cliente cli = new Cliente(data.getNome(), data.getSobrenome(), data.getLogin(), data.getDataNasc(), senhaCripto, data.getConfirmarSenha(), data.getRole(), data.getMoeda());

        this.repository.save(cli);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/cliente")
    public List<Cliente> retornaTodosClientes() {
		return this.repository.findAll();
	}
    
    
    @GetMapping("/{id}")
    public Cliente retornaClientes(@PathVariable Long id) {
    	if(this.repository.existsById(id)){
    		return this.repository.findById(id).get();
    	}
    	return null;
    
	}
	
	
}