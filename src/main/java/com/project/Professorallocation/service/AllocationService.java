package com.project.Professorallocation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.Professorallocation.model.Allocation;
import com.project.Professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

//Criar um constructor para servico , nao pode ser vasio
	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}

	public Allocation findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Allocation> findAll() {
		return repository.findAll();

	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
	}
	public Allocation Create(Allocation allocation) {
		allocation.setId(null);
		return saveInternal(allocation); 
	}
	private Allocation saveInternal(Allocation allocation) {
		Allocation createdAllocation = repository.save(allocation);
		return createdAllocation;
	}
}
