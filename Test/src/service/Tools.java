package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	Date convert = null;

	public Date getDate(String data){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		try {
			convert = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convert;
	}
	
	public Date getTime(){
		
		convert = new Date();
		return convert;
	}
}
