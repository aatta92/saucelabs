package com.saucedemo.tests.regression;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class Checkout extends BaseClass {
    @Test
    public void checkout_with_empty_field() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        cartPage.continue_checkout();
    }
}
