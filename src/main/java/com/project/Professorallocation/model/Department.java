package com.project.Professorallocation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

// declarando a classe como entidade

@Entity
@Table(name = "department")
public class Department {
	@JsonProperty(access = Access.WRITE_ONLY)
	@Id // auto_increment
	@Column(nullable =false )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fullname", length = 100, nullable = false)
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department() {
		super();
	}

	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/

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
