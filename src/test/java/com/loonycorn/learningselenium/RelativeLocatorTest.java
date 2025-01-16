package com.loonycorn.learningselenium;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RelativeLocatorTest {

    private static final String Base_Url = "https://testpages.eviltester.com";

    @Test
    public void RelativeLocatorTest() {
        WebDriver driver = new ChromeDriver();

        driver.get(Base_Url);

        WebElement elm_htmlform = driver.findElement(By.linkText("HTML Form Example"));
        elm_htmlform.click();

        WebElement elm_user = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input"));
        elm_user.sendKeys("username");

        WebElement elm_pass = driver.findElement(RelativeLocator.with(By.tagName("input")).below(elm_user));
        elm_pass.sendKeys("pwd1");

        WebElement elm_cmt = driver.findElement(RelativeLocator.with(By.name("comments")).near(elm_pass));
        elm_cmt.clear();
        elm_cmt.sendKeys("COmments");

        WebElement elm_can = driver.findElement(By.cssSelector("input[value='cancel']"));
        WebElement ele_submit = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(elm_can));
        ele_submit.submit();

        WebElement elm_useridvalue = driver.findElement(By.cssSelector("#_valueusername"));
        Assert.assertEquals(elm_useridvalue.getText(),"username");
    }
}
