package com.quizapplication.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapplication.exception.QuizNotFoundException;
import com.quizapplication.model.Question;
import com.quizapplication.repo.QuestionRepo;

@Service
public class QuestionService implements QuestionInf {

	@Autowired
	QuestionRepo questionrepo;

	@Override
	public List<Question> getallQuestion() {

		return questionrepo.findAll();
	}

	@Override
	public List<Question> getDataCategory(String category) {
		return questionrepo.findByCategory(category);
	}

	@Override
	public Question getById(int id) {
		Optional<Question> op = questionrepo.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
//			System.out.println("Question with ID " + id + " not found");
			throw new QuizNotFoundException("Id Not Found");	
		}
	}

	@Override
	public List<Question> getDifficultLevel(String difficultLevel) {
		
		return questionrepo.findByDifficultLevel(difficultLevel);
	}

	@Override
	public String saveQuestion(Question question) {
		
		try {
			questionrepo.save(question);
			return "Question added successfully the ID number is : " + question.getId();
		}catch(Exception e) {
			System.out.println(e);
			return "something went wrong";
		}
	}

	@Override
	public Question update(Question que) {
		try {
			questionrepo.save(que);
			return questionrepo.findById(que.getId()).get();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	@Override
	public String deleteById(int id) {
		
		Optional<Question> dl = questionrepo.findById(id);
		
			if(dl.isPresent()) {
				questionrepo.deleteById(id);
//				return "id is deleted" + dl.get();
				return "The id number " + id + " is deleted";
			}else {
				throw new QuizNotFoundException("Id Not Found");
			}	
	}

	@Override
	public List<Question> getByCategoryAndDifficultLevel(String category, String difficultLevel) {
		
		return questionrepo.getByCategoryAndDifficultLevel(category,difficultLevel);
	}

}
