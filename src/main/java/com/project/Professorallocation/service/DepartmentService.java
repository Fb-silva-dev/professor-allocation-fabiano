package com.project.Professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Professorallocation.model.Department;
import com.project.Professorallocation.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	public Department Create(Department department) {
		department.setId(null);
		return saveinternal(department);
	}

	private Department saveinternal(Department department) {
		Department insertedDepartment = repository.save(department);
		return insertedDepartment;
	}

	public Department update(Department department) {
		Long id = department.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveinternal(department);
		}
	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {

			repository.deleteById(id);
		}
	}

	public Department findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Department> findAll() {
		return repository.findAll();

	}
} 
