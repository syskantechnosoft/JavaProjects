package com.uhg.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {

	public static void main(String[] args) throws Exception {
		Employee emp1 = new Employee(1000, "ABCD", 15000.0);
		Employee emp2 = new Employee(1001, "EFGH", 18000.0);

		FileOutputStream fos = new FileOutputStream("d:\\output.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(emp1);
		// oos.writeObject(emp2);

		oos.flush();
		System.out.println("Object is Serialized");
		oos.close();
		fos.close();
	}

}

class Employee implements Serializable {
	private int empId;
	private String empName;
	private double salary;

	public Employee(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
