package com.loonycorn.learningselenium;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocationTestbyClass {

    private static final String SITE = "https://demoblaze.com";

    @Test
    public void LocationTestbyClass() {
        WebDriver driver = new ChromeDriver();
        driver.get(SITE);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement element_prod = driver.findElement(By.className("hrefch"));
        element_prod.click();


        WebElement element_addtocart = driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
        element_addtocart.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement element_cart = driver.findElement(By.id("cartur"));
        element_cart.click();

        WebElement element_prod_cart = driver.findElement(By.className("success"));
        Assert.assertTrue(element_prod_cart.isDisplayed());
    }


}
