package com.br.maisjogos.service;

import org.springframework.stereotype.Service;

import com.br.maisjogos.entity.Review;
import com.br.maisjogos.repository.ReviewRepository;

import jakarta.validation.Valid;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;//A váriavel não pode ser modificada, apenas ir e voltar
	
	public ReviewService(ReviewRepository reviewRepository) { //Construtor do service
		this.reviewRepository = reviewRepository;
	}
	public Review cadastroReviewService(@Valid Review review) { //construtor
			return this.reviewRepository.save(review);
		
	}

}
