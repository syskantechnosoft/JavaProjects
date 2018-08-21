package com.uhg.handson;

public class InheritanceActivity {

	public static void main(String[] args) {
		Manager mgr = new Manager(126534, "Peter", "Chennai India", 237844, 65000);
		mgr.calculateSalary();
		mgr.calculateTransportAllowance();
		Trainee trainee = new Trainee(29846, "Jack", "Mumbai India", 442085, 45000);
		trainee.calculateSalary();
		trainee.calculateTransportAllowance();
	}

}
