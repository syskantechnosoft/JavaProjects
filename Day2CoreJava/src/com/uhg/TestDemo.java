package com.uhg;

public abstract class TestDemo implements Drawable {

	// method signature - This is a empty & concrete method
	public void display() {
		System.out.println(Drawable.a);
	}

	// This is an incomplete/ non-concrete method
	public abstract void show();
	
	public static void main(String[] args) {
		//Drawable draw = 
	}

}
