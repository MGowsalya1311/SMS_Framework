package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditClassroomPage {
	WebDriver driver;
	public EditClassroomPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "name1")
	private WebElement clsName_Edt;
	
	@FindBy(id = "student_count1")
	private WebElement stdCount_Edt;
	

	@FindBy(xpath  ="//button[@id='btnSubmit1']")
	private WebElement update_Btn;
	
	@FindBy(xpath = "//div[@class='modal-body bgColorWhite']/../../../../../div/div[13]/div/div/div[2]")
	private WebElement warningMessage_text;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClsName_Edt() {
		return clsName_Edt;
	}

	public WebElement getStdCount_Edt() {
		return stdCount_Edt;
	}

	public WebElement getUpdate_Btn() {
		return update_Btn;
	}

	public WebElement getWarningMessage_text() {
		return warningMessage_text;
	}
	
	public void editClassroomDetails(String clsName,String studCount) throws InterruptedException
	{
		getClsName_Edt().clear();
		getClsName_Edt().sendKeys(clsName);
		getStdCount_Edt().clear();
		getStdCount_Edt().sendKeys(studCount);
		getUpdate_Btn().click();	
	}
}
