package com.br.maisjogos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.config.security.TokenService;
import com.br.maisjogos.dto.AuthenticationDTO;
import com.br.maisjogos.dto.ClienteDTO;
import com.br.maisjogos.dto.RegisterDTO;
import com.br.maisjogos.entity.ClienteEntity;
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
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
    	var usenamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
    	
    	var auth = this.authenticationManager.authenticate(usenamePassword);
        
    	var token = tokenService.generateToken((ClienteEntity) auth.getPrincipal());
 
    	return ResponseEntity.ok(new ClienteDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
          
        String senhaCripto = new BCryptPasswordEncoder().encode(data.getPassword());

        ClienteEntity cli = new ClienteEntity(data.getNome(), data.getSobrenome(), data.getLogin(),
        		data.getDataNasc(), senhaCripto, data.getConfirmarSenha(), data.getRole());

        this.repository.save(cli);
        return ResponseEntity.ok().build();
    }
}