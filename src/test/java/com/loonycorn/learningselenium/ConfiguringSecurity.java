package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.security.Security;
import org.testng.annotations.Test;

public class ConfiguringSecurity {
    @Test
    public void configuresecuritytest() {

        String base_url = "https://expired.badssl.com";

        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Security.enable());

        devTools.send(Security.setIgnoreCertificateErrors(true));
        driver.get(base_url);



    }
}
