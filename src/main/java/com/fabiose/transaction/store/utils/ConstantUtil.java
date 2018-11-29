package com.fabiose.transaction.store.utils;

import java.util.TreeMap;

public class ConstantUtil {

	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	public static final String SUNDAY = "Sunday";
	
	public static final String JANUARY = "January";
	public static final String FEBUARY = "Febuary";
	public static final String MARCH = "March";
	public static final String APRIL = "April";
	public static final String MAY = "May";
	public static final String JUNE = "June";
	public static final String JULY = "July";
	public static final String AUGUST = "August";
	public static final String SEPTEMBER = "September";	
	public static final String OCTOBER = "October";
	public static final String NOVEMBER = "November";
	public static final String DECEMBER = "December";
	
	public static final String STARTING_TRANSACTION = "Starting transaction ...";
	public static final String TRANSACTION_COMPLETED = "Transaction completed ...";
	public static final String TRANSACTION_ABORTED = "Transaction aborted ...";
	
	public static TreeMap<Integer,String> dayOfWeek = new TreeMap<Integer,String>();
	public static TreeMap<Integer,String> monthOfYear = new TreeMap<Integer,String>();
	
	static {
		dayOfWeek.put(1, SUNDAY);
		dayOfWeek.put(2, MONDAY);
		dayOfWeek.put(3, TUESDAY);
		dayOfWeek.put(4, WEDNESDAY);
		dayOfWeek.put(5, THURSDAY);
		dayOfWeek.put(6, FRIDAY);
		dayOfWeek.put(7, SATURDAY);
		
		monthOfYear.put(0, JANUARY);
		monthOfYear.put(1, FEBUARY);
		monthOfYear.put(2, MARCH);
		monthOfYear.put(3, APRIL);
		monthOfYear.put(4, MAY);
		monthOfYear.put(5, JUNE);
		monthOfYear.put(6, JULY);
		monthOfYear.put(7, AUGUST);
		monthOfYear.put(8, SEPTEMBER);
		monthOfYear.put(9, OCTOBER);
		monthOfYear.put(10, NOVEMBER);
		monthOfYear.put(11, DECEMBER);
	}
	
}
