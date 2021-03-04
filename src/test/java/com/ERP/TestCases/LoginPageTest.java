package com.ERP.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ERP.Base.TestBase;
import com.ERP.Utilities.TestUtil;
import com.ERP.pages.DashBoardPage;
import com.ERP.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPageTest extends TestBase{
	
	LoginPage lPage;
	DashBoardPage dashBoardPage;
	ExtentReports report;
	ExtentTest test;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		lPage = PageFactory.initElements(driver, LoginPage.class);	
		report= new ExtentReports("./ExtentReports/check"+TestUtil.Dateformat()+".html");
		test=report.startTest("loginPageTitleTest ");
		
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = lPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Users « Stock Accounting");
		
		test.log(LogStatus.PASS, "loginPageTitleTest");
		
	}
	@Test(priority=2)
	public void logintest(){
		dashBoardPage=lPage.VerifyLogin("admin", "master");		
		test.log(LogStatus.PASS, "logintest");
	}
	@AfterMethod
	public void tearDown(){
		report.endTest(test);
		report.flush();
		driver.close();
	}
	
	
	

	

}
