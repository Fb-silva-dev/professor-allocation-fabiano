package com.project.Professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Professorallocation.model.Allocation;
import com.project.Professorallocation.model.Professor;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	// SELECT * FROM Allocation WERE professor_id =@professorId;
	List<Professor> findByProfessorId(Long professorId);
	
	List<Allocation> findbyCourseId(Long courseId);

	// List<Allocation> findByProfessorIdAndCourseId(Long professorId, Long
	// CourseId);
	// SELECT * FROM Allocation WERE professor_id = @professorId AND course_id =
	// @courseId
}
