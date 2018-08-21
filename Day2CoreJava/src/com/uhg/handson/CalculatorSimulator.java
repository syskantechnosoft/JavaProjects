package com.uhg.handson;

public class CalculatorSimulator {
	public static void main(String[] args) {
		TaxCalculator tax = new TaxCalculator();
		double taxAmount = 0.0;
		try {
			//taxAmount = tax.calculateTax("Jhon", false, 34000);
			//taxAmount = tax.calculateTax("Balveer", true, 1000);
			taxAmount = tax.calculateTax("Mukesh", true, 55000);
			//taxAmount = tax.calculateTax("", true, 30000);
			System.out.println("The Tax Amount is :" + taxAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
