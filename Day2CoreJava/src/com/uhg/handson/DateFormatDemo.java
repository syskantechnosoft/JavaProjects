package com.uhg.handson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatDemo {
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.toString());
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yy h:mm a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("h:mm:ss a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("MMM dd,yyyy h:mm:ss a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("h:mm a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("h:mm:ss a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("h:mm:ss a z");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("dd/MM/yy h:mm a ");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("MMM dd yyyy h:mm a");
		System.out.println(form.format(dt).toString());
		form = new SimpleDateFormat("MMMM dd, yyyy h:mm:ss a z");
		System.out.println(form.format(dt).toString());

		Calendar cl = Calendar.getInstance();
		System.out.println("Default Timezone :" + TimeZone.getDefault());
		System.out.println("Indian Time :" + cl.getTime());
		// TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");
		TimeZone.setDefault(TimeZone.getTimeZone("Canada/Pacific"));
		System.out.println("Canada Time :" + cl.getTime());
		System.out.println("Canda Timezone :" + TimeZone.getTimeZone("Canada/Pacific"));

	}
}
