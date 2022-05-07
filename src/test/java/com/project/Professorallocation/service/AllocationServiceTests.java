package com.project.Professorallocation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.Professorallocation.model.Allocation;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationServiceTests {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationService service;
	
	@Test
	public void create() throws ParseException {
		Allocation allocation = new Allocation();
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		allocation.setProfessorId(2L);
		allocation.setCourseId(1L);
		allocation.setStartHour(sdf.parse("17:00-0300"));
		allocation.setEndHour(sdf.parse("18:00-0300"));
		
		allocation = service.create(allocation);
		
	}
} 
