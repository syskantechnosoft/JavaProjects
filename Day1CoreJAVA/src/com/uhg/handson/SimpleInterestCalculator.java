package com.uhg.handson;

public class SimpleInterestCalculator {
	private double principleAmount;
	private int noOfYears;
	private double simpleInterest;

	public void calculateSimpleInterest() {
		if (principleAmount >= 100000) {
			if (noOfYears >= 10) {
				simpleInterest = principleAmount * noOfYears * 10 / 100;
			} else if (noOfYears < 10) {
				simpleInterest = principleAmount * noOfYears * 9.5 / 100;
			}
		} else {
			if (noOfYears >= 10) {
				simpleInterest = principleAmount * noOfYears * 5 / 100;
			} else if (noOfYears < 10) {
				simpleInterest = principleAmount * noOfYears * 4.5 / 100;
			}
		}
		System.out.println("The interest amount for a principal of INR." + principleAmount + " and " + noOfYears
				+ " years is :" + simpleInterest);
	}

	public static void main(String[] args) {
		SimpleInterestCalculator sic = new SimpleInterestCalculator();
		sic.principleAmount = 200000;
		sic.noOfYears = 12;
		sic.calculateSimpleInterest();
		sic.principleAmount = 50000;
		sic.noOfYears = 12;
		sic.calculateSimpleInterest();
		sic.principleAmount = 50000;
		sic.noOfYears = 5;
		sic.calculateSimpleInterest();
	}

}
