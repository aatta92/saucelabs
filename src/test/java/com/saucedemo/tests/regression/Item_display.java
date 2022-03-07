package com.saucedemo.tests.regression;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Item_display extends BaseClass {
    @Test
    public void display_added_items_on_shopping_cart() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.display_added_items_on_shopping_cart();
        String text = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        Assert.assertTrue(text.contains("1"));
    }
}
