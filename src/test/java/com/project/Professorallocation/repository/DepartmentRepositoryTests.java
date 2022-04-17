package com.project.Professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.Professorallocation.model.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTests {

	// Criando uma nova instancia no spring

	@Autowired
	DepartmentRepository repository;

	 @Test
	public void findAll() {
		List<Department> items = repository.findAll();

		System.out.println("Qtd e elementos retornados:" + items.size());

		for (Department item : items) {
			System.out.println(item);

		}

	}

	// Criar um novo departamento
	@Test
	public void create() {	
		Department departmentBeingCreated = new Department(); // Create nao prescisa setar o ID
		// System.out.println("Id atual: " + departmentBeingCreated.getId());
		departmentBeingCreated.setNome("Departamento de informatica"); 
		
		// Metodo salvar
		departmentBeingCreated = repository.save(departmentBeingCreated); 
		
		// Trocando o valor de departmentBaingcreated pelo valor que foi salvo.
		System.out.println(departmentBeingCreated); 
		
		// Criando um novo departamento "Enfermagem"
		// Department departmentBeingCreated = new Department();
		// departmentBeingCreated.setNome("Departamento de
		// Enfermagem","Fisica","Filosofia" );
		// System.out.println("Id atual: " + departmentBeingCreated.getId());
		// Metodo salvar
		// departmentBeingCreated = repository.save(departmentBeingCreated);
		// Trocando o valor de departmentBaingcreated pelo valor que foi salvo.
		// System.out.println(departmentBeingCreated);
	}

	@Test //Modificar dados da tabela
	public void update() {
		Department departmentBeingCreated = new Department();
		// no update devo setar o ID
		departmentBeingCreated.setId(5L);
		departmentBeingCreated.setNome("Departamento de Fisioterapia");
		// System.out.println("Id atual: " + departmentBeingCreated.getId());
		// Metodo salvar
		departmentBeingCreated = repository.save(departmentBeingCreated);
		// Trocando o valor de departmentBaingcreated pelo valor que foi salvo.
		System.out.println(departmentBeingCreated);
	}

	// teste de como deletar um elemento especifico da tabela
	public void delete() {
		// DeleteById espera sempre um id com a letra L
		repository.deleteById(6L);
	}

	// Deleta todos os registros de uma unica vez
	@Test
	public void delleteAlltems() {
		repository.deleteAllInBatch();
	}

}
