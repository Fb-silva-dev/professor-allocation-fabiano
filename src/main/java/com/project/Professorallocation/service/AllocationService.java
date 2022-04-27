package com.project.Professorallocation.service;

import org.springframework.stereotype.Service;
import com.project.Professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

//Criar um constructor para servico , nao pode ser vasio
	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}

}
