package com.employeepayroll.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class LeaveRule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Yeear is Required")
	private LocalDate year;
	
	@NotNull(message = "NoOfDays is Required")
	private int noOfDays;
	
	@NotNull(message = "NoOfGovLeaves is REquired")
	private int noOfGovLeave;
	
	@NotNull(message = "NoOfWorkingDays is Required")
	private int noOfWorkingDays;
	
	@NotNull(message = "NoOfLeaveTaken isRequired")
	private int noOfLeaveTaken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfGovLeave() {
		return noOfGovLeave;
	}

	public void setNoOfGovLeave(int noOfGovLeave) {
		this.noOfGovLeave = noOfGovLeave;
	}

	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}

	public void setNoOfWorkingDays(int noOfWorkingDays) {
		this.noOfWorkingDays = noOfWorkingDays;
	}

	public int getNoOfLeaveTaken() {
		return noOfLeaveTaken;
	}

	public void setNoOfLeaveTaken(int noOfLeaveTaken) {
		this.noOfLeaveTaken = noOfLeaveTaken;
	}
	
	

}
