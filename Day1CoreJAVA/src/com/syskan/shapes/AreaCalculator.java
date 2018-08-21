package com.syskan.shapes;

public class AreaCalculator {
	public static void main(String[] args) {
		Rectangle rectangle; // Declaring Object reference
		rectangle = new Rectangle(); // Creating Object & assigning to Obj Ref

		System.out.println("hashcode of rectangle : " + rectangle.hashCode());
		System.out.println("rectangle object :" + rectangle);
		rectangle.calculateArea();
	}
}
