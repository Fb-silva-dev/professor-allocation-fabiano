package com.project.Professorallocation.service;

import org.springframework.stereotype.Service;
import com.project.Professorallocation.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

}
