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
		allocation.setId(null);
		allocation.setDayOfWeek(DayOfWeek.THURSDAY);
		allocation.setDayOfWeek(DayOfWeek.SUNDAY);
		allocation.setStartHour(sdf.parse("17:00-0300"));
		allocation.setEndHour(sdf.parse("18:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = repository.save(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void findAll() {
		List<Allocation> allocations = repository.findAll();
		allocations.forEach(System.out::println);
	}
}
