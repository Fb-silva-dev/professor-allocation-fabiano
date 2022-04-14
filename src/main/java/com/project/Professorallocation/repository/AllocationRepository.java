package com.project.Professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AllocationRepository {
	
	@Repository
	public interface ProfessorRepository extends JpaRepository<AllocationRepository,Long> {

		
	}
	 

}
