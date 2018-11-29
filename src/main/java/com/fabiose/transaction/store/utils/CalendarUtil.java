package com.fabiose.transaction.store.utils;

import java.util.Calendar;

public class CalendarUtil {

public static String dateFormatted() {
		
		StringBuilder dateFormatted = new StringBuilder("");
		
		Calendar calendar = Calendar.getInstance();
		
		dateFormatted.append("[");
		dateFormatted.append(ConstantUtil.dayOfWeek.get(calendar.get(Calendar.DAY_OF_WEEK)));
		dateFormatted.append("  ");
		dateFormatted.append(calendar.get(Calendar.DATE));
		dateFormatted.append("  ");
		dateFormatted.append(ConstantUtil.monthOfYear.get(calendar.get(Calendar.MONTH)));
		dateFormatted.append(" ");
		dateFormatted.append(calendar.get(Calendar.YEAR));
		dateFormatted.append("] ");
		
		dateFormatted.append("[");
		int hour = calendar.get(Calendar.HOUR);
		if (hour < 10)
			dateFormatted.append("0".concat(String.valueOf(hour)));
		else
			dateFormatted.append(hour);
		
		dateFormatted.append(":");
		
		int minute = calendar.get(Calendar.MINUTE);
		if (minute < 10)
			dateFormatted.append("0".concat(String.valueOf(minute)));
		else
			dateFormatted.append(minute);
		
		dateFormatted.append(":");
		
		int second = calendar.get(Calendar.SECOND);
		if (second < 10)
			dateFormatted.append("0".concat(String.valueOf(second)));
		else
			dateFormatted.append(second);
		
		dateFormatted.append("] ");
		
		return dateFormatted.toString();
	}
	
}
