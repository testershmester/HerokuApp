package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTest {
    @Test
    public void dropDownTest() {
        driver.findElement(By.linkText("Dropdown")).click();
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        assertEquals(dropDown.getOptions().get(0).getText(), "Please select an option");
        assertEquals(dropDown.getOptions().get(1).getText(), "Option 1");
        assertEquals(dropDown.getOptions().get(2).getText(), "Option 2");
        dropDown.selectByVisibleText("Option 1");
        assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 1", "Option 1 should be selected");
        dropDown.selectByVisibleText("Option 2");
        assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 2", "Option 2 should be selected");
        driver.navigate().back();
    }
}
