package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicControlTest extends BaseTest {

    @Test
    public void dynamicControlTest() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));

        List<WebElement> checkbox = driver.findElements(By.id("checkbox"));
        driver.navigate().back();
    }

    @Test
    public void dynamicControlInputTest() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        WebElement element = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        Assert.assertFalse(element.isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));

        Assert.assertTrue(element.isEnabled());
        driver.navigate().back();
    }
}
