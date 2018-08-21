package com.uhg.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		try {
			System.out.println(" a /b value :" + (a / b));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Exception Occured");
		}
	}

}
