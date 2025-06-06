package com.tp.sms.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaUtility {
	
	public int getRandomNumber() {
	Random random = new Random();
	int rand_number = random.nextInt(1000);

	return rand_number;
	}
	
	public String getSystemDate() {
		//get system date in yyyy-MM-dd format
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		String actDate = sdf.format(dateObj);
		return actDate;

	}
	
	public String getRequiredDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 60);
		String date_req = sdf.format(cal.getTime());

		System.out.println("date_req:"+date_req);
		return date_req;
				
	}
	public WebDriver selectBrowser(WebDriver driver,String Browser) {
		if(Browser.equals("chrome")) {
			 driver = new ChromeDriver();
		}
		else if(Browser.equals("edge")) {
			 driver = new EdgeDriver();
		}
		else if(Browser.equals("firefox")) {
			 driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		return driver;
	}
}
