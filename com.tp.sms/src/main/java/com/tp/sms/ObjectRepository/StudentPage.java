package com.tp.sms.ObjectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tp.sms.generic.FileUtility.ExcelUtility;
import com.tp.sms.generic.FileUtility.FileUtility;
import com.tp.sms.generic.WebDriverUtility.JavaUtility;
import com.tp.sms.generic.WebDriverUtility.WebDriverUtility;

public class StudentPage {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	public StudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	//student details
	@FindBy(id ="index_number")
	private WebElement stdIndexnumber_Edt;
	@FindBy(id ="full_name")
	private WebElement stdFullname_Edt;
	@FindBy(id="i_name")
	private WebElement stdNameWithInitials_Edt;
	@FindBy(id="address")
	private WebElement stdAddress_Edt;
	@FindBy(id="email")
	private WebElement stdEmail_Edt;
	@FindBy(id="phone")
	private WebElement stdPhone_Edt;
	@FindBy(id="b_date")
	private WebElement stdDOB_Edt;
	@FindBy(id="gender")
	private WebElement stdGender_dropdown;
	@FindBy(id="fileToUpload")
	private WebElement stdChoosePhoto_Btn;
	
	//guardian details
	@FindBy(id="g_index")
	private WebElement guardianIndexNumber_Edt;
	@FindBy(id ="g_full_name")
	private WebElement guardianFullname_Edt;
		@FindBy(id="g_i_name")
	private WebElement guardianNameWithInitials_Edt;
	
	@FindBy(id="g_address")
	private WebElement guardianAddress_Edt;
	@FindBy(id="g_email")
	private WebElement guardianEmail_Edt;
	@FindBy(id="g_phone")
	private WebElement guardianPhone_Edt;
	@FindBy(id="g_b_date")
	private WebElement guardianDOB_Edt;
	@FindBy(id="g_gender")
	private WebElement guardianGender_dropdown;
	@FindBy(id="g_fileToUpload")
	private WebElement guardianChoosePhoto_Btn;
	
	@FindBy(id="btnSubmit")
	private WebElement next_btn;
	
	
	
	
	public WebDriver getDriver() {
		return driver;
	}




	public WebElement getStdIndexnumber_Edt() {
		return stdIndexnumber_Edt;
	}




	public WebElement getStdFullname_Edt() {
		return stdFullname_Edt;
	}




	public WebElement getStdNameWithInitials_Edt() {
		return stdNameWithInitials_Edt;
	}




	public WebElement getStdAddress_Edt() {
		return stdAddress_Edt;
	}




	public WebElement getStdEmail_Edt() {
		return stdEmail_Edt;
	}




	public WebElement getStdPhone_Edt() {
		return stdPhone_Edt;
	}




	public WebElement getStdDOB_Edt() {
		return stdDOB_Edt;
	}




	public WebElement getStdGender_dropdown() {
		return stdGender_dropdown;
	}




	public WebElement getStdChoosePhoto_Btn() {
		return stdChoosePhoto_Btn;
	}




	public WebElement getGuardianIndexNumber_Edt() {
		return guardianIndexNumber_Edt;
	}




	public WebElement getGuardianFullname_Edt() {
		return guardianFullname_Edt;
	}




	public WebElement getGuardianNameWithInitials_Edt() {
		return guardianNameWithInitials_Edt;
	}




	public WebElement getGuardianAddress_Edt() {
		return guardianAddress_Edt;
	}




	public WebElement getGuardianEmail_Edt() {
		return guardianEmail_Edt;
	}




	public WebElement getGuardianPhone_Edt() {
		return guardianPhone_Edt;
	}




	public WebElement getGuardianDOB_Edt() {
		return guardianDOB_Edt;
	}




	public WebElement getGuardianGender_dropdown() {
		return guardianGender_dropdown;
	}




	public WebElement getGuardianChoosePhoto_Btn() {
		return guardianChoosePhoto_Btn;
	}




