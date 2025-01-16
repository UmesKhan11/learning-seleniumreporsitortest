package com.loonycorn.learningselenium;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.v131.network.Network;

import java.util.Optional;

public class BlockingResources {

    private static final String base_url = "https://www.saucedemo.com";

    @Test
    public void BlockingResourcesTest() {

        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        driver.get(base_url);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        delay(5000);
        devTools.send(Network.enable(Optional.empty(), Optional.empty()
                , Optional.empty()));

        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.jpeg", "*.png")));
        driver.navigate().refresh();
        delay(5000);
    }

    private void delay (int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
           System.out.println("Thread interrupted");
        }

    }
}