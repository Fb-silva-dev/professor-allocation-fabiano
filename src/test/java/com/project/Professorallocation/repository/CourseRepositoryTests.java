package com.project.Professorallocation.repository;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.Professorallocation.model.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTests {
	@Autowired
	CourseRepository repository;

	@Test
	public void create() throws ParseException {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setName("Python");
		
		courseBeingCreated = repository.save(courseBeingCreated);
		System.out.println(courseBeingCreated);
	}

	@Test
	public void findAll() {
		List<Course> items = repository.findAll();
		System.out.println("Qtd. elementos de cursos retornados : " + items.size());
		for (Course item : items) {
			System.out.println(item);
		}
	}
}