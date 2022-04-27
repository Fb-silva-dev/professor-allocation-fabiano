package com.project.Professorallocation.service;

import org.springframework.stereotype.Service;
import com.project.Professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public ProfessorService(ProfessorRepository repository) {
		super();
		this.repository = repository;
	}
}
