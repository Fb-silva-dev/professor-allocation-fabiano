
package com.project.Professorallocation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.Professorallocation.model.Allocation;
import com.project.Professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
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

	private Allocation saveInternal(Allocation allocation) {
		if (hasCollision(allocation)) {
			throw new RuntimeException("There is a time collision for this allocation");
		}
		allocation = repository.save(allocation);

		return allocation;
	}

	private boolean hasCollision(Allocation newAllocation) {
		boolean collisionFound = false;

		List<Allocation> currentAllocations = AllocationRepository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation item : currentAllocations) {
			if (hasCollision(item, newAllocation)) {
				collisionFound = true;
				break;
			}
		}

		return collisionFound;
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