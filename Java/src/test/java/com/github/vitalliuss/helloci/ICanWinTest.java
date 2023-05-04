package com.github.vitalliuss.helloci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ICanWinTest {
    WebDriver driver;
    @BeforeClass
    void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
    }
    @Test ( priority = 1)
    void NewPaste() throws InterruptedException {

        ICanWin helloWeb= new ICanWin(driver);
        helloWeb.Code("Hello from WebDriver");
        helloWeb.pasteExpiration();
        helloWeb.PasteName("helloweb");
        helloWeb.CreatedPaste();
        driver.quit();
    }
}
