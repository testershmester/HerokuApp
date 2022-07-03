package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.findElement(By.linkText("Context Menu")).click();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).build().perform();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text, "You selected a context menu");
        driver.navigate().back();
    }
}
