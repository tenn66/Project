package com.github.vitalliuss.helloci;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

    @Test
    public void AddEstimate() throws InterruptedException {
        WebDriver driver = FactoryBrowser.setupBrowser("chrome","https://cloud.google.com/");//we can directly call the class because its static

        // PageFactory.initElements(driver,LoginPageUpdate.class);
        HomePage hurtPageFactory = PageFactory.initElements(driver, HomePage.class);
        //LoginPageUpdate login = new LoginPageUpdate(driver);

        hurtPageFactory.SearchButton("Google Cloud Platform Pricing Calculator");
        hurtPageFactory.CalPage();

        HurtMePlenty cal = PageFactory.initElements(driver, HurtMePlenty.class);
        cal.Compute_Engine("4");
        cal.OS();
        cal.VM_Class();
        cal.Series();
        cal.Instance_Type();
        cal.GPU();
        cal.Local_SSD();
        cal.Location();
        cal.usage();
        cal.Estimate();
        driver.quit();
    }
}
