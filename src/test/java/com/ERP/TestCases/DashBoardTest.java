package com.ERP.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ERP.Base.TestBase;
import com.ERP.pages.CustomersPage;
import com.ERP.pages.DashBoardPage;
import com.ERP.pages.LoginPage;
import com.ERP.pages.SuppliersPage;

public class DashBoardTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	SuppliersPage supplierspage;
	CustomersPage customerspage;
	public DashBoardTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);	
		dashBoardPage=loginPage.VerifyLogin("admin", "master");		
	}
	@Test(priority=1)
	public void DashBoardTitleTest(){		
		String title = dashBoardPage.verifyPageTitle();
		Assert.assertEquals(title, "Dashboard « Stock Accounting");
	}
	@Test(priority=2)
	public void DisplaynameTest(){
		String name=dashBoardPage.validatedispname();
		Assert.assertEquals(name, "Administrator");
	}
	@Test(priority=3)
	public void supplierpagetest(){
		supplierspage=dashBoardPage.supplierlink();
	}
	@Test(priority=4)
	public void customerspagetest(){
		customerspage=dashBoardPage.customerlink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
