package com.saucedemo.tests.sanity;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class MenuLinks extends BaseClass {
    @Test
    public void menuLinks() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.login("standard_user", "secret_sauce" );
        loginPage.menuLinks();
    }
}
