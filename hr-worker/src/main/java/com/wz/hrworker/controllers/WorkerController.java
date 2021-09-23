package com.wz.hrworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	private final WorkerRepository repository;
	
	private final Environment env;
	
	@Autowired
	public WorkerController(WorkerRepository repository, Environment env){
		this.repository = repository;
		this.env = env;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		/*
		 *Teste de timeout 
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
