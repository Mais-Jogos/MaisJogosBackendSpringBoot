package com.br.maisjogos.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.maisjogos.entity.Favorito;
import com.br.maisjogos.repository.FavoritoRepository;

import jakarta.validation.Valid;

public class FavoritoService {

	private final FavoritoRepository favoritoRepository;
	
	public FavoritoService(FavoritoRepository favoritoRepository) {
		this.favoritoRepository = favoritoRepository;
	}
	
	public Favorito cadastroFavoritoService(@Valid Favorito favorito) {
		return this.favoritoRepository.save(favorito);
	}

	public List<Favorito> retornaTodosOsFavoritosService() {
		return this.favoritoRepository.findAll();
	}

	public Favorito retornaFavoritoService(@PathVariable Long id) {
		if(this.favoritoRepository.existsById(id)) {
			return this.favoritoRepository.findById(id).get();
		}
		return null;
	}
	
	public Favorito alterarFavoritoService(Long id, @Valid @RequestBody Favorito favorito) {
		if(this.favoritoRepository.existsById(id)) {
			Favorito favoritoAlterado = this.favoritoRepository.findById(id).get();
			favorito.setId(id);
		
		
			if(favorito.getCliente()== null) {
				favorito.setCliente(favoritoAlterado.getCliente());
			}
			if(favorito.getJogo()== null) {
				favorito.setJogo(favoritoAlterado.getJogo());
		}
		return this.favoritoRepository.save(favorito);	
	}
	return null;
}
	public Favorito deletarFavoritoService(Long id) {
		if(this.favoritoRepository.existsById(id)) {
			this.favoritoRepository.deleteById(id);
		}
		return null;
	}
}
