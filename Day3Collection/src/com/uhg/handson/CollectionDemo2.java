package com.uhg.handson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("all")
public class CollectionDemo2 {

	HashMap<String, String> countryMap = new HashMap();

	public HashMap<String, String> storeCountryCapital(String CountryName, String capital) {
		this.countryMap.put(CountryName, capital);
		return countryMap;
	}

	public String retrieveCapital(String CountryName) {
		return countryMap.get(CountryName);
	}

	public String retrieveCountry(String capitalName) {
		Set<String> countries = countryMap.keySet();
		String countryName = "";
		for (String country : countries) {
			String capital = countryMap.get(country);
			if (capital.equalsIgnoreCase(capitalName))
				countryName = country;
		}
		return countryName;
	}

	public HashMap<String, String> interchange() {
		HashMap<String, String> m2 = new HashMap<>();
		Set<String> countries = countryMap.keySet();
		for (String country : countries) {
			String capital = countryMap.get(country);
			m2.put(capital, country);
		}
		return m2;
	}

	public ArrayList<String> getArrayList() {
		ArrayList<String> al = new ArrayList<>();
		Set<String> countries = countryMap.keySet();
		for (String country : countries) {
			al.add(country);
		}
		return al;
	}

	public static void main(String[] args) {
		CollectionDemo2 coll = new CollectionDemo2();
		coll.storeCountryCapital("India", "Delhi");
		coll.storeCountryCapital("Japan", "Tokyo");
		System.out.println("CountryMap :" + coll.countryMap);
		System.out.println("Capital of India :" + coll.retrieveCapital("India"));
		System.out.println("Capital of Japan :" + coll.retrieveCapital("Japan"));
		System.out.println("Tokyo is Capital of :" + coll.retrieveCountry("Tokyo"));
		System.out.println("Delhi is Capital of :" + coll.retrieveCountry("Delhi"));
		System.out.println("Map Interchange :" + coll.interchange());
		System.out.println("Country ArrayList :" + coll.getArrayList());
	}

}
