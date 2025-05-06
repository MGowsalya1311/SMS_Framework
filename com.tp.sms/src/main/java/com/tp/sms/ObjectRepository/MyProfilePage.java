package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	WebDriver driver;
	public MyProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//student details
	@FindBy(xpath = "//h1[contains(text(),'My Profile')]")
	private WebElement myProfile_text;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMyProfile_text() {
		return myProfile_text;
	}

}
