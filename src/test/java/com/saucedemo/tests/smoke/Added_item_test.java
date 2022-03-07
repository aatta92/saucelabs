package com.saucedemo.tests.smoke;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added_item_test extends BaseClass {
    /**
     * Test case : Added Item Test
     * steps: go to webpage.
     * login valid username and password
     * click on login button.
     * verify you landed on login homepage.
     * Add an item.
     * click on shopping cart link.
     * verify item is added in the cart page
     */

    @Test
    public void add_item() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.login("problem_user", "secret_sauce");
        loginPage.add_item();
        String text = driver.findElement(By.cssSelector(".cart_quantity")).getText();
        Assert.assertTrue(text.contains("1"));
    }
}
