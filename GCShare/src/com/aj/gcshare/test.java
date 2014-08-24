package com.aj.gcshare;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYY");
		Date date = new Date();
		System.out.println(dateFormat.format(date));

	}

}
