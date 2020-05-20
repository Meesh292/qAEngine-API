package com.promineotech.qAEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.qAEngine.entity.Response;
import com.promineotech.qAEngine.service.ResponseService;

@RestController
@RequestMapping("/users/{userId}/questions/{questionId}/questions")
public class ResponseController {

		@Autowired
		private ResponseService service;
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Object> createResponse(@RequestBody Response response, @PathVariable Long userId, @PathVariable Long questionId) {
			try {
				return new ResponseEntity<Object>(service.createResponse(response, userId, questionId), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		@RequestMapping(value="/{responseId}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteResponse(@PathVariable Long responseId) {
			service.deleteResponse(responseId);
			return new ResponseEntity<Object>("Deleted response with id:" + responseId, HttpStatus.OK);
		}
}
