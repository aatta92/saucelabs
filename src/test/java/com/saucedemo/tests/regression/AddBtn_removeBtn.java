package com.saucedemo.tests.regression;

import com.saucedemo.base.BaseClass;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddBtn_removeBtn extends BaseClass {
    @Test
    public void add_btn_change_to_remove_after_add_item() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.login("standard_user", "secret_sauce");
        loginPage.display_added_items_on_shopping_cart();
        String text = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("REMOVE"));
    }
}
