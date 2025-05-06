package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassroomPage {
	WebDriver driver;
	public ClassroomPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id ="name")
	private WebElement clsname_Edt;
	
	
	@FindBy(id ="student_count")
	private WebElement studentcount_Edt;
	@FindBy(id = "btnSubmit")
	private WebElement submit_Btn;
	
	@FindBy(xpath = "//label[text()='Search:']")
	private WebElement search_Edt;
	
	@FindBy(linkText = "Edit")
	private WebElement edit_Btn;
	@FindBy(xpath = "//div[@id='insert_Success']/descendant::div[@class='modal-body bgColorWhite']")
	private WebElement confirmation_text;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-remove']")
	private WebElement confirmationClose_btn;
	public WebElement getConfirmationClose_btn() {
		return confirmationClose_btn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getConfirmation_text() {
		return confirmation_text;
	}

	public WebElement getEdit_Btn() {
		return edit_Btn;
	}

	public WebElement getClsname_Edt() {
		return clsname_Edt;
	}

	public WebElement getStudentcount_Edt() {
		return studentcount_Edt;
	}

	public WebElement getSubmit_Btn() {
		return submit_Btn;
	}

	public WebElement getSearch_Edt() {
		return search_Edt;
	}
	
	public void createClassroom(String className,String studCount) {
		getClsname_Edt().sendKeys(className);
		getStudentcount_Edt().sendKeys(studCount);
		getSubmit_Btn().click();
		
	}
	
	
}
