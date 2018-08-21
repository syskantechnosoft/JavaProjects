package com.uhg.collection;

import java.util.HashMap;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Student> hashMap = new HashMap<String, Student>();
		Student student1 = new Student(100, "Test1", "test1@gmail.com");
		// hashMap.put("1", new Object());
		Student student2 = new Student(101, "Test2", "test2@gmail.com");
		Student student3 = new Student(102, "Test3", "test3@gmail.com");
		Student student4 = new Student(103, "Test4", "test4@gmail.com");

		hashMap.put("stu1", student1);
		hashMap.put("stu2", student2);
		hashMap.put("stu3", student3);
		hashMap.put("stu4", student4);
		hashMap.put("stu4", student4);
		// hashMap.put(null, student4);
		hashMap.put("stu5", null);
		hashMap.put("stu6", null);

		System.out.println("HashMap :" + hashMap);

		// System.out.println(hashMap.get("stu1"));

		Set<String> keys = hashMap.keySet();
		for (String key : keys) {
			if (key != null)
				System.out.println(hashMap.get(key));
		}

	}

}

class Student {
	private int id;
	private String name;
	private String email;

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

	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
