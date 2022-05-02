package com.project.Professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Professorallocation.model.Course;
import com.project.Professorallocation.repository.CourseRepository;

@Service

public class CourseService {

	private final CourseRepository repository;

	// Criar um constructor para servico , nao pode ser vasio
	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	// metodo para criar um novo course

	public Course Create(Course course) {
		course.setId(null);
		return saveinternal(course);
	}

	// Metodo para Salvar um curso criado
	private Course saveinternal(Course course) {
		Course insertedCourse = repository.save(course);
		return insertedCourse;
	}

	// Atualizar um Curso por ID
	public Course update(Course course) {
		Long id = course.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveinternal(course);
		}
	}

	// deletar um curso pelo ID
	public void deleteById(Long id) {
		if (repository.existsById(id)) {

			repository.deleteById(id);
		}
	}

	public Course findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	// Listar os cursos do repositorio
	public List<Course> findAll() {
		return repository.findAll();

	}

}
