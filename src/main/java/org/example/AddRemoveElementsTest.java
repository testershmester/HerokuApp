package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemoveTest() {
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 2, "There are two elements should be added");
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        List<WebElement> deleteButton = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButton.size(), 1, "Only one button should left");
        driver.navigate().back();
    }
}
