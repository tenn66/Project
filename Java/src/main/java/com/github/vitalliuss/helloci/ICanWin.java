package com.github.vitalliuss.helloci;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ICanWin {
    WebDriver driver;
    By newpaste1 = By.xpath("//*[@id=\"postform-text\"]");
    By pasteexpiration1 = By.xpath("//span[@id='select2-postform-expiration-container']");
    By exp10 = By.xpath("//li[@class='select2-results__option']");
    By pastename1 = By.xpath("//input[@id='postform-name']");
    By createname1 = By.xpath("//button[normalize-space()='Create New Paste']");

    public ICanWin(WebDriver driver){
        this.driver = driver;
    }

    public void Code(String nname) throws InterruptedException {
        driver.findElement(newpaste1).sendKeys(nname);
        Thread.sleep(2000);
    }
    public void pasteExpiration() throws InterruptedException {

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);

        WebElement pasteExpiration = driver.findElement(pasteexpiration1);
        pasteExpiration.click();
        Thread.sleep(2000);
        List<WebElement> options = pasteExpiration.findElements(exp10);
        options.get(1).click();
        Thread.sleep(2000);
    }
    public void PasteName(String pname) throws InterruptedException {
        driver.findElement(pastename1).sendKeys(pname);
        Thread.sleep(2000);
    }
    public void CreatedPaste() throws InterruptedException {
        driver.findElement(createname1).click();
        Thread.sleep(2000);

    }
}
