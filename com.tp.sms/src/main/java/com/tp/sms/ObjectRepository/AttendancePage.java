package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendancePage {

	WebDriver driver;
	public AttendancePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Attendance')]")
	private WebElement attendancePageTitle_text;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAttendancePageTitle_text() {
		return attendancePageTitle_text;
	}
}
