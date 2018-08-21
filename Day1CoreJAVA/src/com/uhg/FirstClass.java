package com.uhg;

public class FirstClass {

	private int property1; // Instance variable (class member/ member property)
	private float property2; // Instance variable

	public void method1() { // Member method
		// FirstClass firstclass = new FirstClass();
		// legally valid but logically invalid
		// firstclass.property1 = 1;
		property2 = 5.0f;
		System.out.println("Test");
		// firstclass.method1();
	}

	// FirstClass firstclass = new FirstClass();
	// legally valid but logically invalid

	public static void main(String[] args) {
		FirstClass firstClass = new FirstClass();
		firstClass.method1();

	}
}
