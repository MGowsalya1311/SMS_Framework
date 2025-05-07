package com.tp.sms;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tp.sms.ObjectRepository.ClassroomPage;
import com.tp.sms.ObjectRepository.EditClassroomPage;
import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;
import com.tp.sms.generic.BaseClassTest.BaseClass;



//@Listeners(com.tp.sms.generic.ListenerUtility.ListenerImplementation.class)

public class Std_ClassroomTest extends BaseClass {

	String className,studCount = null;
	
	@Test
	public  void createNewClassroomTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 

		//login to application 
		lp.login(un, pswd);
		HomePage hp = new HomePage(driver);
		hp.getClassroom_link().click();

		Thread.sleep(3000);

		className = eLib.getDataFromExcelFile("classroom", 1, 2)+ jLib.getRandomNumber();
		studCount = eLib.getDataFromExcelFile("classroom", 1, 3);
		ClassroomPage clsPage = new ClassroomPage(driver);
		clsPage.createClassroom(className, studCount);

		verifyingHeader(clsPage.getConfirmation_text(),"Success");
//		boolean b = clsPage.getConfirmation_text().getText().contains("Success");
//		SoftAssert sa = new  SoftAssert();
//		sa.assertTrue(b);
//		sa.assertAll();

		Reporter.log(className+" classroom created successfully",true);
		clsPage.getConfirmationClose_btn().click();
		Thread.sleep(4000);
		
	}

	@Test
	public void editClassroomTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		String un=fLib.getDataFromPropertyFile("admin_user");
		String pswd =fLib.getDataFromPropertyFile("password"); 

		//login to application 
		lp.login(un, pswd);
		HomePage hp = new HomePage(driver);
		hp.getClassroom_link().click();

		Thread.sleep(3000);


		className = eLib.getDataFromExcelFile("classroom", 1, 2)+ jLib.getRandomNumber();
		studCount = eLib.getDataFromExcelFile("classroom", 1, 3);
		ClassroomPage clsPage = new ClassroomPage(driver);
		clsPage.createClassroom(className, studCount);

		boolean b = clsPage.getConfirmation_text().getText().contains("Success");
		SoftAssert sa = new  SoftAssert();
		sa.assertTrue(b);
		sa.assertAll();

		Reporter.log(className+" classroom created successfully",true);

		clsPage.getConfirmationClose_btn().click();clsPage.getSearch_Edt().sendKeys(className);
		clsPage.getEdit_Btn().click();

		EditClassroomPage editClsPage = new EditClassroomPage(driver);
		className = eLib.getDataFromExcelFile("classroom", 1, 2)+ jLib.getRandomNumber();

		editClsPage.editClassroomDetails(className, studCount);
		
		editClsPage.getUpdate_Btn().click();
		
		Thread.sleep(2000);
		boolean b1 = clsPage.getConfirmation_text().getText().contains("Success");
		Assert.assertTrue(b1);
	
	//	System.out.println(editClsPage.getUpdate_Btn().getText());
	//	Thread.sleep(5000);
		
		//System.out.println(driver.findElement(By.xpath("//button[@id='btnSubmit1']")).getText());
		//driver.findElement(By.xpath("//button[@id='btnSubmit1']")).click();
		//Reporter.log(className+" classroom updated successfully",true);
	
		Thread.sleep(3000);
	}
}
