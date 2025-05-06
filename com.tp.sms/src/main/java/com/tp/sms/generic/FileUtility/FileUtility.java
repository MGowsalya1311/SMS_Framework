package com.tp.sms.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {


	public String getDataFromPropertyFile(String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./configAppData/SMScommonData.properties");
	Properties prop = new Properties();
	prop.load(fis);
	
	String data = prop.getProperty(key);
	return data;
	
	}
	
	
}
