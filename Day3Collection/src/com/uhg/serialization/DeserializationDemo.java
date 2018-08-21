package com.uhg.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("d:\\output.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Employee emp = (Employee) ois.readObject();

		System.out.println(emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getSalary());
	}

}
