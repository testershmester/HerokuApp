package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        String text = driver.findElement(By.id("tinymce")).findElement(By.cssSelector("p")).getText();
        assertEquals(text, "Your content goes here.");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("button[title='Align center']")).click();
        driver.navigate().back();
    }
}
