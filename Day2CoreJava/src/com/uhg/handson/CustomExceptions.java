package com.uhg.handson;

public class CustomExceptions {

}

class CountryNotValidException extends Exception {
	@Override
	public String getMessage() {
		return "The employee should be an Indian citizen for calculating tax";
	}
}

class EmployeeNameInvalidException extends Exception {
	@Override
	public String getMessage() {
		return "The employee name cannot be empty";
	}
}

class TaxNotEligibleException extends Exception {
	@Override
	public String getMessage() {
		return "The employee does not need to pay tax";
	}
}