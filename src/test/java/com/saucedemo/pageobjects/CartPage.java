package com.saucedemo.pageobjects;

import com.saucedemo.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(css = "#checkout")
    WebElement check_out_btn;

    @FindBy(css = "#first-name")
    WebElement firstname_textField;

    @FindBy(css = "#last-name")
    WebElement lastname_textField;

    @FindBy(css = "#postal-code")
    WebElement zipcode_textField;

    @FindBy(css = "#continue")
    WebElement continue_placing_btn;

    @FindBy(css = "#finish")
    WebElement complete_order_btn;

    @FindBy(css = "#continue-shopping")
    WebElement continue_shopping_btn;

    @FindBy(css = ".cart_quantity_label")
    WebElement item_quantity;

    @FindBy(css = ".cart_desc_label")
    WebElement item_description;

    @FindBy(css = "[data-test='error']")
    WebElement error_message;

    @FindBy(css = "[id='contents_wrapper']")
    WebElement check_out_overview;

    @FindBy (css = "#cancel")
    WebElement cancel_btn;

    public void place_order(String firstname, String lastname, String zipcode) throws InterruptedException {
        check_out_btn.click();
        Thread.sleep(300);
        firstname_textField.sendKeys(firstname);
        lastname_textField.sendKeys(lastname);
        zipcode_textField.sendKeys(zipcode);
        continue_placing_btn.click();
        Thread.sleep(300);
        complete_order_btn.click();
        Thread.sleep(300);
    }

    public void continue_shopping() throws InterruptedException {
        continue_shopping_btn.click();
        Thread.sleep(1000);
    }

    public void item_quantity_description() {
        String text1 = item_quantity.getText();
        Assert.assertTrue(text1.contains("QTY"));
        String text2 = item_description.getText();
        Assert.assertTrue(text2.contains("DESCRIPTION"));
    }

    public void continue_checkout() {
        check_out_btn.click();
        continue_placing_btn.click();
        String text1 = error_message.getText();
        Assert.assertTrue(text1.contains("First Name is required"));
        firstname_textField.sendKeys("anwar");
        continue_placing_btn.click();
        String text2 = error_message.getText();
        Assert.assertTrue(text2.contains("Last Name is required"));
        lastname_textField.sendKeys("atta");
        continue_placing_btn.click();
        String text3 = error_message.getText();
        Assert.assertTrue(text3.contains("Postal Code is required"));
        zipcode_textField.sendKeys("20155");
        continue_placing_btn.click();
    }

    public void checkout_overview_displayed(String firstname, String lastname, String zipcode) throws InterruptedException {
        check_out_btn.click();
        Thread.sleep(300);
        firstname_textField.sendKeys(firstname);
        lastname_textField.sendKeys(lastname);
        zipcode_textField.sendKeys(zipcode);
        continue_placing_btn.click();
        Thread.sleep(300);
        String text = check_out_overview.getText();
        Assert.assertTrue(text.contains("Shipping Information:"));
        Assert.assertTrue(text.contains("Payment Information:"));
        Assert.assertTrue(text.contains("Item total:"));
        Assert.assertTrue(text.contains("Sauce Labs"));
    }

    public void cancelBtn_returns_homepage(String firstname, String lastname, String zipcode) throws InterruptedException {
        check_out_btn.click();
        Thread.sleep(300);
        firstname_textField.sendKeys(firstname);
        lastname_textField.sendKeys(lastname);
        zipcode_textField.sendKeys(zipcode);
        continue_placing_btn.click();
        Thread.sleep(300);
        cancel_btn.click();
        Thread.sleep(300);
    }
}
