package com.quizapplication.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizapplication.model.Question;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

	public List<Question> findByCategory(String category);

	@Query(value="select * from Question where difficult_Level = :difficult_Level", nativeQuery=true) //HQL it is
	public List<Question> findByDifficultLevel(@Param("difficult_Level") String difficultLevel);

	public List<Question> getByCategoryAndDifficultLevel(String category, String difficultLevel);

	@Query(value="select * from Question  where category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery=true)
	public List<Question> findRandomQuestionByCategory(String category, int numQ);

}
