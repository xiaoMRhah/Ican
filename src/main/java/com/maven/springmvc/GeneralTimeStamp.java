package com.maven.springmvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralTimeStamp {
	//将时间转换为10位数的时间戳
	public String timeStamp(String s) throws ParseException{
		String res;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(s);
		long ts=date.getTime();
		res=String.valueOf(ts);
		return res;
	}
}
