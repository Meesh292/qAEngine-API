package com.promineotech.qAEngine.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.qAEngine.entity.Response;
import com.promineotech.qAEngine.entity.Question;
import com.promineotech.qAEngine.entity.User;
import com.promineotech.qAEngine.repository.ResponseRepository;
import com.promineotech.qAEngine.repository.QuestionRepository;
import com.promineotech.qAEngine.repository.UserRepository;

@Service
public class ResponseService {

		@Autowired
		private ResponseRepository repo;
		
		@Autowired
		private QuestionRepository questionRepo;
		
		@Autowired
		private UserRepository userRepo;

		public Response createResponse(Response response, Long userId, Long questionId) throws Exception {
			User user = userRepo.findOne(userId);
			Question question = questionRepo.findOne(questionId);
			if (user == null || question == null) {
				throw new Exception("This user or question does not exist.");
			}
			response.setDate(new Date());
			response.setUser(user);
			response.setQuestion(question);
			return repo.save(response);
		}
		
		public void deleteResponse(Long responseId) {
			repo.delete(responseId);
	}
}
