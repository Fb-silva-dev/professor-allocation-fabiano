package com.project.Professorallocation.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "professor")

public class Professor {
	@JsonProperty(access = Access.READ_ONLY)
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 11, nullable = false, unique = true)
	private String Cpf;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "department_id", nullable = false, unique = false)
	private Long departmentId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "department_id", nullable = false, insertable = false, updatable = false)
	
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Professor() {
		super();
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", cpf=" + Cpf + ", departmentId=" + departmentId + "]";
	}

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	} 


	
}
