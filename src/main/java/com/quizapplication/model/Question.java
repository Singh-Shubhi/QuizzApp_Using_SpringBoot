package com.quizapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// if i put data it will come from lombok then no need to create getter and setter for this it will handle it 
//@Data 
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	@NotBlank(message="QuestionTitle should not be blank")
	private String questionTitle;
	
	@Column
	@NotBlank(message="Option1 field should not be blank")
	private String option1;
	
	@Column
	@NotBlank(message="Option 2 field should not be blank")
	private String option2;
	
	@Column
	@NotBlank(message="Option 3 field should not be blank")
	private String option3;
	
	@Column
	@NotBlank(message="Option 4 field should not be blank")
	private String option4;
	
	@Column
	@NotBlank(message="RightAnswer field should not be blank")
	private String rightAnswer;
	
	@Column
	@NotBlank(message="Difficult Level field should not be blank")
	private String difficultLevel;
	
	@Column
	@NotBlank(message="Category filed should not be blank")
	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getDifficultLevel() {
		return difficultLevel;
	}

	public void setDifficultLevel(String difficultLevel) {
		this.difficultLevel = difficultLevel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public Question(Integer id, @NotBlank(message = "QuestionTitle should not be blank") String questionTitle,
			@NotBlank(message = "Option1 field should not be blank") String option1,
			@NotBlank(message = "Option 2 field should not be blank") String option2,
			@NotBlank(message = "Option 3 field should not be blank") String option3,
			@NotBlank(message = "Option 4 field should not be blank") String option4,
			@NotBlank(message = "RightAnswer field should not be blank") String rightAnswer,
			@NotBlank(message = "Difficult Level field should not be blank") String difficultLevel,
			@NotBlank(message = "Category filed should not be blank") String category) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightAnswer = rightAnswer;
		this.difficultLevel = difficultLevel;
		this.category = category;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
