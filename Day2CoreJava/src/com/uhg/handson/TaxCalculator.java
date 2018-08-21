package com.uhg.handson;
public class TaxCalculator {
	public double calculateTax(String empName, boolean isIndian, double empSalary) throws Exception {
		double taxAmount = 0.0;
		if (!isIndian) {
			throw new CountryNotValidException();
		} else {
			if (empName.equals("") || empName == null) {
				throw new EmployeeNameInvalidException();
			} else {
				if (empSalary >= 100000) {
					taxAmount = empSalary * 8 / 100;
				} else if (empSalary >= 50000 && empSalary < 100000) {
					taxAmount = empSalary * 6 / 100;
				} else if (empSalary >= 30000 && empSalary < 50000) {
					taxAmount = empSalary * 5 / 100;
				} else if (empSalary >= 10000 && empSalary < 30000) {
					taxAmount = empSalary * 4 / 100;
				} else if (empSalary < 10000) {
					throw new TaxNotEligibleException();
				}
			}
		}
		return taxAmount;
	}
}
