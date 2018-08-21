/**
 * 
 */
package com.uhg;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "all" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * This is an Example of Multi-line comment
		 */
		// primitive integer homogeneous array
		int a[] = { 1, 2, 3, 4, 5 };

		// fixed size primitive homogeneous array
		int b[] = new int[5];
		b[0] = 5;
		b[1] = 6;

		// Heterogenous array

		Object obj[] = { 1, 2, 3, true, "Test", 5.7f, 10000000l, 6.57867876 };

		System.out.println(obj[2]);
		// Autoboxing
		// Boxing -- converting from primitive to it's (corresponding) object
		// Unboxing -- reverse
		// Typecasting -- conversion from one primitive to another primitive
		// Upcasting or downcasting (widening or narrowing) [implicit &
		// Explicit]

		Date date = new Date();
		System.out.println("Today Date is :" + date);

		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println("Sql Date is :" + sqlDate);

		date = new Date(2018, 8, 7);
	}

}
