package com.loonycorn.learningselenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test
 public class WebDriverTest  {

    private static final String SITE = "https://www.google.com";
    private static final String ABOUT = "https://about.google/";

    public void navigatetopageusingchrome()  {
        WebDriver driver = new ChromeDriver();

        driver.get(SITE);
        driver.navigate().to(ABOUT);
        Assert.assertEquals(driver.getTitle(),
                "Google - About Google, Our Culture & Company News");

        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),"Google");
    }
}



//    @Test(description = "Manually using chrome driver")
//    public void navigatetopagemanually()  {
//    System.setProperty("webdriver.chromedriver","/Users/Umes/chromedriver-win64/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//    }
