package com.tp.sms;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.ObjectRepository.MyProfilePage;
import com.tp.sms.generic.BaseClassTest.BaseClass;
import com.tp.sms.generic.FileUtility.FileUtility;
import com.tp.sms.generic.ListenerUtility.ListenerImplementation;


@Listeners(com.tp.sms.generic.ListenerUtility.ListenerImplementation.class)
public class AdminTest extends BaseClass{

	@Test
	public void verifyAdminProfileTest() throws Throwable {
		String expected_text ="My Profile Preview"; 
		FileUtility fLib = new FileUtility();
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);
		Thread.sleep(2000);
		ListenerImplementation.test.log(Status.INFO, "Logged in as Admin");
		
		HomePage hp = new HomePage(driver);
		hp.getMyProfile_link().click();
		
		ListenerImplementation.test.log(Status.INFO, "Admin Profile Navigation");
		//Assert.fail("failing admin access..");
		
		MyProfilePage myprofilePage = new MyProfilePage(driver);
		verifyingTextfield(myprofilePage.getMyProfile_text(), expected_text);
		Reporter.log("Navigated to Admin profile page successfully",true);

	}
}
