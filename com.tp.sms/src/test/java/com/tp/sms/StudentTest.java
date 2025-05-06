package com.tp.sms;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tp.sms.ObjectRepository.GradePopupPage;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.InvoicePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.ObjectRepository.StudentPage;
import com.tp.sms.ObjectRepository.SubjectSelectionPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;
import com.tp.sms.generic.FileUtility.ExcelUtility;
import com.tp.sms.generic.FileUtility.FileUtility;
import com.tp.sms.generic.WebDriverUtility.JavaUtility;
import com.tp.sms.generic.WebDriverUtility.WebDriverUtility;

public class StudentTest  extends BaseClass{

	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();


	@Test
	public void createStudentTest() throws Throwable {        

		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);

		HomePage hp = new HomePage(driver);
		hp.getStudent_link().click();
		hp.getAddStudent_link().click();

		StudentPage sp = new StudentPage(driver);
		sp.createStud("student",1);

		GradePopupPage gradepopupPage = new GradePopupPage(driver);
		wLib.selectByVisibleTextDropDown(gradepopupPage.getGrade_dropdown(), "Grade 3");

		Thread.sleep(3000);
		SubjectSelectionPage subSelectPage = new SubjectSelectionPage(driver);
		subSelectPage.getSubject_checkbox().click();
		subSelectPage.getSubjectSubmit_Btn().click();

		Thread.sleep(3000);

		InvoicePage invoicePage = new InvoicePage(driver);
		wLib.toScrollIntoView(driver,invoicePage.getPaid_Btn());
		invoicePage.getPaid_Btn().click();


		Reporter.log("Student created successfully",true);

		Thread.sleep(4000);


	}

}
