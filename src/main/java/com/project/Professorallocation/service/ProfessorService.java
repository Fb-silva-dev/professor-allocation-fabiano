package com.project.Professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.project.Professorallocation.model.Professor;
import com.project.Professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public ProfessorService(ProfessorRepository repository) {
		super();
		this.repository = repository;
	}
	public Professor Create(Professor professor) {
		professor.setId(null);
		return saveinternal(professor);
	}

	private Professor saveinternal(Professor professor) {
		Professor insertedProfessor = repository.save(professor);
		return insertedProfessor;
	}

	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveinternal(professor);
		}
	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {

			repository.deleteById(id);
		}
	}

	public Professor findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Professor> findAll() {
		return repository.findAll();

	}
}


