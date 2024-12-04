package com.exception;

public class Employee {
	private String emName;
	private long emId;
	private double emSalary;
	private String designation;

	public Employee() {
		super();
	}

	public Employee(String emName, long emId, double emSalary, String designation) {
		super();
		this.emName = emName;
		this.emId = emId;
		this.emSalary = emSalary;
		this.designation = designation;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public long getEmId() {
		return emId;
	}

	public void setEmId(long emId) {
		this.emId = emId;
	}

	public double getEmSalary() {
		return emSalary;
	}

	public void setEmSalary(double emSalary) {
		this.emSalary = emSalary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
