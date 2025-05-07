package com.tp.sms.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.tp.sms.generic.FileUtility.ExcelUtility;
import com.tp.sms.generic.WebDriverUtility.JavaUtility;

public class SubjectPage {
	WebDriver driver;
	public SubjectPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "name")
	private WebElement subjectName_Edt;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement subjectSubmit_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSubjectName_Edt() {
		return subjectName_Edt;
	}

	public WebElement getSubjectSubmit_Btn() {
		return subjectSubmit_Btn;
	}
	
	public void createSubject() throws IOException, Throwable {
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		String sub = eLib.getDataFromExcelFile("subject", 1, 2)+jLib.getRandomNumber();
		getSubjectName_Edt().sendKeys(sub);
		getSubjectSubmit_Btn().click();
		Reporter.log("Subject created successfully",true);
		
	}
	
}
