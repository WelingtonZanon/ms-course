package com.wz.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wz.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
