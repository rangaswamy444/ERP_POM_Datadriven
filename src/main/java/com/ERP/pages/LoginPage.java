package com.ERP.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ERP.Base.TestBase;

public class LoginPage extends TestBase
{
	
	static WebDriverWait wait;
	//Constructor to avoid overloading of driver
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Elements on the page
	@FindBy(id="btnreset")
	WebElement resetbtn;
	@FindBy(id="username")
	WebElement uname;
	@FindBy(id="password")
	WebElement pword;
	@FindBy(id="btnsubmit")
	WebElement loginbtn;
	
	//Actions
	//validate title
	public String validateLoginPageTitle(){
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(resetbtn));
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	//verify login
	public  DashBoardPage VerifyLogin(String username,String password)
	{
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(resetbtn));
		resetbtn.click();
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(pword));
		pword.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
		return new DashBoardPage();
	}
}
