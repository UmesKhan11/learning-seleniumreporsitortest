package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Uploadwithpath {

    private static final String base_url = "https://the-internet.herokuapp.com/upload";
    @Test
    public void Uploadwithpath() {
        WebDriver driver = new ChromeDriver();

        driver.get(base_url);
        driver.manage().window().maximize();

        WebElement upload = driver.findElement(By.id("file-upload"));
        String path = "C:\\Users\\Umes\\Downloads\\dog.jpg";
        upload.sendKeys(path);

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

        WebElement uploadedfilename = driver.findElement(By.id(("uploaded-files")));
        String filename = uploadedfilename.getText();

        Assert.assertEquals(filename,"dog.jpg");
    }
}
