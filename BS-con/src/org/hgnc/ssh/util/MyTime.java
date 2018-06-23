package org.hgnc.ssh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {
	
	public static String SimpleTimeOne(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(date);
		return d;
	}
	
	public static String SimpleTimeTwo(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		return d;
	}
}
