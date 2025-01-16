package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Download {
    private static final String base_url = "https://the-internet.herokuapp.com/download";

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("download.default_directory" , "C:\\Users\\Umes\\OneDrive\\Documents");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @Test
    public void Download() {

        driver.get(base_url);
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.cssSelector("a[href$='.jpg']"));

        for (WebElement element : elements) {
            element.click();
            delay();
        }
    }
        private static void delay() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                    throw new RuntimeException (e);
            }

        }
    }

