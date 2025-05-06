package com.tp.sms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement Dashboard_link;


	@FindBy(xpath = "//span[text()='My Profile']")
	private WebElement MyProfile_link;

	@FindBy(xpath = "//span[text()='Classroom']")
	private WebElement Classroom_link;
	@FindBy(xpath = "//span[text()='Grade']")
	private WebElement Grade_link;
	@FindBy(xpath = "//span[text()='Subject']")
	private WebElement Subject_link;
	@FindBy(xpath = "//span[text()='Teacher']")
	private WebElement Teacher_link;

	@FindBy(partialLinkText  = "Add Teacher")
	private WebElement  AddTeacher_link;

	@FindBy(partialLinkText = "All Teacher")
	private WebElement  AllTeacher_link;

	@FindBy(xpath = "//span[text()='Subject Routing']")
	private WebElement SubjectRouting_link;
	@FindBy(xpath = "//span[text()='Timetable']")
	private WebElement Timetable_link;
	@FindBy(xpath = "//span[text()='Student']")
	private WebElement Student_link;

	@FindBy(partialLinkText = "Add Student")
	private WebElement AddStudent_link;

	@FindBy(partialLinkText  = "All Student")
	private WebElement  AllStudent_link;
	@FindBy(partialLinkText = "Leave Student")
	private WebElement   LeaveStudent_link;
	
	@FindBy(xpath = "//span[text()='Attendance']")
	private WebElement Attendance_link;
	
	@FindBy(partialLinkText = "Add Attendance")
	private WebElement AddAttendance_link;
	
	@FindBy(partialLinkText = "Student Attendance History")
	private WebElement StudentAttendanceHistory_link;
	@FindBy(partialLinkText = "Teacher Attendance History")
	private WebElement  TeacherAttendanceHistory_link;
	
	////li[@class='dropdown user user-menu open']
	
	
	@FindBy(xpath = "//li[@class='dropdown user user-menu']")
	private WebElement userimg_icon;
	
	@FindBy(xpath = "//img[@alt='User Image']/following-sibling::span")
	private WebElement username_icon;

	
	
	@FindBy(xpath = "//div[@id='insert_Success']/descendant::div[@class='modal-body bgColorWhite']")
	private WebElement confMessage_text;
	public WebElement getConfMessage_text() {
		return confMessage_text;
	}
	
	
	
	
	public WebElement getUsername_icon() {
		return username_icon;
	}

	@FindBy(xpath = "//span[text()=' Welcome back! ']")
	private WebElement welcomeback_text;
	
	@FindBy(xpath = "//span[@class='hidden-xs']")
	private WebElement userName_Txt;
	
	@FindBy(xpath = "//span[text()='Exam']")
	private WebElement exam_link;
	
	@FindBy(xpath = "//a[text()='Create Exam']")
	private WebElement createExam_link;
	
	public WebElement getCreateExam_link() {
		return createExam_link;
	}


	public WebElement getExam_link() {
		return exam_link;
	}

	@FindBy(linkText = "Sign out")
	private WebElement signOut_Btn;


	public WebElement getSignOut_Btn() {
		return signOut_Btn;
	}


	public WebElement getUserName_Txt() {
		return userName_Txt;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getDashboard_link() {
		return Dashboard_link;
	}


	public WebElement getMyProfile_link() {
		return MyProfile_link;
	}


	public WebElement getClassroom_link() {
		return Classroom_link;
	}


	public WebElement getGrade_link() {
		return Grade_link;
	}


	public WebElement getSubject_link() {
		return Subject_link;
	}


	public WebElement getAllTeacher_link() {
		return AllTeacher_link;
	}


	public WebElement getSubjectRouting_link() {
		return SubjectRouting_link;
	}


	public WebElement getTimetable_link() {
		return Timetable_link;
	}


	public WebElement getStudent_link() {
		return Student_link;
	}


	public WebElement getAddStudent_link() {
		return AddStudent_link;
	}


	public WebElement getAllStudent_link() {
		return AllStudent_link;
	}


	public WebElement getLeaveStudent_link() {
		return LeaveStudent_link;
	}


	public WebElement getAttendance_link() {
		return Attendance_link;
	}


	public WebElement getAddAttendance_link() {
		return AddAttendance_link;
	}


	public WebElement getStudentAttendanceHistory_link() {
		return StudentAttendanceHistory_link;
	}


	public WebElement getTeacherAttendanceHistory_link() {
		return TeacherAttendanceHistory_link;
	}


	public WebElement getUserimg_icon() {
		return userimg_icon;
	}


	public WebElement getWelcomeback_text() {
		return welcomeback_text;
	}


	public WebElement getTeacher_link() {
		return Teacher_link;
	}


	public WebElement getAddTeacher_link() {
		return AddTeacher_link;
	}



	public void signOut() {
		
		getUserimg_icon().click();
	//	getUsername_icon().click();
		getSignOut_Btn().click();
	
	}







}
