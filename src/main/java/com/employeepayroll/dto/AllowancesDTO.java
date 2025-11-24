package com.employeepayroll.dto;

public class AllowancesDTO {
	
	private Long id;
	
	private String name;

	private String amountType;

	private double value;

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

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
