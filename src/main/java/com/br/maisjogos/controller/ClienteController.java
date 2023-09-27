package com.br.maisjogos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;


@RestController
@RequestMapping("auth")
public class ClienteController{
    @Autowired
    private ClienteRepository repository;
    
   
}