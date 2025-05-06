package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherProfileStudentPage {
	WebDriver driver;
	public TeacherProfileStudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "grade")
	private WebElement grade_dropdown;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit_Btn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search_Edt;
	
	@FindBy(linkText = "Leave")
	private WebElement leave_Btn;

}
