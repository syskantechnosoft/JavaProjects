package com.uhg.handson;

import java.util.ArrayList;

@SuppressWarnings("all")
public class CollectionDemo {
	ArrayList A1 = new ArrayList<>();
	ArrayList A2 = new ArrayList<>();

	public ArrayList storeEvenNumbers(int N) {
		ArrayList al = new ArrayList();
		for (int i = 2; i <= N; i += 2)
			al.add(i);
		return al;
	}

	public ArrayList printEvenNumbers() {
		ArrayList al = new ArrayList<>();
		for (int i = 0; i < A1.size(); i++) {
			int temp = Integer.parseInt(A1.get(i).toString()) * 2;
			al.add(temp);
			System.out.print(temp + " ");
		}
		return al;
	}

	public int retrieveEvenNumber(int N) {
		if (A1.contains(N))
			return N;
		else
			return 0;
	}

	public static void main(String[] args) {
		CollectionDemo coll = new CollectionDemo();
		coll.A1 = coll.storeEvenNumbers(15);
		coll.A2 = coll.printEvenNumbers();
		System.out.println("Checking for 20 in arraylist A1:" + coll.retrieveEvenNumber(20));
		System.out.println("A1 :" + coll.A1);
		System.out.println("A2 :" + coll.A2);

	}
}
