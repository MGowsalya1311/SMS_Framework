package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	WebDriver driver;
	public InvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath = "//button[@id='btnSubmit1' and @class='btn btn-primary btn-md']")
	private WebElement paid_Btn;
	
	
	@FindBy(xpath = "//span[text()='Print']")
	private WebElement print_Btn;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancel_Btn;
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getPaid_Btn() {
		return paid_Btn;
	}


	public WebElement getPrint_Btn() {
		return print_Btn;
	}


	public WebElement getCancel_Btn() {
		return cancel_Btn;
	}
	

}
