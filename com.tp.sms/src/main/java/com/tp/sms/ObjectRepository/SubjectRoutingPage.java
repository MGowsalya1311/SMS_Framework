package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectRoutingPage {
	WebDriver driver;
	public SubjectRoutingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(partialLinkText = "Add")
	private WebElement subjectRoutingAdd_Btn;
	
	@FindBy(id="grade")
	private WebElement grade_dropdown;

	@FindBy(id="subject")
	private WebElement subject_dropdown;

	@FindBy(id="teacher")
	private WebElement teacher_dropdown;
	@FindBy(id="fee")
	private WebElement fee_Edt;
	@FindBy(id="btnSubmit")
	private WebElement subjectRoutingSubmit_Btn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSubjectRoutingAdd_Btn() {
		return subjectRoutingAdd_Btn;
	}
	public WebElement getGrade_dropdown() {
		return grade_dropdown;
	}
	public WebElement getSubject_dropdown() {
		return subject_dropdown;
	}
	public WebElement getTeacher_dropdown() {
		return teacher_dropdown;
	}
	public WebElement getFee_Edt() {
		return fee_Edt;
	}
	public WebElement getSubjectRoutingSubmit_Btn() {
		return subjectRoutingSubmit_Btn;
	}
	
	

}
