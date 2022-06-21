package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest extends BaseTest {

    @Test
    public void hoversTest() {
        driver.findElement(By.linkText("Hovers")).click();
        List<WebElement> avatars = driver.findElements(By.cssSelector("img[alt=\"User Avatar\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(avatars.get(0)).build().perform();
        driver.findElement(By.linkText("View profile")).click();
        driver.navigate().back();
    }
}
