package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(), \"Sign in\")]")
    WebElement link_signIn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement input_user;

    @FindBy(xpath="//input[@id='passwd']")
    WebElement input_password;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    WebElement button_signin;

    @FindBy(xpath = "//a[@class=\"product-name\" and @title=\"Blouse\" and contains(text(),\"Blouse\")]")
    WebElement link_blouse;

    @FindBy(xpath = "//a[@class=\"product-name\" and @title=\"Blouse\" and contains(text(),\"Blouse\")]//ancestor::div[1]//div[@class=\"content_price\"]")
    WebElement link_blouse_price;

    @FindBy(xpath = "//img[@class=\"logo img-responsive\"]")
    WebElement logoImage;


    public  indexPage(){

        PageFactory.initElements(driver, this);
    }

    public String validateIndexPageTitle(){
        return driver.getTitle();
    }

    public boolean validateLogoImage(){
        return logoImage.isDisplayed();
    }

    public HomePage validateSignIn(){
        link_signIn.click();
        input_user.sendKeys(prop.getProperty("user"));
        input_password.sendKeys(prop.getProperty("password"));
        button_signin.click();
        return new HomePage();
    }

    public String validateBlousePrice(){
        return link_blouse_price.getText();
    }




}
