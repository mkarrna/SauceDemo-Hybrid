/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import java.io.IOException;


import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddToCart;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AddToCartTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	AddToCart addToCart;
	
	
	
	   
	public AddToCartTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		initialization();
		loginPage = new LoginPage();
		addToCart = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		TestUtil.runTimeInfo("error", "login successful");
	}
	
	@Test(priority=1)
	public void verifyItemsAddTOCart() throws InterruptedException{
		addToCart.addtocart();
		String title = addToCart.addToCartItemSize();
		Assert.assertEquals(title, "1");
		String price = addToCart.verifyPrice();
		Assert.assertEquals(price, "$29.99");
		String name = addToCart.verifyName();
		Assert.assertEquals(name, "Sauce Labs Backpack");
		
		
		
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
