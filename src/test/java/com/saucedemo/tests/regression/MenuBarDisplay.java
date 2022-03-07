package com.saucedemo.tests.regression;
import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.testng.annotations.Test;

public class MenuBarDisplay extends BaseClass {
    @Test
    public void menu_bar_display_when_click_on_burger_icon() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("standard_user", "secret_sauce");
        LoginPage loginPage = new LoginPage();
        loginPage.menu_bar_display();
    }

    @Test
    public void menu_bar_display_when_click_outside_box() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("standard_user", "secret_sauce");
        LoginPage loginPage = new LoginPage();
        loginPage.menuBar_display();
    }


    @Test
    public void menu_bar_disappear_after_clickingX() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.login("standard_user", "secret_sauce");
        LoginPage loginPage = new LoginPage();
        loginPage.menu_bar_disappear_after_clickingX();
    }
}
