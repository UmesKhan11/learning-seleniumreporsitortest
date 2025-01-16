package com.loonycorn.learningselenium;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;


public class WorkingwithCookies {
    private static final String base_url = "https://testpages.eviltester.com/styled/cookies/adminlogin.html";

    @Test
    public void WorkingWithCookies() {
        WebDriver driver = new ChromeDriver();

        driver.get(base_url);
        driver.manage().window().maximize();

        String[] cookienames = {"sessionid","userid","authid"};
        String[] cookievalues = {"abc123","user123","auth123"};

        for (int i=0 ; i < cookienames.length ; i++) {
            Cookie newcookie = new Cookie (cookienames[i],cookievalues[i]);
            driver.manage().addCookie(newcookie);
        }

        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println("Cookies " + cookies);


        for (Cookie cookie : cookies) {

            System.out.println("Cookie Domain:" + cookie.getDomain());
            System.out.println("Cookie Path:" + cookie.getPath());
            System.out.println("Cookie Same site:" + cookie.getSameSite());
            System.out.println("Is Cookie Secure:" + cookie.isSecure());
            System.out.println("Is Cookie HttpOnly:" + cookie.isHttpOnly());
        }

    }
}
