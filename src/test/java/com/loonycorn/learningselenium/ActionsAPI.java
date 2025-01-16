package com.loonycorn.learningselenium;
import io.qameta.allure.Link;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsAPI {

    private static final String base_url = "https://demoqa.com/buttons";

    @Test
    @Link ("https://demoqa.com/buttons")
    public void ActionsAPI() {
        WebDriver driver = new ChromeDriver();
        driver.get(base_url);


        driver.manage().window().maximize();

        ((JavascriptExecutor) driver).executeScript(
               "window.scrollTo(0, document.body.scrollHeight / 3)");

       // WebElement buttons = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]"));

        //WebElement clickme = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]"));
      //    clickme.click();
      // Actions actions = new Actions(driver);
            //  actions.moveToElement(clickme).click().perform();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       //WebElement clickmemsg = wait.until(
             //   ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));

        //Assert.assertEquals(clickmemsg.getText(), "You have done a dynamic click");

        WebElement rightclick = driver.findElement(By.cssSelector("#rightClickBtn"));

        new Actions(driver)
                .contextClick(rightclick)
                .perform();

        WebElement rightclickmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("rightClickMessage")));

        Assert.assertEquals(rightclickmsg.getText(), "You have done a right click");

        WebElement dclickme = driver.findElement(By.cssSelector("#doubleClickBtn"));

        new Actions(driver)
                .doubleClick(dclickme)
                .perform();

        WebElement dclickmemsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

        Assert.assertEquals(dclickmemsg.getText(), "You have done a double click");
    }

    private static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
