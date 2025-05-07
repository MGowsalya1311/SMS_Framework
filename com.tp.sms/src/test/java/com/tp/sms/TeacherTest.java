package com.tp.sms;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tp.sms.ObjectRepository.AttendancePage;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.ObjectRepository.TeacherHomePage;
import com.tp.sms.generic.BaseClassTest.BaseClass;
import com.tp.sms.generic.FileUtility.FileUtility;
/**
 * 
 * @author gowsalya
 * Teacher  module
 * Test script 1: verifying teacher login
 * Test script 2: view attendance
 * 
 */
public class TeacherTest extends BaseClass{
	@Test
	public void testLogin() throws Throwable {

	
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("teacher_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);

		String text = "Teacher 1 ABC";

		HomePage hp = new HomePage(driver);
		String actualText = hp.getUserName_Txt().getText();

		Assert.assertEquals(actualText, text);
		Reporter.log(actualText+" is verified",true);
	}

	@Test
	public void viewAttendance() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("teacher_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);

		String text = "Teacher 1 ABC";

		HomePage hp = new HomePage(driver);
		String actualText = hp.getUserName_Txt().getText();
		Assert.assertEquals(actualText, text);
		Reporter.log(actualText+" is verified",true);
		
		TeacherHomePage teacherHomePage = new TeacherHomePage(driver);
		teacherHomePage.getAttendance_link().click();
		teacherHomePage.getMyAttendance_link().click();
		
		AttendancePage ap = new AttendancePage(driver);
		boolean b = ap.getAttendancePageTitle_text().getText().contains("Attendance");
		SoftAssert sa = new  SoftAssert();
		sa.assertTrue(b);
		sa.assertAll();

		Reporter.log("Attendance page is verified",true);

		
		
		

	}
}
