package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import io.qameta.allure.*;


public class ProductLinks {


    private static final String SITE = "https://demoblaze.com";
    @Test
    @Epic ("Product Page Links")
    @Feature ("Link Funtionality")
    @Story("Category wise Links")
    @Description ("All Links")
    @Severity(SeverityLevel.MINOR)
    @TmsLink ("RESET-12345")
    public void productlinks () {
        WebDriver driver = new ChromeDriver();
        driver.get(SITE);
        driver.manage().window().maximize();

        List<WebElement> element_cats = driver.findElements(By.id("itemc"));

        for (WebElement element_cat : element_cats) {
            System.out.println("------------------------------");
            System.out.println("Category:" + element_cat.getText());

            element_cat.click();
            delay();

            WebElement element_prods = driver.findElement(By.id("tbodyid"));

            List<WebElement> element_links = element_prods.findElements(By.tagName("a"));

            for (WebElement element_link : element_links) {
                String hrefAttr = element_link.getAttribute("href");
                System.out.println("Links:" + hrefAttr);

            }
        }
    }
        private static void delay() {
            try {
                Thread.sleep (5000);
            } catch (InterruptedException e){
            throw new RuntimeException (e);
        }

    }
}

