package com.br.maisjogos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.br.maisjogos.config.security.TokenServiceCliente;
import com.br.maisjogos.config.security.TokenServiceDev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.dto.AuthenticationDTO;
import com.br.maisjogos.dto.ClienteDTO;
import com.br.maisjogos.dto.DesenvolvedorDTO;
import com.br.maisjogos.dto.RegisterClienteDTO;
import com.br.maisjogos.dto.RegisterDevDTO;
import com.br.maisjogos.entity.Cliente;
import com.br.maisjogos.entity.Desenvolvedor;
import com.br.maisjogos.repository.DesenvolvedorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class DesenvolvedorController {
	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenServiceDev tokeServiceDev;
	
	@PostMapping("/login/dev")
	public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
		var usenamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usenamePassword);
		var token = tokeServiceDev.generateToken((Desenvolvedor) auth.getPrincipal());
		
		return ResponseEntity.ok(new DesenvolvedorDTO(token));
	}
	@PostMapping("/cadastro/dev")
	public ResponseEntity<?> cadastro(@RequestBody @Valid RegisterDevDTO data) {
        if(this.desenvolvedorRepository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();
        String senhaCripto = new BCryptPasswordEncoder().encode(data.getPassword());
        
        Desenvolvedor dev = new Desenvolvedor(data.getNome(), data.getLogin(), 
        		data.getDataNasc(), senhaCripto, data.getConfirmarSenha(),
        		data.getSobre(), data.getRole());
        this.desenvolvedorRepository.save(dev);
        return ResponseEntity.ok().build();
	}
	  
    @GetMapping("/desenvolvedor")
    public List<Desenvolvedor> retornaTodosClientes() {
		return this.desenvolvedorRepository.findAll();
	}
    
    @GetMapping("/dev/{id}")
    public Optional<Desenvolvedor> retornaClientes(@PathVariable Long id) {
    	if(this.desenvolvedorRepository.existsById(id)){
    		return this.desenvolvedorRepository.findById(id);
    	}
    	return null;
    
	}
}
