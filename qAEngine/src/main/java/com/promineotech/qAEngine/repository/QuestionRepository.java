package com.promineotech.qAEngine.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.qAEngine.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	
}