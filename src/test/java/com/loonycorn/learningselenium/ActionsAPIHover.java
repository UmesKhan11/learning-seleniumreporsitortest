package com.loonycorn.learningselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsAPIHover {

    private static final String base_url = "https://demoqa.com/menu";

    @Test
    public void ActionsAPIHover() {
        WebDriver driver = new ChromeDriver();

        driver.get(base_url);
        driver.manage().window().maximize();

        ((JavascriptExecutor) driver).executeScript (
                "window.scrollTo(0, document.body.scrollHeight / 3 )");

        WebElement mitem2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mitem2).perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement si1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]/a")));

        WebElement si2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[2]/a"));
        WebElement si3 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a"));

        Assert.assertTrue(si1.isDisplayed());
        Assert.assertTrue(si2.isDisplayed());
        Assert.assertTrue(si3.isDisplayed());

        actions.moveToElement(si3).perform();

        WebElement ssi1 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]/a"));
        WebElement ssi2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[2]/a"));

        Assert.assertTrue(ssi1.isDisplayed());
        Assert.assertTrue(ssi2.isDisplayed());

    }
}
