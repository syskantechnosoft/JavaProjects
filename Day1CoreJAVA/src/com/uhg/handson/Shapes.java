package com.uhg.handson;

public class Shapes {
	private int numberOfSides;

	public void calculateShapeArea(int numberOfSides, int length) {
		if (numberOfSides == 1) {
			new Circle().calculateArea(length);
		} else if (numberOfSides == 3) {
			new Triangle().calculateArea(length);
		} else if (numberOfSides == 4) {
			new Square().calculateArea(length);
		} else {
			System.out.println("No Shapes Available");
		}
	}
	public static void main(String[] args) {
		Shapes shape = new Shapes();
		shape.calculateShapeArea(3, 12);
		shape.calculateShapeArea(4, 15);
		shape.calculateShapeArea(5, 15);
	}

}

class Circle {
	public void calculateArea(int radius) {
		System.out.println("The Area of the Circle is :" + (3.14 * radius * radius));
	}
}

class Triangle {
	public void calculateArea(int sides) {
		System.out.println("The Area of the Triangle is :" + (0.433 * sides * sides));
	}
}

class Square {
	public void calculateArea(int sides) {
		System.out.println("The Area of the Square is :" + (sides * sides));
	}
}