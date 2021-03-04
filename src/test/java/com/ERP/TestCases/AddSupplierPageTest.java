package com.ERP.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.ERP.Base.TestBase;
import com.ERP.Utilities.TestUtil;
import com.ERP.pages.AddSupplierPage;
import com.ERP.pages.DashBoardPage;
import com.ERP.pages.LoginPage;
import com.ERP.pages.SuppliersPage;

public class AddSupplierPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	SuppliersPage supplierspage;
	AddSupplierPage addsupplierpage;
//	ExtentReports report;
//	ExtentTest test;
	
	public AddSupplierPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);	
		dashBoardPage=loginPage.VerifyLogin("admin", "master");	
		supplierspage=dashBoardPage.supplierlink();
		addsupplierpage=supplierspage.Addsupplier();
	//	report= new ExtentReports("./ExtentReports/sup"+GeneralUtil.Dateforrmat()+".html");
	//	test=report.startTest("loginPageTitleTest ");
	}
	@DataProvider
	public Object[][] getSupplierTestData(){
		Object data[][] = TestUtil.getTestData(prop.getProperty("testinputpath"), "Suppliers");
		return data;
	}
	@Test(priority=1,dataProvider="getSupplierTestData")
	public void AddsupplierTest(String supname,String add,String city,String country,String cPerson,String ph,String email,String mobnum,String notes){		
		String snum=addsupplierpage.VerifySuppliersadd(supname, add, city, country, cPerson, ph, email, mobnum, notes);
		supplierspage.searchSupplierandValidate(snum);
		//test.log(LogStatus.PASS, "AddsupplierTest");
	}
	

	@AfterMethod
	public void tearDown(){
	//	report.endTest(test);
	//	report.flush();

		driver.close();
	}

}
