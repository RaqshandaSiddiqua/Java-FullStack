package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Quiz;
import com.app.service.QuizService;

@Component
public class DBInitializer implements CommandLineRunner{
	private QuizService service;
	public DBInitializer(QuizService service) {
		this.service=service;
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Quiz quiz1 =new Quiz("What is the name of prime minister of India?","Pranab Mukharjee","Narendra Modi","Manmohan Singh"," Amit Shah",2);
		Quiz quiz2 =new Quiz("Who was known as Iron man of India?"," Govind Ballabh Pan","Jawaharlal Nehru","Subhash Chandra Bose","Sardar Vallabhbhai Patel",4);
		Quiz quiz3 = new Quiz("Plants receive their nutrients mainly from","chlorophyll"," atmosphere","light"," soil",4);
		Quiz quiz4=new Quiz( "What is the capital of Telangana", "Hyderabad", "Bangalore", "Chennai", "Gulbarga", 1);
		Quiz quiz5=new Quiz( "Which day World Teachers Day is celebrated?", "5th October", "4th October", "3rd October", "7th October", 1);
		Quiz quiz6=new Quiz( "Which Ministry allowed 'on-demand' COVID-19 testing?", "Ministry of AYUSH", "Ministry of Health", "Ministry of Home Affairs","None of these", 2);
		Quiz quiz7=new Quiz("The nucleus od an atom contains", "electrons and neutrons", "electrons and protons", "protons and neutrons", "All of the above", 3);
		Quiz quiz8=new Quiz("Light travels at the fastest speed in", "glass", "water", "hydrogen", "vacuum", 4);
		Quiz quiz9=new Quiz("Which is known as 'Garden City of India?", "Trivandram", "Imphal", "Shimla", "Bangalore", 4);
		Quiz quiz10=new Quiz("What is part of a database that holds only one type of information?", "Report", "Field", "Record", "File", 2);
		this.service.saveQuiz(quiz1);
		this.service.saveQuiz(quiz2);
		this.service.saveQuiz(quiz3);
		this.service.saveQuiz(quiz4);
		this.service.saveQuiz(quiz5);
		this.service.saveQuiz(quiz6);
		this.service.saveQuiz(quiz7);
		this.service.saveQuiz(quiz8);
		this.service.saveQuiz(quiz9);
		this.service.saveQuiz(quiz10);
		System.out.println("Database has been initialized");
		
	}

}
