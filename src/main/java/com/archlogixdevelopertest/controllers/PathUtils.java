package com.archlogixdevelopertest.controllers;

public class PathUtils {
	
	public static String pathConverter(String path) {
		// Modify path if running on Windows machine
		path = path.replace('/', '\\');
		System.out.println(path);
		return path;
	}
	
	public static String getStartDate(String path) {
		String startDate = path.substring(path.lastIndexOf(" ") + 1, path.lastIndexOf("-"));
		System.out.println(startDate);
		if(startDate.matches("\\d{8}")) {
			return startDate;
		}
		else return null;
	}
	
	public static String dateParser(String date, String ymd) {
		String value = null;
		if(ymd.equalsIgnoreCase("year")) {
			value = date.substring(0, 4);
		}
		if(ymd.equalsIgnoreCase("month")) {
			value = date.substring(4, 6);
		}
		if(ymd.equalsIgnoreCase("day")) {
			value = date.substring(6, 8);
		}
		return value;
	}

}
