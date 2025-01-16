package com.loonycorn.learningselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
import java.util.Set;
import org.testng.Assert;

public class ManipulatingCookies {

    private static final String base_url = "https://testpages.eviltester.com/styled/cookies/adminlogin.html";

    @Test
    public void ManipulatingCookies () {
        WebDriver driver = new ChromeDriver();

        driver.get(base_url);
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id(("username")));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));

        user.sendKeys("Admin");
        pass.sendKeys("AdminPass");
        Actions actions = new Actions(driver);
        actions.click(login).perform();



        Set<Cookie> logincookie = driver.manage().getCookies();
        System.out.println("Login Cookie: " + logincookie);
        Assert.assertNull(driver.findElement(By.id("navadminsuperview")).getAttribute("href"));

        Cookie existingcookie = driver.manage().getCookieNamed("loggedin");
        driver.manage().deleteCookie(existingcookie);

        driver.manage().addCookie(new Cookie("loggedin", "SuperAdmin"));
        driver.navigate().refresh();
        Assert.assertNotNull(driver.findElement(By.id("navadminsuperview")).getAttribute("href"));

        


    }
}
