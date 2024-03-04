package com.crm.qa.testcases;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddToCart;
import com.crm.qa.pages.CheckoutPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import com.crm.qa.util.TestUtil;

public class checkoutTest extends TestBase {

    LoginPage loginPage;
    AddToCart homePage;
    AddToCart addToCart;
    CheckoutPage checkoutPage;

    public checkoutTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
  
        initialization();
		loginPage = new LoginPage();
		addToCart = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		checkoutPage=addToCart.addtocart();
        checkoutPage = new CheckoutPage();
    }

    @Test(priority = 1)
    public void verifyCheckout() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        checkoutPage.clickCheckoutButton();
        
        checkoutPage.enterFirstName("Ram");
        checkoutPage.enterLastName("Sharma");
        checkoutPage.enterZipCode("12345");
        checkoutPage.clickContinueButton();
         // Add appropriate wait
        String productName = checkoutPage.getProductInfo();
        Assert.assertEquals(productName, "Sauce Labs Backpack"); 
        String totalPrice = checkoutPage.getTotalPrice();
        Assert.assertEquals(totalPrice, "$29.99"); 
        checkoutPage.clickFinishButton();
        String successMessage = checkoutPage.getSuccessMessage();
        System.out.println("Success Message: " + successMessage);
    }

    @AfterMethod
    public void terdown()
    {
    	driver.quit();
    }
}

