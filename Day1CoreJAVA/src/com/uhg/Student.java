package com.uhg;

public class Student {
	private int id;
	private String name;
	private String email;

	// Parameterized constructor3
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	// Parameterized constructor2
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Parameterized constructor1
	public Student(int i, String n) {
		id = i;
		name = n;
	}

	// Empty or Default or No-Argument Constructor
	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(100);
		student.setName("ABCD");
		student.setEmail("abcd@gmail.com");
		System.out.println("Student Details :" + student.getId() + " " + student.getName() + " " + student.getEmail());
		System.out.println("Student Details :" + student);

		student = new Student(102, "Test", "Test@gmail.com");
		System.out.println(student);
	}

}
