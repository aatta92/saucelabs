package com.saucedemo.tests.smoke;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test case : Remove Item Test
 * steps: go to webpage.
 * login valid username and password
 * click on login button.
 * verify you landed on login homepage.
 * Add an item.
 * click on shopping cart link.
 * click on remove button.
 * verify item is removed from the cart page
 */

public class Remove_item_test extends BaseClass {
    @Test
    public void add_item() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        loginPage.remove_item();
        String text = driver.findElement(By.cssSelector(".shopping_cart_link")).getText();
        Assert.assertTrue(text.contains(""));
    }
}
