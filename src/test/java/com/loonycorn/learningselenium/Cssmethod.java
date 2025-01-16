package com.loonycorn.learningselenium;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Cssmethod {

    private static final String SITE = "https://www.saucedemo.com/";

    @Test
    public void Cssmethod() {
        WebDriver driver = new ChromeDriver();
        driver.get(SITE);
        driver.manage().window().maximize();

        WebElement element_loginbox = driver.findElement(By.cssSelector(".login-box"));
        WebElement element_username = element_loginbox.findElement(By.cssSelector("#user-name"));
        WebElement element_password = element_loginbox.findElement(By.cssSelector("input[placeholder^='Pass']"));

        element_username.sendKeys("standard_user");
        element_password.sendKeys("secret_sauce");

        WebElement element_submit = element_loginbox.findElement(By.cssSelector("input[type$='mit']"));
        element_submit.click();

        WebElement element_prod1 = driver.findElement(By.cssSelector("button[name='add-to-cart-sauce-labs-backpack']"));
        element_prod1.click();

        WebElement element_prod2 = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-bike-light[data-test='add-to-cart-sauce-labs-bike-light']"));
        element_prod2.click();

        WebElement element_cart = driver.findElement(By.cssSelector("div[class='shopping_cart_container']"));
        element_cart.click();

        WebElement element_checkout =driver.findElement(By.cssSelector("button#checkout"));
        element_checkout.click();


    }
}
