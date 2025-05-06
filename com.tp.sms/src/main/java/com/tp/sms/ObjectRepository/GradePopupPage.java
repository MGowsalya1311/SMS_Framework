package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GradePopupPage {
	WebDriver driver;
	public GradePopupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id ="grade")
	private WebElement grade_dropdown;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getGrade_dropdown() {
		return grade_dropdown;
	}

}
