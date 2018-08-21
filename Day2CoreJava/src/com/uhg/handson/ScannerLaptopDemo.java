package com.uhg.handson;

import java.util.Scanner;

public class ScannerLaptopDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int a, b;
		do {
			System.out.println("Enter Option:\nAdd:1\nSubtract:2\nMultipy:3\nQuit:4");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter two numbers to be added");
				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println("The result is " + (a + b));
				break;
			case 2:
				System.out.println("Enter two numbers to be subtracted");
				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println("The result is " + (a - b));
				break;
			case 3:
				System.out.println("Enter two numbers to be multiply");

				a = sc.nextInt();
				b = sc.nextInt();
				System.out.println("The result is " + (a * b));
				break;
			case 4:
				System.out.println("Quitting...");
				break;
			default:
				System.out.println("Enter correct value");
			}
		} while (n != 4);
		sc.close();
	}
}
