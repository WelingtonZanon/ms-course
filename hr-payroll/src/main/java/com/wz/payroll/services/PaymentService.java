package com.wz.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wz.payroll.entities.Payment;
import com.wz.payroll.entities.Worker;
import com.wz.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
		
	private final WorkerFeignClient workerFeignClient;
	
	@Autowired
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}
	
	public Payment getPayment(long workerId, int days) {
		
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
