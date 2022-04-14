package com.project.Professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Professorallocation.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

	
}
 