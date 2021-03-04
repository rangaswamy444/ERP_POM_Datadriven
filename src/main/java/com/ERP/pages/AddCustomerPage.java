package com.ERP.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ERP.Base.TestBase;

public class AddCustomerPage extends TestBase {

	WebDriverWait wait;
	public AddCustomerPage() 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="x_Customer_Number")
	WebElement CNumber;
	@FindBy(id="x_Customer_Name")
	WebElement CName;
	@FindBy(id="x_Address")
	WebElement address;
	@FindBy(id="x_City")
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
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement clickconfirmok;
	@FindBy(xpath="/html/body/div[17]/div[2]/div/div[4]/div[2]/button")
	WebElement clickalertok;
	
	public String VerifyCustomeradd(String cname,String address,String city,String Country,String ContactPerson,String PhoneNo,
			String email,String MobileNo,String notes){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CNumber));
		System.out.println("Adding Customer------------------------------------->");
		String expcnum=CNumber.getAttribute("Value");
		CName.sendKeys(cname);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.country.sendKeys(Country);
		CPerson.sendKeys(ContactPerson);
		PNumber.sendKeys(PhoneNo);
		this.email.sendKeys(email);
		MNumber.sendKeys(MobileNo);
		this.Notes.sendKeys(notes);
		clickadd.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(clickconfirmok));
		clickconfirmok.click();
		wait.until(ExpectedConditions.visibilityOf(clickalertok));
		clickalertok.click();
		return expcnum;
	
	}

}
