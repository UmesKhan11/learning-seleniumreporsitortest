package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeDevTools {

    private static final String base_url = "https://www.saucedemo.com" ;

    @Test
    public void CaptureNetworkRequest () {
        WebDriver driver = new ChromeDriver() ;

        DevTools devtools = ((ChromeDriver) driver).getDevTools();
        devtools.createSession();
        List<Request> capturedrequest = new CopyOnWriteArrayList<>();

        devtools.send(Network.enable(Optional.empty(),
                        Optional.empty(),Optional.empty()));

        devtools.addListener(Network.requestWillBeSent() , request ->
        {
            capturedrequest.add(request.getRequest());
        });

        driver.get(base_url);

        Assert.assertFalse(capturedrequest.isEmpty(), "No captured request");

        for (Request request : capturedrequest) {
            System.out.println("Request Url: " + request.getUrl());
            System.out.println("Request Method: " + request.getMethod());
            System.out.println("--------------------------");
        }
    }

}
