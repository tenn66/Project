package com.github.vitalliuss.helloci;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;
    @FindBy( xpath= "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")
    WebElement search;
    @FindBy( xpath = "//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a/b")
    WebElement calpage;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void SearchButton(String nname) throws InterruptedException {
        search.click();
        Thread.sleep(2000);
        search.sendKeys(nname);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(9000);

    }
    public void CalPage() throws InterruptedException {
        calpage.click();
        Thread.sleep(2000);

    }

}
