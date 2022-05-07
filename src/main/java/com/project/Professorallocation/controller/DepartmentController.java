package com.project.Professorallocation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Professorallocation.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments") // vai definir qual o caminho do recurso.
public class DepartmentController {
	private DepartmentService service;

	public public DepartmentController(DepartmentService service) {
		super();
		this.service = service;
	}

}
