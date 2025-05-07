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

public class ExamTest extends BaseClass{
	@Test(retryAnalyzer = com.tp.sms.generic.ListenerUtility.RetryListenerImplementation.class)
	public void createExamTest() throws Throwable {
		
		String text = "Success";
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);
		
		HomePage hp = new HomePage(driver);
		//hp.getExam_link().click();
		//hp.getCreateExam_link().click();
		
		hp.navigateToCreateExamPage();
		
		
		ExamPage ep = new ExamPage(driver);
		ep.createExam();
		/*ep.getAdd_Btn().click();
		String examName = eLib.getDataFromExcelFile("exam", 1, 2)+jLib.getRandomNumber();
		ep.getExamName_Edt().sendKeys(examName);
		ep.getExamSubmit_btn().click();*/
		
		verifyingHeader(ep.getConfMessage_text(), text);
		//boolean flag = ep.getConfMessage_text().getText().contains("Success");
		//Assert.assertTrue(flag);
		//Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ep.getConfMessage_text()));

	
		
	}

}
