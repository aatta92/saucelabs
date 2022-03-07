package com.saucedemo.pageobjects;

import com.saucedemo.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy (css = "#user-name")
    WebElement username_textField;

    @FindBy (css = "#password")
    WebElement password_textField;

    @FindBy (css = "#login-button")
    WebElement login_button;

    public HomePage(){
        PageFactory.initElements(BaseClass.driver, this);
    }

    public void login(String username, String password) throws InterruptedException {
        username_textField.sendKeys(username);
        password_textField.sendKeys(password);
        login_button.click();
        Thread.sleep(300);
    }
}

