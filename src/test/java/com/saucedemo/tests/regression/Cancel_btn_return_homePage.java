package com.saucedemo.tests.regression;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cancel_btn_return_homePage extends BaseClass {
    @Test
    public void return_homepage_upon_clicking_cancelBtn() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        cartPage.cancelBtn_returns_homepage("anwar", "atta", "20155");
        String text = driver.findElement(By.cssSelector("[class='title']")).getText();
        Assert.assertTrue(text.contains("PRODUCTS"));
    }
}
