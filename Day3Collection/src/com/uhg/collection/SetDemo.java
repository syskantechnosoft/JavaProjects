package com.uhg.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet();
		hashset.add("india");
		hashset.add("america");
		hashset.add("srilanka");
		hashset.add("pakistan");
		// hashset.add(null);
		hashset.add("bangladesh");
		hashset.add("nepal");
		hashset.add("china");
		hashset.add("japan");
		hashset.add("nepal");
		hashset.add("china");
		hashset.add("japan");
		// hashset.add(null);
		System.out.println("Arraylist content :" + hashset);
		System.out.println("Size of arraylist :" + hashset.size());

		
		
		// Using Enhanced for loop (Foreach loop)
		for (String str : hashset) {
			if (str != null)
				System.out.println(str.toLowerCase());
		}

		// Traversing Arratlist using Iterator
		Iterator iterator = hashset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString().toUpperCase());
		}
		
		

		TreeSet linkedlist = new TreeSet();
		linkedlist.add(1);
		linkedlist.add(5);
		linkedlist.add(1);
		linkedlist.add(5);
		//linkedlist.add(null);
		linkedlist.add(8);
		linkedlist.add(6);
		linkedlist.add(9);
		linkedlist.add(7);
		//linkedlist.add(null);
		System.out.println("Arraylist content :" + linkedlist);
		System.out.println("Size of arraylist :" + linkedlist.size());

		hashset.addAll(linkedlist);
		hashset.clear();
		System.out.println("Arraylist size :" + hashset.size());

	}

}
