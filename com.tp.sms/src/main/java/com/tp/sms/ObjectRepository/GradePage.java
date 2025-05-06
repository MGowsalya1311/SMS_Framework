package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GradePage {
	WebDriver driver;
	public GradePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "name")
	private WebElement gradeName_Edt;
	
	@FindBy(id = "admission_fee")
	private WebElement admissionFee_Edt;
	
	@FindBy(id="hall_charge")
	private WebElement hallCharge_Edt;
	
	@FindBy(id="btnSubmit")
	private WebElement gradeNext_Btn;
	
	@FindBy(xpath = "//h3[text()='Add eMarks Range & Grade']")
	private WebElement addRangeGrade_popup;
	
	@FindBy(id="mark_range_text_1")
	private WebElement range_Edt;
	
	
	@FindBy(id="mark_grade_text_1")
	private WebElement grade_Edt;

	@FindBy(xpath = "//a[@onclick='addNewRow(this)']")
	private WebElement add_Btn;
	
	@FindBy(xpath = "//a[@onclick='deleteRow(this)']")
	private WebElement delete_Btn;
	
	@FindBy(id="btnSubmit1")
	private WebElement popupSubmit_Btn;
	
	@FindBy(xpath = "//strong[text()='Success!']")
	private WebElement successMessage_text;
	public WebElement getSuccessMessage_text() {
		return successMessage_text;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getGradeName_Edt() {
		return gradeName_Edt;
	}

	public WebElement getAdmissionFee_Edt() {
		return admissionFee_Edt;
	}

	public WebElement getHallCharge_Edt() {
		return hallCharge_Edt;
	}

	public WebElement getGradeNext_Btn() {
		return gradeNext_Btn;
	}

	public WebElement getAddRangeGrade_popup() {
		return addRangeGrade_popup;
	}

	public WebElement getRange_Edt() {
		return range_Edt;
	}

	public WebElement getGrade_Edt() {
		return grade_Edt;
	}

	public WebElement getAdd_Btn() {
		return add_Btn;
	}

	public WebElement getDelete_Btn() {
		return delete_Btn;
	}

	public WebElement getPopupSubmit_Btn() {
		return popupSubmit_Btn;
	}
}
