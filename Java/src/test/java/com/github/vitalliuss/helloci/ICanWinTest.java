package com.github.vitalliuss.helloci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICanWinTest {
    WebDriver driver;
    @Test
    void NewPaste() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize(); //Full screen.

        ICanWin helloWeb= new ICanWin(driver);
        helloWeb.Code("Hello from WebDriver");
        helloWeb.pasteExpiration();
        helloWeb.PasteName("helloweb");
        helloWeb.CreatedPaste();
        driver.quit();
    }
}
