package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSwagImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public AddToCart login(String un, String pwd){
	
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    
		    	
		return new AddToCart();
	}
	public HomePage login1(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    
		    	
		return new HomePage();
	}
	
}
