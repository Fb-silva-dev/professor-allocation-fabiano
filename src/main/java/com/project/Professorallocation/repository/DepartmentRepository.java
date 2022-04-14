package com.project.Professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Professorallocation.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	
	
}

