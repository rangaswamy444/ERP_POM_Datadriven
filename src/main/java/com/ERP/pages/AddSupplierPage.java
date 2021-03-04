package com.ERP.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ERP.Base.TestBase;

public class AddSupplierPage extends TestBase{
	
	
	WebDriverWait wait;
	String expsnum;
	public AddSupplierPage() 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="x_Supplier_Number")
	WebElement SNumber;
	@FindBy(id="x_Supplier_Name")
	WebElement SName;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement address;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement city;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement country;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement CPerson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement PNumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement email;
	@FindBy(id="x_Mobile_Number")
	WebElement MNumber;
	@FindBy(id="x_Notes")
	WebElement Notes;
	@FindBy(id="btnAction")
	WebElement clickadd;
	//for confirmation ok
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement clickconfirmok;
	@FindBy(xpath="(//button[text()='OK'])[6]")
	WebElement clickalertok;
	//for validation
	
	
	//Method
	public String VerifySuppliersadd(String sname,String address,String city,String Country,String ContactPerson,String PhoneNo,
			String email,String MobileNo,String notes){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SNumber));
		System.out.println("Adding supplier------------------------------------->");
		expsnum=SNumber.getAttribute("value");
		SName.sendKeys(sname);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.country.sendKeys(Country);
		CPerson.sendKeys(ContactPerson);
		PNumber.sendKeys(PhoneNo);
		this.email.sendKeys(email);
		MNumber.sendKeys(MobileNo);
		this.Notes.sendKeys(notes);
		clickadd.sendKeys(Keys.ENTER);; //add
		wait.until(ExpectedConditions.visibilityOf(clickconfirmok));
		clickconfirmok.click();
		wait.until(ExpectedConditions.visibilityOf(clickalertok));
		clickalertok.click();
		return expsnum;
	}	

}
