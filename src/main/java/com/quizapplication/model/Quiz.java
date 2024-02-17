package com.quizapplication.model;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	@NotBlank(message="title should not be blank")
	private String title;
	
	@ManyToMany(cascade = jakarta.persistence.CascadeType.ALL)
	private List<Question> question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public Quiz(int id, @NotBlank(message = "title should not be blank") String title, List<Question> question) {
		super();
		this.id = id;
		this.title = title;
		this.question = question;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
