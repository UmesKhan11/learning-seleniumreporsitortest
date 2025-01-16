package com.loonycorn.learningselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;
import java.time.Duration;

public class ExploringRobotClass {

    private static final String base_url = "https://testpages.eviltester.com/styled/index.html";

    @Test
    public void ExploringRobotClass() {
        WebDriver driver = new ChromeDriver();
        driver.get(base_url);
        driver.manage().window().maximize();
        delay(5000);
        Robot robot = null;
        try {
            robot = new Robot();  // Initialize Robot
        } catch (AWTException e) {
            e.printStackTrace();
            return;  // Return if Robot creation fails
        }
        robot.mouseWheel(5);
        delay(5000);

        // Wait until the "HTML Form Example" link is visible and clickable
        WebElement form = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("htmlformtest")));

        // Get the location of the element on the screen
        Point location = form.getLocation();
        int x = location.getX();
        int y = location.getY();

        // Move the mouse to the position of the element
        robot.mouseMove(x, y);
        delay(1000);  // Delay to allow any animations or transitions

        // Simulate clicking the element
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // Wait for the username input field to be visible and interactable
        WebElement user = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("username")));
        user.click();

        // Simulate typing 'U' using Robot
        robot.keyPress(KeyEvent.VK_U);
        robot.keyRelease(KeyEvent.VK_U);
        delay(500);  // Slight delay betwen keypresses for a more natural effect

        // Simulate scrolling up and down with the mouse wheel
        robot.mouseWheel(-3);  // Scroll down
        robot.mouseWheel(3);   // Scroll up
    }

    // Method to introduce a delay (in milliseconds)
    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred during delay");
            e.printStackTrace();
        }
    }
}
