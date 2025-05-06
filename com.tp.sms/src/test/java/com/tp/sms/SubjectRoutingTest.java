package com.tp.sms;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tp.sms.ObjectRepository.GradePage;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.ObjectRepository.RangeAndGradePage;
import com.tp.sms.ObjectRepository.SubjectPage;
import com.tp.sms.ObjectRepository.SubjectRoutingPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;

public class SubjectRoutingTest extends BaseClass {

	@Test
	public void createGradeTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);

		HomePage hp = new HomePage(driver);
		hp.getGrade_link().click();

		Thread.sleep(3000);
		GradePage gp = new GradePage(driver);

		String grade = eLib.getDataFromExcelFile("grade", 1, 2)+jLib.getRandomNumber();
		gp.getGradeName_Edt().sendKeys(grade);
		gp.getAdmissionFee_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 3));
		gp.getHallCharge_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 4));
		gp.getGradeNext_Btn().click();

		Thread.sleep(5000);

		RangeAndGradePage rangeGradePage = new RangeAndGradePage(driver);
		rangeGradePage.getRange_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 5));
		rangeGradePage.getGrade_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 6));
		rangeGradePage.getRangeSubmit_Btn().click();

		Reporter.log("Grade created successfully",true);
		verifyingHeader(hp.getConfMessage_text(),"Success");

		//	Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(hp.getConfMessage_text()));


	}

	@Test
	public void verifyGradeInSubjectRoutingTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);

		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		hp.getGrade_link().click();

		GradePage gp = new GradePage(driver);
		String grade = eLib.getDataFromExcelFile("grade", 1, 2)+jLib.getRandomNumber();
		gp.getGradeName_Edt().sendKeys(grade);
		gp.getAdmissionFee_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 3));
		gp.getHallCharge_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 4));
		gp.getGradeNext_Btn().click();

		Thread.sleep(5000);

		RangeAndGradePage rangeGradePage = new RangeAndGradePage(driver);
		rangeGradePage.getRange_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 5));
		rangeGradePage.getGrade_Edt().sendKeys(eLib.getDataFromExcelFile("grade", 1, 6));
		rangeGradePage.getRangeSubmit_Btn().click();

		Reporter.log("Grade created successfully",true);
	//	verifyingText(hp.getConfMessage_text().getText());
		//verifyingTextfield(hp.getConfMessage_text(),"Success");
		verifyingHeader(hp.getConfMessage_text(),"Success");
		
		Thread.sleep(4000);


		hp.getSubject_link().click();

		String sub = eLib.getDataFromExcelFile("subject", 1, 2)+jLib.getRandomNumber();
		SubjectPage subPage = new SubjectPage(driver);
		subPage.getSubjectName_Edt().sendKeys(sub);
		subPage.getSubjectSubmit_Btn().click();
		
		Thread.sleep(4000);


		hp.getSubjectRouting_link().click();

		SubjectRoutingPage subRoutingPage = new SubjectRoutingPage(driver);

		subRoutingPage.getSubjectRoutingAdd_Btn().click();

		String teacher = "Teacher 3";

		wLib.selectByVisibleTextDropDown(subRoutingPage.getGrade_dropdown(), grade);
		wLib.selectByVisibleTextDropDown(subRoutingPage.getSubject_dropdown(), sub);
		wLib.selectByVisibleTextDropDown(subRoutingPage.getTeacher_dropdown(), teacher);

		subRoutingPage.getFee_Edt().sendKeys("1200");
		subRoutingPage.getSubjectRoutingSubmit_Btn().click();

		Reporter.log("Subject Routing created successfully",true);
		verifyingHeader(hp.getConfMessage_text(),"Success");
	//Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(hp.getConfMessage_text()));


Thread.sleep(3000);

	}

}
