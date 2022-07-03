package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

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
        File folder = new File(System.getProperty("user.dir"));
        //List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        for (
                File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fn = listOfFile.getName();
                if (fn.equals(fileName)) {
                    f = new File(fn);
                    found = true;
                }
            }
        }

        assertTrue(found, "Downloaded document is not found!");
        f.deleteOnExit();
        driver.navigate().back();
    }
}
