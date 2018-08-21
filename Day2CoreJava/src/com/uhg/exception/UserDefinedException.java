package com.uhg.exception;

public class UserDefinedException extends Exception {
	String message = "New User Defined Exception";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}
}
