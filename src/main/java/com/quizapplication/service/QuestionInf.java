package com.quizapplication.service;

import java.util.List;

import com.quizapplication.model.Question;

public interface QuestionInf {

	public List<Question> getallQuestion();

	public List<Question> getDataCategory(String category);

	public Question getById(int id);

	public List<Question> getDifficultLevel(String difficultLevel);

	public String saveQuestion(Question question);

	public Question update(Question que );

	public String deleteById(int id);

	public List<Question> getByCategoryAndDifficultLevel(String category, String difficultLevel);

}
