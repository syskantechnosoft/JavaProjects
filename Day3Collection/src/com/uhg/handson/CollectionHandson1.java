package com.uhg.handson;

import java.util.HashSet;

public class CollectionHandson1 {
	HashSet<String> H1 = new HashSet<>();

	public HashSet<String> storeCountryNames(String CountryName) {
		this.H1.add(CountryName);
		return H1;
	}

	public String retrieveCountry(String CountryName) {
		if (this.H1.contains(CountryName)) {
			return CountryName;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		CollectionHandson1 coll = new CollectionHandson1();
		coll.storeCountryNames("India");
		coll.storeCountryNames("China");
		coll.storeCountryNames("Japan");
		coll.storeCountryNames("SriLanka");

		System.out.println(coll.retrieveCountry("India"));

	}

}
