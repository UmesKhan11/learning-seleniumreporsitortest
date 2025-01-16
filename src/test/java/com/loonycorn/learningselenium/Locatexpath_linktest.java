package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Locatexpath_linktest {

    private static final String SITE = "https://www.saucedemo.com";

    @Test
    public void Locatexpath_linktest() {
        WebDriver driver = new ChromeDriver();
        driver.get(SITE);
        driver.manage().window().maximize();

        WebElement element_user = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        WebElement element_pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
                element_user.sendKeys("standard_user");
        element_pass.sendKeys("secret_sauce");

        WebElement element_sub = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        element_sub.submit();

        WebElement element_prod1 = driver.findElement(By.linkText("Sauce Labs Backpack"));
        element_prod1.click();
        driver.navigate().back();

        WebElement element_prod2 = driver.findElement(By.partialLinkText("Bolt"));
        element_prod2.click();


    }
}
