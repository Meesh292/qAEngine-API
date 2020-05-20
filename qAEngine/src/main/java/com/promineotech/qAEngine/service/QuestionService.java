package com.promineotech.qAEngine.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.qAEngine.entity.Question;
import com.promineotech.qAEngine.entity.User;
import com.promineotech.qAEngine.repository.QuestionRepository;
import com.promineotech.qAEngine.repository.UserRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Iterable<Question> getAllQuestions() {
		return repo.findAll();
	}
	
	public Question getQuestion(Long id) {
		return repo.findOne(id);
	}
		
	public Question updateQuestion(Question question, Long id) throws Exception {
		Question foundQuestion = repo.findOne(id);
		if (foundQuestion == null) {
			throw new Exception("Question not found.");
		}
	foundQuestion.setContent(question.getContent());
		return repo.save(foundQuestion);
	}
	
	public Question createQuestion(Question question, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if (user == null) {
			throw new Exception("Invalid user.");
		}
		question.setDate(new Date());
		question.setUser(user);
		return repo.save(question);
	}

}
