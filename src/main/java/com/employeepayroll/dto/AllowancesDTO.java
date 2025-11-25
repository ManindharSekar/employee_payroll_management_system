package com.employeepayroll.dto;

import lombok.Data;

@Data
public class AllowancesDTO {
	
	private Long id;
	
	private String name;

	private String amountType;

	private double value;

}
