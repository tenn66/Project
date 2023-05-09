package com.github.vitalliuss.helloci;

import browser.FactoryBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HurtMePlentyTest {
    WebDriver driver;
    HomePage homepage;
    HurtMePlenty hurtMePlenty;

    @Test(groups = {"functional","smoke"}, priority = 1)
    public void environment(){
        driver = FactoryBrowser.setupBrowser("chrome","https://cloud.google.com/");
        homepage = PageFactory.initElements(driver, HomePage.class);
        hurtMePlenty = PageFactory.initElements(driver, HurtMePlenty.class);

    }
    @Test(groups = {"functional","smoke"}, priority = 2)
    public void homePageTest() throws InterruptedException
    {
        homepage.SearchButton("Google Cloud Platform Pricing Calculator");
        homepage.CalPage();
    }
    @Test(groups = {"smoke"}, priority = 3)
    public void NoOfInstance() throws InterruptedException {
        hurtMePlenty.NoOfInstance();
    }
    @Test(groups = {"smoke"}, priority = 4)
    public void OS() throws InterruptedException {
        hurtMePlenty.setOS();
    }
    @Test(groups = {"smoke"}, priority = 5)
    public void VM_Class() throws InterruptedException {
        hurtMePlenty.VM_Class();
    }
    @Test(groups = {"smoke"}, priority = 6)
    public void Series() throws InterruptedException {
        hurtMePlenty.Series();
    }
    @Test(groups = {"smoke"}, priority = 7)
    public void Instance_Type() throws InterruptedException {
        hurtMePlenty.Instance_Type();
    }
    @Test(groups = {"smoke"}, priority = 8)
    public void GPU() throws InterruptedException {
        hurtMePlenty.GPU();
    }
    @Test(groups = {"smoke"}, priority = 9)
    public void Local_SSD() throws InterruptedException {
        hurtMePlenty.Local_SSD();
    }
    @Test(groups = {"smoke"}, priority = 10)
    public void Location() throws InterruptedException {
        hurtMePlenty.Location();
    }
    @Test(groups = {"smoke"}, priority = 11)
    public void usage() throws InterruptedException {
        hurtMePlenty.usage();
    }
    @Test(groups = {"smoke"}, priority = 12)
    public void Estimate() throws InterruptedException {
        hurtMePlenty.Estimate();
    }
    @Test(groups = {"smoke"}, priority = 12)
    public void closeDriver() throws InterruptedException {
        homepage.closeDrive();
    }

    @AfterMethod(groups = {"smoke"})
    void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Create the screenshot object
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            // Take the screenshot as a file
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            try { // Create a destination file with the current date and time as the filename
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                String fileName = "screenshot" + dateFormat.format(new Date()) + ".png";
                File destination = new File("/Users/tenzinwangmo/Desktop/JLPT" + fileName);
                // Copy the source file to the destination file
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken and saved to: " + source + "  --->  " + destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

/*
    @Test
    public void AddEstimate() throws InterruptedException {
        WebDriver driver = FactoryBrowser.setupBrowser("chrome","https://cloud.google.com/");//we can directly call the class because its static

        // PageFactory.initElements(driver,LoginPageUpdate.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        //LoginPageUpdate login = new LoginPageUpdate(driver);

        homePage.SearchButton("Google Cloud Platform Pricing Calculator");
        homePage.CalPage();

        HurtMePlenty hurtMePlenty = PageFactory.initElements(driver, HurtMePlenty.class);
        hurtMePlenty.NoOfInstance("4");
        hurtMePlenty.OS();
        hurtMePlenty.VM_Class();
        hurtMePlenty.Series();
        hurtMePlenty.Instance_Type();
        hurtMePlenty.GPU();
        hurtMePlenty.Local_SSD();
        hurtMePlenty.Location();
        hurtMePlenty.usage();
        hurtMePlenty.Estimate();
        driver.quit();
    }

     */

}
