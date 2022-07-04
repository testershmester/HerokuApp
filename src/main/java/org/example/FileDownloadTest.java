package org.example;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    //Find file on UI
    @Test
    public void fileDownloadUiTest() {
        driver.findElement(By.linkText("File Download")).click();
        String fileName = "some-file.txt";
        driver.findElement(By.xpath("//a[text()='" + fileName + "']")).click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("chrome://downloads/");

        WebElement shadowHost1 = driver.findElement(By.cssSelector("downloads-manager"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("downloads-item"));
        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();

        WebElement show = shadowRoot2.findElement(By.id("show"));
        String title = show.getAttribute("title");
        File file = new File(title);
        assertTrue(file.exists());
        driver.navigate().back();
    }

    @Test
    public void fileDownloadTest() {
        driver.findElement(By.linkText("File Download")).click();
        String fileName = "some-file.txt";
        driver.findElement(By.xpath("//a[text()='" + fileName + "']")).click();
        File fileToCheck = new File(System.getProperty("user.dir") + "/" + fileName);
        wait.until((WebDriver wd) -> fileToCheck.exists());
        assertTrue(fileToCheck.exists(), "Downloaded document is not found!");
        fileToCheck.deleteOnExit();
        driver.navigate().back();
    }
}
