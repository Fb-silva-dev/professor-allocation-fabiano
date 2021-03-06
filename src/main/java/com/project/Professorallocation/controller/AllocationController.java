package com.project.Professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.Professorallocation.model.Allocation;
import com.project.Professorallocation.service.AllocationService;

@RestController
@RequestMapping(path = "/allocations") // vai definir qual o caminho do recurso.
public class AllocationController {

	private final AllocationService service;

	public AllocationController(AllocationService service) {
		super();
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allItems = service.findAll();

		// return new ResponseEntity<List<Allocation>>(allItems, HttpStatus.OK); errado
		return new ResponseEntity<>(allItems, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> findById(@PathVariable(name = "id") Long id) {
		Allocation allItems = service.findById(id);
		if (allItems == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(allItems, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/professor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findByProfessorId(@PathVariable(name = "id") Long id) {
		List<Allocation> allItems = service.findByProfessor(id);
		return new ResponseEntity<>(allItems, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {
		try {
			Allocation allItems = service.create(allocation);
			return new ResponseEntity<>(allItems, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(path = "/professor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> update(@PathVariable(name = "allItems_id") Long id,
			@RequestBody Allocation allocation) {
		try {

			allocation.setId(id);
			Allocation newallItems = service.create(allocation);

			if (newallItems == null) {

				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(newallItems, HttpStatus.CREATED);

			}

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Void> delete(@PathVariable(name = "allItems_id") Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
