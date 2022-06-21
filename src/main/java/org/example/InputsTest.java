package org.example;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InputsTest extends BaseTest {

    @Test
    public void inputsTest() {
        driver.findElement(By.linkText("Inputs")).click();
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_UP);

        driver.navigate().back();
    }
}
