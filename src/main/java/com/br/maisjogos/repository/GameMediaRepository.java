package com.br.maisjogos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.maisjogos.entity.GameMedia;

@Repository
public interface GameMediaRepository extends JpaRepository<GameMedia, Long>{
	Optional<GameMedia> findByNome(String nome);
}
