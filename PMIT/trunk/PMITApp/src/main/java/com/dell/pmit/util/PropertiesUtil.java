package com.dell.pmit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getProperty(String string) {
		Properties prop = new Properties();
	    String propFileName = "messages.properties";
	    try {
	    	InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	   String value = prop.getProperty(string);
	   return value;
	}
	/*public static void main(String[] args) {
		PropertiesUtil.getProperty("mail.password");
	}
	*/

}
