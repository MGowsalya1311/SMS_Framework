package com.tp.sms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;
import com.tp.sms.generic.FileUtility.FileUtility;

public class Sample_StudentTest extends BaseClass{
	
	
	@Test(dataProvider = "getCredentials")
    public void testLogin(String username, String password) {
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		
    }
	@DataProvider
	public Object[][] getCredentials() throws Throwable{
		FileUtility fLib = new FileUtility();
		Object[][] obj = new Object[1][2];
		obj[0][0] = fLib.getDataFromPropertyFile("student_user");
		obj[0][1] = fLib.getDataFromPropertyFile("password");
		
				return obj;
	}

	
}
