package com.app.service;

import java.util.List;

import com.app.model.Quiz;


public interface QuizService {
	public Quiz saveQuiz(Quiz quiz);

	public List<Quiz> allQuestions();
}
