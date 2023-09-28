package com.br.maisjogos.service;

import java.util.List;

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
	
	public Review cadastroReviewService(@Valid Review review) { //Do Post
			return this.reviewRepository.save(review);
	}
	
	public List<Review> retornaTodasAsReviewsService() { //Do Get
		return this.reviewRepository.findAll(); //o findAll é o select que retorna tudo
	}

	public Review retornaReviewService(Long id) {//Retornar apenas um
		if(this.reviewRepository.existsById(id)){ //if perguntando se existe o id
			return this.reviewRepository.findById(id).get();
		}
		return null;
	}
	
	//Put
	public Review alterarReview(Long id, @Valid Review review) {
		if(this.reviewRepository.existsById(id)) {
			Review reviewAlterado = this.reviewRepository.findById(id).get();
			review.setId(id);
			if(review.getDescricaoReview() == null) { // se for int tem que colocar equals(0) ao invés de null
				review.setDescricaoReview(reviewAlterado.getDescricaoReview());
			}
			if(review.getDataReview() == null) {
				review.setDataReview(reviewAlterado.getDataReview());
			}
			if(review.getNotaReview()==0){
				review.setNotaReview(reviewAlterado.getNotaReview());
			}
			return this.reviewRepository.save(review);
		}
		
		return null;
	}
	//Delete
	public Review deletarReviewService(Long id) {
		if(this.reviewRepository.existsById(id)) {
			this.reviewRepository.deleteById(id);
		}
		return null;
	}

}
