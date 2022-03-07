package com.saucedemo.tests.smoke;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    /**
     * login test case:
     * steps: go to webpage
     * login valid username and password
     * click on login button
     * verify you landed on login homepage.
     */

    @Test
    public void login_with_valid_account() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("standard_user", "secret_sauce");
        String text = driver.findElement(By.cssSelector("[class='title']")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("PRODUCTS"));
    }

    @Test
    public void login_with_invalid_account() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("asdwfwcefev", "fveveve");
        String text = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("do not match any user"));
    }
}
