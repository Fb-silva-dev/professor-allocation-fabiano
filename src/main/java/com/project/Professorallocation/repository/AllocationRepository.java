package com.project.Professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Professorallocation.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	// SELECT * FROM Allocation WERE professor_id =@professorId;
	List<Allocation> findByProfessorId(Long professorIdLong);

	List<Allocation> findByCourseId(Long courseIdLong);

	// List<Allocation> findByProfessorIdAndCourseId(Long professorId, Long
	// CourseId);
	// SELECT * FROM Allocation WERE professor_id = @professorId AND course_id =
	// @courseId
}
