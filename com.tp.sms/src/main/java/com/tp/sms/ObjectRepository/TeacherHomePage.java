package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherHomePage {
	
	WebDriver driver;
	public TeacherHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//span[text()='My Student']")
	private WebElement myStudent_Link;
	
	@FindBy(xpath = "//span[text()='Attendance']")
	private WebElement Attendance_link;
	
	@FindBy(partialLinkText = "My Attendance")
	private WebElement myAttendance_link;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMyStudent_Link() {
		return myStudent_Link;
	}

	public WebElement getAttendance_link() {
		return Attendance_link;
	}

	public WebElement getMyAttendance_link() {
		return myAttendance_link;
	}
	
	
	

}
