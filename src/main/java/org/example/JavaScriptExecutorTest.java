package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void javaScriptExampleTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector("a[href='/windows']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight);", element);
    }
}
