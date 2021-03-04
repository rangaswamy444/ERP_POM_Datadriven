package com.ERP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ERP.Base.TestBase;

public class SuppliersPage extends TestBase
{
	
	WebDriverWait wait;
	/**
	 * suppliers page method
	 */

	public SuppliersPage() 
	{
		PageFactory.initElements(driver, this);
	}
	//Elements on the page 
	@FindBy(xpath="//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")
	WebElement clickAddsupbtn;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-search ewIcon']")
	WebElement searchpanel;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement searchtextbox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement searchbtn;	
	@FindBy(xpath="//table[@id='tbl_a_supplierslist']")
	WebElement suptable;
	
	//Actions
	public AddSupplierPage Addsupplier(){
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(clickAddsupbtn));
		clickAddsupbtn.click();
		return new AddSupplierPage();
	}
	public void searchSupplierandValidate(String expsnum){
		if(!searchtextbox.isDisplayed())
			searchpanel.click();
			wait.until(ExpectedConditions.visibilityOf(searchtextbox));
			searchtextbox.clear();
			searchtextbox.sendKeys(expsnum);
			searchbtn.click();		
			wait.until(ExpectedConditions.visibilityOf(suptable));
			//capture supplier num from table
			String actsnum=driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr[1]/td[6]/div/span/span")).getText();	
			Assert.assertEquals(expsnum, actsnum);
	}
	
	
	
}
