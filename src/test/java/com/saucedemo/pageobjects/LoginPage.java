package com.saucedemo.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static com.saucedemo.base.BaseClass.driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#login-button")
    WebElement login_button;

    @FindBy(css = "[class='title']")
    WebElement swagLabs_logo;

    @FindBy(css = "#item_4_title_link")
    WebElement item4_header_link;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    WebElement add_item_btn;

    @FindBy(css = ".shopping_cart_link")
    WebElement cart_link;

    @FindBy(css = "#remove-sauce-labs-backpack")
    WebElement remove_item_btn;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement burger_menu_btn;

    @FindBy(css = ".bm-item-list")
    WebElement menu_bar_items;

    @FindBy(css = "#react-burger-cross-btn")
    WebElement close_mark_link;

    @FindBy(css = "[href='https://twitter.com/saucelabs']")
    WebElement tweeter_link;

    @FindBy(css = "[href='https://www.facebook.com/saucelabs']")
    WebElement facebook_link;

    @FindBy(css = "[href='https://www.linkedin.com/company/sauce-labs/']")
    WebElement linkedIn_link;

    @FindBy(css = "#inventory_sidebar_link")
    WebElement items_inventory_link;

    @FindBy(css = "#about_sidebar_link")
    WebElement about_sidebar_link;

    @FindBy(css = "#headerMainNav > div > nav > div > a")
    WebElement sauceLabs_logo;

    @FindBy(css = "#logout_sidebar_link")
    WebElement logout_sidebar_link;

    @FindBy(css = "#reset_sidebar_link")
    WebElement reset_sidebar_link;

    @FindBy(css = "[alt='Sauce Labs Backpack']")
    WebElement item_image;

    @FindBy(css = "[src='/static/media/red-onesie-1200x1500.1b15e1fa.jpg']")
    WebElement low_price_item_image;

    @FindBy(css = "[src='/static/media/sauce-pullover-1200x1500.439fc934.jpg']")
    WebElement high_price_item_image;

    @FindBy(css = "#item_3_title_link > div")
    WebElement item_sorted_descending;

    @FindBy(css = ".product_sort_container")
    WebElement product_sort_container;

    public void inventory_page_load() {
        String text = item4_header_link.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Labs Backpack"));
    }

    public void add_item() throws InterruptedException {
        add_item_btn.click();
        Thread.sleep(1000);
        cart_link.click();
        Thread.sleep(1000);
    }

    public void remove_item() throws InterruptedException {
        Thread.sleep(1000);
        remove_item_btn.click();
        Thread.sleep(1000);
    }

    public void display_added_items_on_shopping_cart() throws InterruptedException {
        add_item_btn.click();
        Thread.sleep(1000);
    }

    public void menu_bar_display() throws InterruptedException {
        burger_menu_btn.click();
        Thread.sleep(300);
        String text = menu_bar_items.getText();
        Assert.assertTrue(text.contains("ALL ITEMS"));
        Assert.assertTrue(text.contains("ABOUT"));
        Assert.assertTrue(text.contains("LOGOUT"));
        Assert.assertTrue(text.contains("APP"));
    }

    public void menuBar_display() throws InterruptedException {
        burger_menu_btn.click();
        Thread.sleep(300);
        add_item_btn.click();
        System.out.println(menu_bar_items);
        Assert.assertTrue(menu_bar_items.isDisplayed());
    }

    public void menu_bar_disappear_after_clickingX() throws InterruptedException {
        burger_menu_btn.click();
        Thread.sleep(300);
        close_mark_link.click();
        Thread.sleep(300);
        Assert.assertFalse(menu_bar_items.isDisplayed());
    }

    public void social_media_links() throws InterruptedException {
        String href = facebook_link.getAttribute("href");
        Assert.assertFalse(href.isBlank());
        String href1 = tweeter_link.getAttribute("href");
        Assert.assertFalse(href1.isBlank());
        String href2 = linkedIn_link.getAttribute("href");
        Assert.assertFalse(href2.isBlank());
    }

    public void menuLinks() throws InterruptedException {
        item_image.click();
        Thread.sleep(500);
        burger_menu_btn.click();
        Thread.sleep(500);
        items_inventory_link.click();
        Thread.sleep(500);
        String text = swagLabs_logo.getText();
        Assert.assertTrue(text.contains("PRODUCTS"));
        add_item_btn.click();
        Thread.sleep(500);
        burger_menu_btn.click();
        Thread.sleep(500);
        reset_sidebar_link.click();
        Thread.sleep(500);
        String text1 = cart_link.getText();
        Assert.assertTrue(text1.contains(""));
        about_sidebar_link.click();
        Thread.sleep(500);
        Assert.assertTrue(sauceLabs_logo.isDisplayed());
        driver.navigate().back();
        burger_menu_btn.click();
        Thread.sleep(500);
        logout_sidebar_link.click();
        Thread.sleep(500);
        Assert.assertTrue(login_button.isDisplayed());
    }

    public void product_sort() {
        product_sort_container.click();
        Select select = new Select(product_sort_container);
        select.selectByIndex(2);
        Assert.assertTrue(low_price_item_image.isDisplayed());
        product_sort_container.click();
        select.selectByIndex(3);
        Assert.assertTrue(high_price_item_image.isDisplayed());
        product_sort_container.click();
        select.selectByIndex(1);
        Assert.assertTrue(item_sorted_descending.isDisplayed());
    }
}
