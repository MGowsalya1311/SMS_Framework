package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="email")
	private WebElement email_Edt;
	@FindBy(id="password")
	private WebElement password_Edt;
	@FindBy(id="btnSubmit")
	private WebElement Login_Btn;
	
	//getters
	public WebElement getEmail_Edt() {
		return email_Edt;
	}
	public WebElement getPassword_Edt() {
		return password_Edt;
	}
	public WebElement getLogin_Btn() {
		return Login_Btn;
	}
	public void login(String username,String password) {
		email_Edt.sendKeys(username);
		password_Edt.sendKeys(password);
		Login_Btn.click();
		Reporter.log("Logged in successfully",true);
	}
	

}
