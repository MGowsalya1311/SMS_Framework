package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectSelectionPage {
	WebDriver driver;
	public SubjectSelectionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//td[text() = 'Subject 5.0']/..//input[@id='checkbox']")
	private WebElement subject_checkbox;
	
	@FindBy(xpath = "//button[@id='btnSubmit1']")
	private WebElement subjectSubmit_Btn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSubject_checkbox() {
		return subject_checkbox;
	}
	public WebElement getSubjectSubmit_Btn() {
		return subjectSubmit_Btn;
	}


}
