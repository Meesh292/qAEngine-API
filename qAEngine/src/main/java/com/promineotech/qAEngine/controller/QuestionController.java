package com.promineotech.qAEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.qAEngine.entity.Question;
import com.promineotech.qAEngine.service.QuestionService;

@RestController
@RequestMapping("/users/{userId}/questions")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllQuestions() {
		return new ResponseEntity<Object>(service.getAllQuestions(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{questionId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getQuestion(@PathVariable Long questionId) {
		return new ResponseEntity<Object>(service.getQuestion(questionId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{questionId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateQuestion(@RequestBody Question question, @PathVariable Long questionId) {
		try {
			return new ResponseEntity<Object>(service.updateQuestion(question, questionId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createQuestion(@RequestBody Question question, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.createQuestion(question, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}


