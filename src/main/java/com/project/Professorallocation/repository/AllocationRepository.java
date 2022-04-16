package com.project.Professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Professorallocation.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	// SELECT * FROM Allocation WERE professor_id =@professorId;
	List<Allocation> findByProfessorId(Long professorId);
	// Metodo para Retornar as Alocacoes de um professor expecifico ordenado por
	// hora decrescente ;

	List<Allocation> findbyCourseId(Long courseId);
	// Metodo para retornar as alocacoers de um curso expecifico;

	// List<Allocation> findByProfessorIdAndCourseId(Long professorId, Long
	// CourseId);
	// SELECT * FROM Allocation WERE professor_id = @professorId AND course_id =
	// @courseId
}
