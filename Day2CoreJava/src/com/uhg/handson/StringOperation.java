package com.uhg.handson;

import java.util.StringTokenizer;

public class StringOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Problem1().method();
		new Problem2().method();
		new Problem3().method();
	}

}

class Problem1 {
	public void method() {
		String str = "Welcome to Java World";
		System.out.println("Character At Position 5 :" + str.charAt(4));
		System.out.println("Comparision with Welcome :" + str.compareToIgnoreCase("Welcome"));
		System.out.println("Concatenation Result:" + str.concat("- Let us learn"));
		System.out.println("Position of a (first Occurance) :" + str.indexOf('a'));
		System.out.println("Replacing a by e :" + str.replace('a', 'e'));
		System.out.println("String between 4 and 10 :" + str.substring(4, 11));
		System.out.println("Lowercase of String :" + str.toLowerCase());
	}
}

class Problem2 {
	public void method() {
		StringBuffer stringBuffer = new StringBuffer("This is StringBuffer");
		System.out.println(stringBuffer.append("- This is a sample program"));
		System.out.println(stringBuffer.insert(21, "Object"));
		System.out.println(stringBuffer.reverse());
		System.out.println(stringBuffer.reverse().replace(14, 20, "Builder"));
	}
}

class Problem3 {
	public void method() {
		StringTokenizer str = new StringTokenizer("C:\\IBM\\DB2\\PROGRAM\\DB2COPY1.EXE", "\\");
		String drive = "";
		StringBuilder folder = new StringBuilder("");
		String file = "";
		int i = 0;
		int tokenCount = str.countTokens();
		System.out.println("Token Count :" + tokenCount);

		while (str.hasMoreTokens()) {
			i++;
			String temp = str.nextToken("\\");
			if (i == 1) {
				drive = temp;
			} else if (i < tokenCount - 1) {
				folder.append(temp).append("||");
			} else if (i == tokenCount - 1) {
				folder.append(temp);
			} else {
				file = temp;
			}
		}
		System.out.println("Drive :" + drive + "\nFolder :" + folder + "\nFile :" + file);
	}
}