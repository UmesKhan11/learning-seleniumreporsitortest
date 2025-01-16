package com.loonycorn.learningselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ActionsAPIKeyboad {

    private static final String base_url = "https://testpages.eviltester.com";

    @Test
    public void ActionsAPIKeyboad() {
       WebDriver driver =new ChromeDriver();
       driver.get(base_url);
       driver.manage().window().maximize();

       WebElement htmlform = driver.findElement(By.linkText("HTML Form Example"));
       htmlform.click();

       WebElement user = driver.findElement(By.name("username"));
       WebElement pass = driver.findElement(By.name("password"));
       WebElement comment = driver.findElement(By.name("comments"));

       Actions actions = new Actions(driver);
       
       actions.sendKeys(user,"Username")
               .keyDown(Keys.SHIFT)
               .sendKeys(user, " capital")
               .sendKeys(Keys.ARROW_UP)
               .keyUp(Keys.SHIFT)
               .keyDown(Keys.CONTROL)
               .sendKeys("c")
               .keyUp(Keys.CONTROL)
               .sendKeys(pass,"Juter")
               .sendKeys(Keys.ARROW_LEFT,Keys.ARROW_LEFT,Keys.ARROW_LEFT,Keys.ARROW_LEFT,
                       Keys.ARROW_LEFT)
               .sendKeys(pass, "bug ")
               .sendKeys(comment, "")
               .keyDown(Keys.CONTROL)
               .sendKeys("v")
               .keyUp(Keys.CONTROL)
               .perform();

       WebElement rd1 = driver.findElement(By.cssSelector("input[value=rd1]"));
       WebElement rd2 = driver.findElement(By.cssSelector("input[value=rd2]"));
       WebElement rd3 = driver.findElement(By.cssSelector("input[value=rd3]"));

       System.out.println("-----Before Clicking-----");
       System.out.println("Radio Button 1" + rd1.isSelected());
       System.out.println("Radio Button 2" + rd2.isSelected());
       System.out.println("Radio Button 3" + rd3.isSelected());

        rd3.click();

        System.out.println("-----After Clicking-----");
        System.out.println("Radio Button 1" + rd1.isSelected());
        System.out.println("Radio Button 2" + rd2.isSelected());
        System.out.println("Radio Button 3" + rd3.isSelected());




    }
}
