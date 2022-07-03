package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTest extends BaseTest {

    @Test
    public void alertsTest() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        assertEquals(result, "You successfully clicked an alert");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        result = driver.findElement(By.id("result")).getText();
        assertEquals(result, "You clicked: Cancel");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Text");
        alert.accept();
        result = driver.findElement(By.id("result")).getText();
        assertEquals(result, "You entered: Text");
    }
}
