package com.uhg.handson;

public class Employee {
	private long employeeId;
	private String employeeName;
	private String employeeAddress;
	private long employeePhone;
	double basicSalary;
	private double specialAllowance = 250.8;
	private double hra = 1000.50;

	public Employee(long employeeId, String employeeName, String employeeAddress, long employeePhone) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
	}

	public void calculateSalary() {
		double salary = basicSalary + specialAllowance + hra;
		System.out.println("Calculated Salary :" + salary);
	}

	public void calculateTransportAllowance() {
		double transportAllowance = (10.0 / 100.0) * basicSalary;
		System.out.println("Transport Allowance :" + transportAllowance);
	}
}

class Manager extends Employee {

	public Manager(long employeeId, String employeeName, String employeeAddress, long employeePhone,
			double basicSalary) {
		super(employeeId, employeeName, employeeAddress, employeePhone);
		super.basicSalary = basicSalary;
	}

	public void calculateTransportAllowance() {
		double transportAllowance = (15.0 / 100.0) * this.basicSalary;
		System.out.println("Transport Allowance :" + transportAllowance);
	}
}

class Trainee extends Employee {

	public Trainee(long employeeId, String employeeName, String employeeAddress, long employeePhone,
			double basicSalary) {
		super(employeeId, employeeName, employeeAddress, employeePhone);
		super.basicSalary = basicSalary;
	}

}