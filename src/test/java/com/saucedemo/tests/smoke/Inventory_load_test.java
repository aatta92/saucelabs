package com.saucedemo.tests.smoke;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class Inventory_load_test extends BaseClass {
    @Test
    public void inventory_loaded_upon_login() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("standard_user", "secret_sauce");
        LoginPage loginPage = new LoginPage();
        loginPage.inventory_page_load();
    }
}
