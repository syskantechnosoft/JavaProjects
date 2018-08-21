package com.uhg.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add("india");
		arraylist.add("america");
		arraylist.add("srilanka");
		arraylist.add("pakistan");
		// arraylist.add(null);
		arraylist.add("bangladesh");
		arraylist.add("nepal");
		arraylist.add("china");
		arraylist.add("japan");
		// arraylist.add(null);
		System.out.println("Arraylist content :" + arraylist);
		System.out.println("Element at index 4 : " + arraylist.get(4));
		System.out.println("Size of arraylist :" + arraylist.size());

		Collections.sort(arraylist);

		// Using Enhanced for loop (Foreach loop)
		for (Object str : arraylist) {
			if (str != null)
				System.out.println(str.toString().toLowerCase());
		}

		// Traversing Arratlist using Iterator
		Iterator iterator = arraylist.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString().toUpperCase());
		}

		LinkedList linkedlist = new LinkedList();
		linkedlist.add(1);
		linkedlist.add(5);
		linkedlist.add(1);
		linkedlist.add(5);
		linkedlist.add(null);
		linkedlist.add(8);
		linkedlist.add(6);
		linkedlist.add(9);
		linkedlist.add(7);
		linkedlist.add(null);
		System.out.println("Arraylist content :" + linkedlist);
		System.out.println("Element at index 4 : " + linkedlist.get(4));
		System.out.println("Size of arraylist :" + linkedlist.size());

		arraylist.addAll(linkedlist);
		arraylist.clear();
		System.out.println("Arraylist size :" + arraylist.size());
	}

}
