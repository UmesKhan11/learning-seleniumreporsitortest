package com.loonycorn.learningselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ActionsAPIdragandDrop {

    private static final String base_url = "https://demoqa.com/droppable";

    @Test
    public void ActionsAPIdragandDrop() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(base_url);

        ((JavascriptExecutor) driver).executeScript (
                "window.scrollTo(0, document.body.scrollHeight / 3)");

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id(("droppable")));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

       Assert.assertEquals(drop.getText() , "Dropped!");



    }
}
