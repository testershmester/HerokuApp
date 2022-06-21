package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.time.Duration;

import static org.testng.Assert.assertFalse;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void notificationMessagesTest() {
        driver.findElement(By.linkText("Notification Messages")).click();
        driver.findElement(By.className("close")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("flash")));
        assertFalse(CollectionUtils.hasElements(driver.findElements(By.id("flash"))));
        driver.findElement(By.linkText("Click here")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));

        driver.navigate().back();
    }
}
