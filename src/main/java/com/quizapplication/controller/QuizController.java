package com.quizapplication.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizapplication.model.Question;
import com.quizapplication.model.Quiz;
import com.quizapplication.model.QuizDTO;
import com.quizapplication.model.Response;
import com.quizapplication.service.QuizInf;

@RestController
@RequestMapping("/quiz") // used to specify  http method to the specific controller 
public class QuizController {
	
	@Autowired
	@Qualifier("quizService")
	QuizInf quizser;
	
	@PostMapping("/create")
	public String createQuiz(@RequestParam String category ,@RequestParam int numQ , @RequestParam String title) {
		return quizser.createQuiz(category,numQ,title);
	}

	@GetMapping("/fetchQuiz/{id}")
	public List<QuizDTO> getQuiz(@PathVariable int id){
		return quizser.getQuiz(id);
	}
	
	@PostMapping("/submit/{id}")
	public Integer submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
		
		return quizser.calculateResult(id,responses);
	}
}
