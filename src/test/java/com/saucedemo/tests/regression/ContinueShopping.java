package com.saucedemo.tests.regression;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class ContinueShopping extends BaseClass {
    @Test
    public void continue_shopping_from_cart_page() throws InterruptedException {
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();
        LoginPage loginPage = new LoginPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.add_item();
        cartPage.continue_shopping();
        loginPage.inventory_page_load();
    }
}
