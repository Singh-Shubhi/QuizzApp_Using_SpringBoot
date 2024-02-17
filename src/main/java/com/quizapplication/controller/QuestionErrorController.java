package com.quizapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quizapplication.exception.QuizNotFoundException;

@RestControllerAdvice
public class QuestionErrorController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<String, String>();
		
		ex.getBindingResult().getFieldErrors().forEach((er)->{
			errors.put(er.getField(), er.getDefaultMessage());
			});
		return errors;
	}
	
	@ExceptionHandler(QuizNotFoundException.class)
	public Map<String, String> QuizNotFound(QuizNotFoundException ex){
		
		Map<String, String> error = new HashMap<String, String>();
		
		error.put("error", ex.getMessage());
		
		return error;
	}
}
	