package com.saucedemo.tests.smoke;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseClass {
    /**
     * Test case : place order.
     * steps: go to webpage.
     * login valid username and password
     * click on login button.
     * verify you landed on login homepage.
     * Add an item.
     * click on shopping cart link.
     * click on checkout button.
     * fill out all empty fields.
     * click continue button.
     * click finish.
     */

    @Test
    public void place_order() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        cartPage.place_order("anwar", "atta", "20155");
        String text = driver.findElement(By.cssSelector(".complete-text")).getText();
        Assert.assertTrue(text.contains("Your order has been dispatched"));
    }

}
