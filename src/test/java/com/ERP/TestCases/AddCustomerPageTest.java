package com.ERP.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ERP.Base.TestBase;
import com.ERP.Utilities.TestUtil;
import com.ERP.pages.AddCustomerPage;
import com.ERP.pages.CustomersPage;
import com.ERP.pages.DashBoardPage;
import com.ERP.pages.LoginPage;

public class AddCustomerPageTest extends TestBase {
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	CustomersPage customerspage;
	AddCustomerPage addcustomerpage;
	
	/*
	 * Constructor
	 */
	
	public AddCustomerPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		dashBoardPage=loginPage.VerifyLogin("admin", "master");
		customerspage=dashBoardPage.customerlink();
		addcustomerpage=customerspage.AddCustomer();		
	}
	@DataProvider
	public Object[][] getCustomerTestData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("testinputpath"), "Customers");
		return data;
	}
	@Test(dataProvider="getCustomerTestData")
	public void addCustomerTest(String cusname,String add,String city,String country,String cPerson,String ph,String email,String mobnum,String notes) {
		String cnum=addcustomerpage.VerifyCustomeradd(cusname, add, city, country, cPerson, ph, email, mobnum, notes);
		customerspage.searchCustomerandValidate(cnum);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
