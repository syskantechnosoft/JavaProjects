package com.uhg.handson;

import java.util.Scanner;

public class NumberToWord {

	public static void main(String[] args) {
		int number = 0;
		String word = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter any Number :");
		number = input.nextInt();
		int temp = reverse(number);
		while (temp > 0) {
			switch (temp % 10) {
			case 1:
				word += " One ";
				break;
			case 2:
				word += " Two ";
				break;
			case 3:
				word += " Three ";
				break;
			case 4:
				word += " Four ";
				break;
			case 5:
				word += " Five ";
				break;
			case 6:
				word += " Six ";
				break;
			case 7:
				word += " Seven ";
				break;
			case 8:
				word += " Eight ";
				break;
			case 9:
				word += " Nine ";
				break;
			}
			temp /= 10;
		}
		System.out.println("Output is : " + word);
		input.close();
	}

	public static int reverse(int x) {
		int r = 0;
		while (x > 0) {
			r = (r * 10) + (x % 10);
			x /= 10;
		}
		return r;
	}

}
