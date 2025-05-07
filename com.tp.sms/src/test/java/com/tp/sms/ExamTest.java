package com.tp.sms;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tp.sms.ObjectRepository.ExamPage;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;
/**
 * 
 * @author Gowsalya
 * Exam module
 *  Test script :1 create exam
 * 
 *
 */
public class ExamTest extends BaseClass{
	@Test(retryAnalyzer = com.tp.sms.generic.ListenerUtility.RetryListenerImplementation.class)
	public void createExamTest() throws Throwable {
		
		String text = "Success";
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);
		
		HomePage hp = new HomePage(driver);
		hp.navigateToCreateExamPage();
		
		
		ExamPage ep = new ExamPage(driver);
		ep.createExam();
		
		verifyingHeader(ep.getConfMessage_text(), text);
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ep.getConfMessage_text()));

	
		
	}

}
