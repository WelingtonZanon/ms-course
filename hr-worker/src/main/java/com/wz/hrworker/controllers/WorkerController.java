package com.wz.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wz.hrworker.entities.Worker;
import com.wz.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {
	
	private final WorkerRepository repository;
	
	@Autowired
	public WorkerController(WorkerRepository repository){
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
