package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RangeAndGradePage {
	WebDriver driver;
	public RangeAndGradePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id  ="mark_range_text_1")
	private WebElement range_Edt;

	@FindBy(id  ="mark_grade_text_1")
	private WebElement grade_Edt;
	
	@FindBy(xpath = "//button[@id='btnSubmit1' and text()='Submit']")
	private WebElement rangeSubmit_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRange_Edt() {
		return range_Edt;
	}

	public WebElement getGrade_Edt() {
		return grade_Edt;
	}

	public WebElement getRangeSubmit_Btn() {
		return rangeSubmit_Btn;
	}
	


}
