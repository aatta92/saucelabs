package com.saucedemo.tests.regression;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class Checkout_overview extends BaseClass {
    @Test
    public void checkout_overview_necessary_fields_displayed() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        cartPage.checkout_overview_displayed("anwar", "atta", "20255");
    }
}
