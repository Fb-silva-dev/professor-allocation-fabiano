package com.project.Professorallocation.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.Professorallocation.model.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationRepositoryTests {

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationRepository repository;

	@Test
	public void create() throws ParseException {
		Allocation allocation = new Allocation();

		// allocation.setId(4L);
		// allocation.setDayOfWeek(DayOfWeek.THURSDAY);
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		allocation.setStartHour(sdf.parse("19:00-0300"));
		allocation.setEndHour(sdf.parse("21:00-0300"));
		allocation.setProfessorId(5L);
		allocation.setCourseId(2L);

		// Act
		allocation = repository.save(allocation);

		// Print
		System.out.println(allocation);
	}

	// Deleta todos os registros de uma unica vez
	@Test
	public void delleteAll() {
		repository.deleteAllInBatch();
	}

	@Test
	public void findAll() {
		List<Allocation> items = repository.findAll();

		System.out.println("Qtd e elementos retornados:" + items.size());

		for (Allocation item : items) {
			System.out.println(item);
		}
	}
	@Test
	public void findAllByProfessorId() {
		List<Allocation> allocationOfASpecificProfessor = AllocationRepository.findByProfessorId(1L);
		allocationOfASpecificProfessor.forEach(System.out::println);
	}
	
}
