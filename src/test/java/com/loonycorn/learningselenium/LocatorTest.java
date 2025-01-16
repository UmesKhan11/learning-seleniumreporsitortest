package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tags;
import io.qameta.allure.testng.Tag;

public class LocatorTest {

    private static final String SITE = "https://www.demoblaze.com/";

    @Test
    @Epic ("WebElementLocator")
    @Feature ("Button Locator")
    @Story ("Catalogue and Cart Button Locator")
    @Description ("Size of Catalogue and Cart Button")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("catalogue"),@Tag("cart")})
    @Step ("Size")
    public void idlocatorTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(SITE);
        delay();

        Allure.step("Catalogue button size", step -> {
                    WebElement element_cat = driver.findElement(By.id("cat"));
                    System.out.println("Text:" + element_cat.getText());
                    Assert.assertTrue(element_cat.isDisplayed());
                    System.out.println(element_cat.getSize());
                });
        Allure.step("Cart Button Size", step -> {
                    WebElement element_cart = driver.findElement(By.id("cartur"));
                    element_cart.click();
                });
        delay();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/cart.html");
        driver.navigate().back();
       // System.out.println("Text:" + element_cat.getText());
    }
    private static void delay() {
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    }

