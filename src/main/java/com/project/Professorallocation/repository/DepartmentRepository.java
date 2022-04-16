package com.project.Professorallocation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Professorallocation.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findByName(String name);
	// select*from department WERE name = @name

	List<Department> findByNameLike(String name);
	// select*from department WERE name LIKE %@name%
}
