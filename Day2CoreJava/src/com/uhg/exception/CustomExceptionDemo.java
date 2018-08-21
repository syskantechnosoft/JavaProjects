package com.uhg.exception;

public class CustomExceptionDemo {
	enum months {
		Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
	};

	public enum MonthEnum {

		JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(
				10), NOVEMBER(11), DECEMBER(12);

		MonthEnum(int monthOfYear) {
			this.monthOfYear = monthOfYear;
		}

		private int monthOfYear;

		public int asMonthOfYear() {
			return monthOfYear;
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		months m = months.Apr;
		System.out.println(m.ordinal());
		int age = 120;
		if (age > 120) {
			throw new UserDefinedException();
		}
	}

}
