package com.br.maisjogos.controller;

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
import java.util.List;

import com.br.maisjogos.entity.Review;
import com.br.maisjogos.service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/review")//Rota
public class ReviewController {
    private ReviewService reviewService;
    
    @Autowired //Anotação para subscrever os códigos
    public ReviewController(ReviewService reviewService){ //Pega o private e torna público
    	this.reviewService = reviewService; //Guarda na variável
    }
    
    //Criar
    @PostMapping //vai mapear e trazer o método post
    @ResponseStatus(HttpStatus.CREATED) //Traz  o status de htpp (200 ou 404 etc...)
    public Review cadastroReview(@Valid @RequestBody Review review) { //o valid valida e o request traz validado
    	return this.reviewService.cadastroReviewService(review); //vai cadastrar a review e retornar ela para o services
    }
    
    //Ler
    @GetMapping
    public List<Review> retornaTodasAsReviews(){ //Faz uma lista que importa todas as reviews
    	return this.reviewService.retornaTodasAsReviewsService();
    }
    
    @GetMapping("/{id}") //Pega o id para retornar uma review especifica
    public Review retornaReview(@PathVariable Long id) { //o @ identifica a mudança, a variável que é o id
    	return this.reviewService.retornaReviewService(id);
    }
    
    //Atualizar
    @PutMapping("/{id}")
    public Review alterarReview(@PathVariable Long id,@Valid @RequestBody Review review){
    	return this.reviewService.alterarReviewService(id,review);
    }
    
    //Deletar
    @DeleteMapping("/{id}")
    public Review deletarReview(@PathVariable Long id) {
    	return this.reviewService.deletarReviewService(id);
    }
}
