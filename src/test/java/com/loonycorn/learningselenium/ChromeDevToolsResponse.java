package com.loonycorn.learningselenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ChromeDevToolsResponse {
    private static final String base_url = "https://www.saucedemo.com/";
    @Test
    public void DevToolsResponse() {
        WebDriver driver = new ChromeDriver();
        DevTools devtools = ((ChromeDriver) driver).getDevTools();
        devtools.createSession();

        devtools.send(Network.enable(Optional.empty(),
                Optional.empty(),Optional.empty()));

        List<Response> capturedresponses = new CopyOnWriteArrayList<>();

        devtools.addListener(Network.responseReceived() , response ->{
            capturedresponses.add(response.getResponse());
        });

        driver.get(base_url);

        for (Response response : capturedresponses) {
            System.out.println("Response Url " + response.getUrl());
            System.out.println("Response Status " + response.getStatus());
        }

        Assert.assertFalse(capturedresponses.isEmpty(),"No Response captured");


    }

}
