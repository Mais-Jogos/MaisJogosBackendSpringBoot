package com.br.maisjogos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mais-jogos/health-check")
public class HealthController {
	
	@GetMapping
	public long health() {
		return System.currentTimeMillis();
	}
	@GetMapping("/jogos")
	public long health2() {
		return System.currentTimeMillis();
	}
}
