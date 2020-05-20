package com.promineotech.qAEngine.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	private Long id;
	private String username;
	
	private String password;
	
	@JsonIgnore
	private Set<Question> questions;
	
	@JsonIgnore
	private Set<Response> responses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Response> getResponses() {
		return responses;
	}
	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}
}
