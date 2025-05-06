package com.tp.sms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tp.sms.ObjectRepository.HomePage;
import com.tp.sms.ObjectRepository.LoginPage;

public class sampleTest {

	public static void main(String[] args){
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8081/AppServer/Student_Management_System/view/login.php");
		//LoginPage lp = new LoginPage(driver);
		//HomePage hp = new HomePage(driver);
	//	lp.login();
		
		//hp.getTeacher_link().click();
		//hp.getAddTeacher_link().click();
		//driver.findElement(By.xpath("//span[text()='Student']")).click();
		//driver.findElement(By.partialLinkText("Add Student")).click();
		//driver.findElement(By.partialLinkText("All Student")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Classroom']")).click();
		driver.findElement(By.xpath("//label[text()='Search:']")).sendKeys("classroom");
		

		
		
		
	}

}
