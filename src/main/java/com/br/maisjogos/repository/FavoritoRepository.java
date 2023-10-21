package com.br.maisjogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.maisjogos.entity.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

}
