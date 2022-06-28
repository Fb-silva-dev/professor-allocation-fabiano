
package com.project.Professorallocation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.Professorallocation.model.Allocation;
//import com.project.Professorallocation.model.Course;
//import com.project.Professorallocation.model.Professor;
import com.project.Professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;
	// private final ProfessorService professorService;
	// private final CourseService courseService;

	public AllocationService(AllocationRepository repository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.repository = repository;
		// this.professorService = professorService;
		// this.courseService = courseService;

	}

	public Allocation findById(Long Id) {
		return repository.findById(Id).orElse(null);

	}

	public List<Allocation> findAll() {
		return repository.findAll();

	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
	}

	public void deletAll() {
		repository.deleteAllInBatch();
	}

	public List<Allocation> findByProfessor(Long id) {
		return AllocationRepository.findByProfessorId(id);
	}

	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		return saveInternal(allocation);
	}

	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && repository.existsById(id)) {
			return saveInternal(allocation);
		} else {
			return null;

		}
	}

	Allocation saveInternal(Allocation allocation) {
		if (!isEndHourGreaterThanStartHour(allocation) || hasCollision(allocation)) {
			throw new RuntimeException("There is a time collision for this allocation");
		} else {
			allocation = repository.save(allocation);
//-------------------------------------------------------
			//Professor professor = professorService.findById(allocation.getProfessorId());
			//allocation.setProfessor(professor);

			//Course course = courseService.findById(allocation.getCourseId());
			//allocation.setCourse(course);
//-------------------------------------------------------
			return allocation;
		}
	}

	private boolean isEndHourGreaterThanStartHour(Allocation allocation) {
		return allocation != null && allocation.getStartHour() != null && allocation.getStartHour() != null
				&& Allocation.getEndHour().compareTo(allocation.getStartHour()) > 0;
	}

	// ------------------------------- novo
	
	private boolean hasCollision(Allocation newAllocation) {
		boolean hascollision = false;

		List<Allocation> currentAllocations = AllocationRepository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation item : currentAllocations) {
			if (hasCollision(item, newAllocation)) {
				hascollision = true;
				break;
			}
		}

		return hascollision;
	}

	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		boolean collision = !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getProfessorId().equals(newAllocation.getProfessorId())
				&& currentAllocation.getDayOfWeek().equals(newAllocation.getDayOfWeek())
				&& currentAllocation.getStartHour().compareTo(Allocation.getEndHour()) < 0
				&& newAllocation.getStartHour().compareTo(Allocation.getEndHour()) < 0;
		return collision;
	}
}