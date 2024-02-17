package com.quizapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizapplication.model.Question;
import com.quizapplication.model.Quiz;
import com.quizapplication.model.QuizDTO;
import com.quizapplication.model.Response;
import com.quizapplication.repo.QuestionRepo;
import com.quizapplication.repo.QuizRepo;

@Service
public class QuizService implements QuizInf {

	@Autowired
	QuizRepo quizrepo;
	
	@Autowired
	QuestionRepo questionrepo;

	@Override
	public String createQuiz(String category, int numQ , String title) {
		
		List<Question> questions = questionrepo.findRandomQuestionByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizrepo.save(quiz);
		
		return "Quiz created successfully"; 
	}

	@Override
	public List<QuizDTO> getQuiz(int id) {
		Optional<Quiz> quiz = quizrepo.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestion();
		List<QuizDTO> questionFromUser = new ArrayList<QuizDTO>();
		
		for(Question q: questionFromDB) {
			QuizDTO qw = new QuizDTO(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionFromUser.add(qw);
			
		}
		return questionFromUser;
	}

	@Override
	public Integer calculateResult(int id, List<Response> responses) {
		Optional<Quiz> quiz = quizrepo.findById(id);
		List<Question>  questions = quiz.get().getQuestion();
		
		int result =0;
		int i=0;
		for(Response response : responses) {
			
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
			     result++;
			     
			i++;
		}
		return result;
	}

	

}
