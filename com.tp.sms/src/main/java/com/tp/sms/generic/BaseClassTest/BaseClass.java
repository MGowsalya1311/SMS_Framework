package com.tp.sms.generic.BaseClassTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.generic.FileUtility.ExcelUtility;
import com.tp.sms.generic.FileUtility.FileUtility;
import com.tp.sms.generic.WebDriverUtility.JavaUtility;
import com.tp.sms.generic.WebDriverUtility.UtilityClassObject;
import com.tp.sms.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	@Parameters("browser")
	@BeforeClass
	public void toLaunch(@Optional("edge")String bname) throws Throwable {
		
		/*ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("printing.print_preview_sticky_settings.appState",
		          "{\"recentDestinations\":[{\"id\":\"Save as PDF\",\"origin\":\"local\"}],\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--kiosk-printing"); // disables the print dialog
		
		WebDriver driver = new ChromeDriver(options);
		*/
		Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("printing.print_preview_sticky_settings.appState",
            "{\"recentDestinations\":[{\"id\":\"Save as PDF\",\"origin\":\"local\"}],"
            + "\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");

		EdgeOptions edgeoptions = new EdgeOptions();
		edgeoptions.setExperimentalOption("prefs", prefs);
		edgeoptions.addArguments("--kiosk-printing");

		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver(edgeoptions);
		}
		else if(bname.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		sdriver = driver;
		UtilityClassObject.setWebdriver(driver);
		Reporter.log("Browser got launched",true);
		driver.manage().window().maximize();
		Reporter.log("Browser got Maximized",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromPropertyFile("url");
		driver.get(URL);

	}
	//	@BeforeMethod
	//	public void toLogin() throws Throwable {
	//		FileUtility fu = new FileUtility();
	//		String URL = fu.getDataFromPropertyFile("url");
	//		driver.get(URL);
	//	
	//		String UN = fu.getDataFromPropertyFile("student_user");
	//		String PSWD = fu.getDataFromPropertyFile("password");
	//		driver.get(URL);
	//		LoginPage lp = new LoginPage(driver);
	//		lp.login(UN, PSWD);
	//
	//		Reporter.log("Logged In Successfully",true);
	//
	//	}

	@AfterMethod
	public void toLogout() throws InterruptedException {

		Thread.sleep(4000);
		HomePage hp = new HomePage(driver);
		hp.signOut();
		Reporter.log("Logged out Successfully",true);
	}

	@AfterClass
	public void toClose() {

		driver.quit();
		Reporter.log("Browser got Closed Successfully",true);
	}


	public void verifyingHeader(WebElement elmt,String text) {
		//Hard Assert
		String actualText = elmt.getText();
		boolean b = actualText.contains(text);
		Assert.assertTrue(b);
		Reporter.log(actualText+" verified",true);
	}
	public void verifyingTextfield(WebElement elmt,String text) {
		//Soft Assert
		String actualText = elmt.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualText.trim(), text);
		sa.assertAll();
		Reporter.log(actualText+" verified",true);
		}


	


}
