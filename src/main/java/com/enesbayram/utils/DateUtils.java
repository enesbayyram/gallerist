package com.enesbayram.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

	public static void main(String[] args) {
		System.out.println(getCurrentDateddMMYYYY(new Date()));
	}
	
	public static String getCurrentDateddMMYYYY(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(date);
	}
}
