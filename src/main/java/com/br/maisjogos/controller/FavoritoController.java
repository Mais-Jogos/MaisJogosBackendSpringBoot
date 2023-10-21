package com.br.maisjogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.maisjogos.entity.Favorito;
import com.br.maisjogos.service.FavoritoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/favorito")
public class FavoritoController {
	private FavoritoService favoritoService;

	public FavoritoController(FavoritoService favoritoService) {
		this.favoritoService = favoritoService;
	}

//Criar
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Favorito cadastroFavorito(@Valid @RequestBody Favorito favorito) {
		return this.favoritoService.cadastroFavoritoService(favorito);
	}

//Ler
	@GetMapping
	public List<Favorito> retornaTodosOsFavoritos() {
		return this.favoritoService.retornaTodosOsFavoritosService();
	}

	@GetMapping("/{id}")
	public Favorito retornaFavorito(@PathVariable Long id) {
		return this.favoritoService.retornaFavoritoService(id);
	}

//Atualizar
	@PutMapping("/{id}")
	public Favorito alterarFavorito(@PathVariable Long id,@Valid @RequestBody Favorito favorito) {
		return this.favoritoService.alterarFavoritoService(id, favorito);
	}

//Deletar
	@DeleteMapping("/{id}")
	public Favorito deletarFavorito(@PathVariable Long id) {
		return this.favoritoService.deletarFavoritoService(id);
	}
}
