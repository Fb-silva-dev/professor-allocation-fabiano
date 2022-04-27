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
import com.project.Professorallocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositoryTests {
	@Autowired 
	ProfessorRepository repository;

	@Test
	public void create() throws ParseException {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setName("Henrique");
		professorBeingCreated.setDepartmentId(1L);
		professorBeingCreated.setCpf("07373365431");
			
		professorBeingCreated = repository.save(professorBeingCreated);
		 
	} 
	@Test
	public void findAll() {
		List<Professor> items = repository.findAll();

		System.out.println("Qtd e elementos retornados:" + items.size());

		for (Professor item : items) {
			System.out.println(item);

		}
	}
	
}
