package com.project.Professorallocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// declarando a classe como entidade

@Entity
@Table(name = "department")
public class Department {
	@Id // auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "fullname", length = 100, nullable = false)
	private String name;

	public Department() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", id=" + id + "]";
	}

}
