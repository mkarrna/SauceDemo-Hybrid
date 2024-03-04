package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

import com.crm.qa.base.TestBase;

public class AddToCart extends TestBase{

	
		@FindBy(xpath="//div[@class='inventory_item_price']")
		WebElement itemprice;
		@FindBy(xpath="//div[@class='inventory_item_name']")
		WebElement itemname;
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
		WebElement addtocart;	 
		@FindBy(xpath="//a[@class = 'shopping_cart_link']")
		WebElement cartlink;
		@FindBy(xpath="//span[@class='shopping_cart_badge']")
		WebElement addCrtLOgo;
		
		
		//Initializing the Page Objects:
		public AddToCart(){
			PageFactory.initElements(driver, this);
		}

		// Actions or the methods for add to cart page
		public CheckoutPage addtocart() 
		{
		
			addtocart.click();
			cartlink.click();
			return new CheckoutPage();

		}
		public String verifyPrice()
		{
			return itemprice.getText();
		}
		public String verifyName()
		{
			return itemname.getText();
		}
		
		public String addToCartItemSize()
		{
			return addCrtLOgo.getText();
		}
}
