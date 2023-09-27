package com.br.maisjogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.maisjogos.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, String> {

}
