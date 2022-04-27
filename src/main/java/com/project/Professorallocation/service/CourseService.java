package com.project.Professorallocation.service;

import org.springframework.stereotype.Service;
import com.project.Professorallocation.repository.CourseRepository;

@Service

public class CourseService {

	private final CourseRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}
}
