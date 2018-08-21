package com.uhg.handson;

import java.util.Scanner;

public class NumberToWord1 {

	public static void main(String[] args) {
		int number = 0;
		String word = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter any Number :");
		number = input.nextInt();
		int temp = number;
		while (temp > 0) {
			switch (temp % 10) {
			case 1:
				word = " One " + word;
				break;
			case 2:
				word = " Two " + word;
				break;
			case 3:
				word = " Three " + word;
				break;
			case 4:
				word = " Four " + word;
				break;
			case 5:
				word = " Five " + word;
				break;
			case 6:
				word = " Six " + word;
				break;
			case 7:
				word = " Seven " + word;
				break;
			case 8:
				word = " Eight " + word;
				break;
			case 9:
				word = " Nine " + word;
				break;
			}
			temp /= 10;
		}
		System.out.println("Output is : " + word);
		input.close();
	}

}
