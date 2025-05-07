package com.tp.sms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.ObjectRepository.SubjectPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;

public class SubjectTest extends BaseClass{
	
	@Test
	public void createSubjectTest() throws Throwable {
		String text = "Success";
		
		LoginPage lp = new LoginPage(driver);
		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 
		lp.login(un,pswd);
		
		HomePage hp = new HomePage(driver);
		hp.getSubject_link().click();
		
		
		SubjectPage subPage = new SubjectPage(driver);
		subPage.createSubject();
		/*String sub = eLib.getDataFromExcelFile("subject", 1, 2)+jLib.getRandomNumber();
		subPage.getSubjectName_Edt().sendKeys(sub);
		subPage.getSubjectSubmit_Btn().click();
		Reporter.log("Subject created successfully",true);*/
		//verifyingText(hp.getConfMessage_text().getText());
		
		verifyingHeader(hp.getConfMessage_text(),text);

		//Thread.sleep(5000);
		WebElement element = hp.getConfMessage_text();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='insert_Success']/descendant::div[@class='modal-body bgColorWhite']")));
		wait.until(ExpectedConditions.invisibilityOf(element));

		
	}

}
