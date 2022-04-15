package com.project.Professorallocation.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<AllocationRepository, Long> {
List<Allocation> findByProfessorId
}
