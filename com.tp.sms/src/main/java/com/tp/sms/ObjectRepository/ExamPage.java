package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamPage {
	WebDriver driver;
	public ExamPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(partialLinkText = "Add")
	private WebElement add_Btn;
	
	@FindBy(id="name")
	private WebElement examName_Edt;
	
	@FindBy(id="btnSubmit")
	private WebElement examSubmit_btn;
	
	@FindBy(xpath = "//div[@id='insert_Success']/descendant::div[@class='modal-body bgColorWhite']")
	private WebElement confMessage_text;
	public WebElement getConfMessage_text() {
		return confMessage_text;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdd_Btn() {
		return add_Btn;
	}

	public WebElement getExamName_Edt() {
		return examName_Edt;
	}

	public WebElement getExamSubmit_btn() {
		return examSubmit_btn;
	}
	
	

}
