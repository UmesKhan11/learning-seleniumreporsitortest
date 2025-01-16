package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;

import java.util.List;

public class CapturingBrowserConsoleLogs {

    private static final String base_url = "https://www.saucedemo.com/";
    @Test
    public void Consolelogs() {

        WebDriver driver = new ChromeDriver();

        driver.get(base_url);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("wrong_password");
        login.click();

        delay(10000);

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logEntries = logs.getAll();

        for (LogEntry logEntry : logEntries) {

            System.out.println("Message " + logEntry.getMessage());
            System.out.println("Level " + logEntry.getLevel());
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }   catch (InterruptedException e) {
                    System.out.println("Thread Interrupted");
                }
            }
}
