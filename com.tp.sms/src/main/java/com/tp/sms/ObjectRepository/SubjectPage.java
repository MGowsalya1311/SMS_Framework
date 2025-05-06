package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
}
