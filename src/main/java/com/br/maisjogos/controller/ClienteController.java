package com.br.maisjogos.controller;


import java.util.Optional;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.br.maisjogos.config.security.TokenService;
import com.br.maisjogos.dto.AuthenticationDTO;
import com.br.maisjogos.dto.ClienteDTO;
import com.br.maisjogos.dto.RegisterDTO;
import com.br.maisjogos.entity.Cliente;
import com.br.maisjogos.repository.ClienteRepository;
import com.br.maisjogos.service.ClienteService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("auth")
public class ClienteController{
    @Autowired
    private ClienteRepository repository;
    ClienteService service;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired 
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
    	var usenamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
    	
    	var auth = this.authenticationManager.authenticate(usenamePassword);
        
    	var token = tokenService.generateToken((Cliente) auth.getPrincipal());
 
    	return ResponseEntity.ok(new ClienteDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
          
        String senhaCripto = new BCryptPasswordEncoder().encode(data.getPassword());

        Cliente cli = new Cliente(data.getNome(), data.getSobrenome(), data.getLogin(),
        		data.getDataNasc(), senhaCripto, data.getConfirmarSenha(), data.getRole());

        this.repository.save(cli);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable String id) {

        Optional<Cliente> user = service.getById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return null;
        }
    }
    @GetMapping
    public ResponseEntity<List<AuthenticationDTO>> findAll(){
    	this.repository.findAll();
    	return ResponseEntity.ok().build();
    }
    
    
    
    
    
    
    
}