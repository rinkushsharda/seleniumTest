package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//h1[@class=\"page-heading\"]")
    WebDriver pageHeading;

    public HomePage(){
        PageFactory.initElements(driver, this
        );
    }

   public String validateHomePageTitle(){
       return driver.getTitle();
   }


}
