package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage extends TestBase {

    @FindBy(xpath = "//a[contains(text(), \"Sign in\")]")
    WebElement signIn;

    public  indexPage(){

        PageFactory.initElements(driver, this);
    }


    public void signin(){
        signIn.click();
    }


}
