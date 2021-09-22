package com.wz.payroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
	
	private String nameString;
	private Double dailyIncome;
	private Integer days;

	public double getTotal() {
		return days * dailyIncome;
	}
}
