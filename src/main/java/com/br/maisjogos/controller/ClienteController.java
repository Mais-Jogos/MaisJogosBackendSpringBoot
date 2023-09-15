package com.br.maisjogos.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.dto.AuthenticationDTO;
import com.br.maisjogos.entity.ClienteEntity;
import com.br.maisjogos.repository.ClienteRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class ClienteController{
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid ClienteEntity data) {

        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid ClienteEntity cliente) {
        if(this.repository.findByEmail(cliente.getEmail()) != null)
            return ResponseEntity.badRequest().build();

        String senhaCripto = new BCryptPasswordEncoder().encode(cliente.getSenha());

        ClienteEntity cli = new ClienteEntity(cliente.getNome(), cliente.getSobrenome(),
                cliente.getDataNasc(), cliente.getEmail(), cliente.getConfirmarSenha(),
                senhaCripto, cliente.getRole());

        this.repository.save(cli);
        return ResponseEntity.ok().build();
    }
}