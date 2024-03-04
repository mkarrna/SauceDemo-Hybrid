package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CheckoutPage extends TestBase {

    @FindBy(xpath="//button[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath="//input[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath="//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath="//input[@id='postal-code']")
    WebElement zipCode;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath="//button[text()='Finish']")
    WebElement finishButton;

    @FindBy(xpath="//h2[@class='complete-header']")
    WebElement successMessage;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement productName;

    @FindBy(xpath="//div[@class='inventory_item_price']")
    WebElement productprice;

    //Initializing the Page Objects:
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    // Click on checkout button
    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    // Enter first name
    public void enterFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
    }

    // Enter last name
    public void enterLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
    }

    // Enter zip code
    public void enterZipCode(String zipCodeValue) {
        zipCode.sendKeys(zipCodeValue);
    }

    // Click continue button
    public void clickContinueButton() {
        continueButton.click();
    }

    // Click finish button
    public void clickFinishButton() {
        finishButton.click();
    }

    // Get success message
    public String getSuccessMessage() {
        return successMessage.getText();
    }

    // Get product name
    public String getProductInfo() {
        return productName.getText();
    }

    // Get product price
    public String getTotalPrice() {
		return productprice.getText();
    }
}
