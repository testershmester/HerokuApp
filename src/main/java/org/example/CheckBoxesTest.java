package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {

    @Test
    public void checkBoxesTest() {
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[type=checkbox]"));
        WebElement firstCheckBox = elements.get(0);
        WebElement secondCheckBox = elements.get(1);
        assertFalse(firstCheckBox.isSelected(), "The first checkbox should be unselected");
        assertTrue(secondCheckBox.isSelected(), "The second checkbox should be selected");
        firstCheckBox.click();
        assertTrue(firstCheckBox.isSelected(), "The first checkbox should be selected after click");
        secondCheckBox.click();
        assertFalse(secondCheckBox.isSelected(), "The second checkbox should be unselected after click");
        driver.navigate().back();
    }
}
