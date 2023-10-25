package com.br.maisjogos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.maisjogos.entity.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long>{
	Optional<Avatar> findByNome(String nome);
}