	public WebElement getNext_btn() {
		return next_btn;
	}




//	public void createStud() throws Throwable {
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		FileInputStream fis = new FileInputStream("./testData/sms_testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet s = wb.getSheet(sheetName);
//		int count = s.getLastRowNum();
//		for(int i=0;i<count;i++) {
//			int cellcount = s.getRow(i).getPhysicalNumberOfCells();
//					
//			for(int j=0;j<cellcount;j++) {
//
//				String data = eLib.getDataFromExcelFile(sheetName, rowNum, j);
//				//+jLib.getRandomNumber();
//				System.out.println(data);
//
//			}
//		}
//			}
	
	public void createStud(String sheetName,int rowNum) throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		StudentPage sp = new StudentPage(driver);
		
		String std_index_no = eLib.getDataFromExcelFile(sheetName, rowNum, 2)+ jLib.getRandomNumber();
		String std_fullname = eLib.getDataFromExcelFile(sheetName, rowNum, 3);
		String std_nameWithInitials = eLib.getDataFromExcelFile(sheetName, rowNum, 4);
		String std_address = eLib.getDataFromExcelFile(sheetName, rowNum, 5);
		
		//String std_email = eLib.getDataFromExcelFile(sheetName, rowNum, 6);
		
		String std_email = std_fullname + jLib.getRandomNumber() + "@gmail.com";
				
		String std_phone = eLib.getDataFromExcelFile(sheetName, rowNum, 7);

		String std_dob = eLib.getDataFromExcelFile(sheetName, rowNum, 8);
		String std_gender = eLib.getDataFromExcelFile(sheetName, rowNum, 9);
		String gua_fullname = eLib.getDataFromExcelFile(sheetName, rowNum, 10);
		String gua_nameWithInitials = eLib.getDataFromExcelFile(sheetName, rowNum, 11);
		String gua_address = eLib.getDataFromExcelFile(sheetName, rowNum, 12);
		//String gua_email = eLib.getDataFromExcelFile(sheetName, rowNum, 13);
		
		String gua_email = gua_fullname +jLib.getRandomNumber()+"@gmail.com";
		String gua_phone = eLib.getDataFromExcelFile(sheetName, rowNum, 14);
		String gua_dob = eLib.getDataFromExcelFile(sheetName, rowNum, 15);
		String gua_gender = eLib.getDataFromExcelFile(sheetName, rowNum, 16);

	
//	(String std_index_no,String std_fullname,String std_nameWithInitials,String std_address,String std_email,String std_phone,String std_dob,String std_gender,
//			String gua_fullname,String gua_nameWithInitials,String gua_address,String gua_email,String gua_phone,String gua_dob,String gua_gender) throws Throwable {
		getStdIndexnumber_Edt().sendKeys(std_index_no);
		getStdFullname_Edt().sendKeys(std_fullname);
		getStdNameWithInitials_Edt().sendKeys(std_nameWithInitials);
		getStdAddress_Edt().sendKeys(std_address);
		getStdEmail_Edt().sendKeys(std_email);
		getStdPhone_Edt().sendKeys(std_phone);
		getStdDOB_Edt().sendKeys(std_dob);
		getStdGender_dropdown().sendKeys(std_gender);
		
		
		File file = new File("src/test/resources/student.jpg");
		getStdChoosePhoto_Btn().sendKeys(file.getAbsolutePath());
		
		//getStdChoosePhoto_Btn().sendKeys("C:\\Users\\mailm\\git\\repository4\\com.tp.sms\\resources\\student.jpg");
/*		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='block';", getStdChoosePhoto_Btn());

		getStdChoosePhoto_Btn().sendKeys("C:\\Users\\mailm\\git\\repository4\\com.tp.sms\\resources\\student.jpg");
		*/
		
		//guardian details
		getGuardianFullname_Edt().sendKeys(gua_fullname);
		getGuardianNameWithInitials_Edt().sendKeys(gua_nameWithInitials);
		getGuardianAddress_Edt().sendKeys(gua_address);
		getGuardianEmail_Edt().sendKeys(gua_email);
		getGuardianPhone_Edt().sendKeys(gua_phone);
		getGuardianDOB_Edt().sendKeys(gua_dob);
		getGuardianGender_dropdown().sendKeys(gua_gender);
		File file1 = new File("src/test/resources/teacher.jpg");
		getGuardianChoosePhoto_Btn().sendKeys(file1.getAbsolutePath());

		
		getGuardianChoosePhoto_Btn().sendKeys(file1.getAbsolutePath());
		
		wLib.toScrollIntoView(driver, getNext_btn());
		getNext_btn().click();

			}
	
}
