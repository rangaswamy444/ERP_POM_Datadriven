package com.ERP.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ERP.Base.TestBase;

public class DashBoardPage extends TestBase{
	static WebDriverWait wait;
	public DashBoardPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Elements on the page
	
	@FindBy(xpath="//strong[contains(text(),'Administrator')]")
	WebElement dispname; 
	@FindBy(xpath="//li[@id='mi_a_suppliers']//a[@href='a_supplierslist.php'][normalize-space()='Suppliers']")
	WebElement clickSupplier;
	@FindBy(xpath="//li[@id='mi_a_purchases']//a[@href='a_purchaseslist.php?cmd=resetall'][normalize-space()='Purchases']")
	WebElement clickpurchases;
	@FindBy(xpath="//li[@id='mi_a_customers']//a[@href='a_customerslist.php'][normalize-space()='Customers']")
	WebElement clickcustomers;
	//Actions
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	public  String validatedispname(){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(dispname));
		return dispname.getText();
	}
	public SuppliersPage supplierlink(){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(clickSupplier));
		clickSupplier.click();
		return new SuppliersPage();
	}
	public  CustomersPage customerlink(){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(dispname));
		clickcustomers.click();
		return new CustomersPage();		
	}

}
