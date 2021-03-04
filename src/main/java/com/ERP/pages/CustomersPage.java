package com.ERP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ERP.Base.TestBase;

public class CustomersPage extends TestBase
{
	WebDriverWait wait;
	public CustomersPage() 
	{
		PageFactory.initElements(driver, this);
	}
	//Elements on the page
	
		@FindBy(xpath="//div[@class='panel-heading ewGridUpperPanel']//a[@class='btn btn-default ewAddEdit ewAdd btn-sm']")
		WebElement clickAddcusbtn;
		@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
		WebElement searchpanel;
		@FindBy(xpath="//input[@id='psearch']")
		WebElement searchtextbox;
		@FindBy(xpath="//button[@id='btnsubmit']")
		WebElement searchbtn;
		@FindBy(xpath="//table[@id='tbl_a_customerslist']")
		WebElement custable;
		//Methods
		public AddCustomerPage AddCustomer(){
			wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(clickAddcusbtn));
			clickAddcusbtn.click();
			return new AddCustomerPage();
		}
		public void searchCustomerandValidate(String expcnum) {
			if(!searchtextbox.isDisplayed())
				searchpanel.click();
				wait.until(ExpectedConditions.visibilityOf(searchtextbox));
				searchtextbox.clear();
				searchtextbox.sendKeys(expcnum);
				searchbtn.click();
				wait.until(ExpectedConditions.visibilityOf(custable));
				//capture supplier num from table
				String actcnum=driver.findElement(By.xpath("//table[@id='tbl_a_customerslist']/tbody/tr[1]/td[5]/div/span/span")).getText();
				Assert.assertEquals(expcnum, actcnum);
		}
		
}
