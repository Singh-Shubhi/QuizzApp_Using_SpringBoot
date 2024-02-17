package com.quizapplication.service;

import java.util.List;

import com.quizapplication.model.Question;
import com.quizapplication.model.Quiz;
import com.quizapplication.model.QuizDTO;
import com.quizapplication.model.Response;

public interface QuizInf {

	String createQuiz(String category, int numQ, String title);

	List<QuizDTO> getQuiz(int id);

	Integer calculateResult(int id, List<Response> responses);



}
