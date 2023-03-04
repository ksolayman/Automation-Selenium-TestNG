package com.usbair;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Login {

    WebDriver driver;
    String url = "https://usbair.com/";
    String clickLogin = "(//p[@class='font-normal font-roboto text-footerDescriptionBottomPart'])[1]";
    String skyStar = "(//div[normalize-space()='Sky Star'])[1]";
    String ssLoc = System.getProperty("user.dir")+"/ScreenShots/Login/";

    @BeforeMethod
    public void LunchBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);
        Thread.sleep(3000);

        driver.findElement(By.xpath(clickLogin)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(skyStar)).click();
        Thread.sleep(2000);
    }


    public void TakeSS(String fileName) throws IOException {
        // Open the current date and time
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trg = new File( ssLoc + fileName + " " + timeStamp + ".png");
        FileUtils.copyFile(src, trg);

    }


    @Test(description = "Login as SkyStar", priority = 0)
     void LogSkyStar() throws IOException {

        TakeSS("Login as SkyStar");

        driver.quit();

    }

    @Test(description = "Login Name", priority = 2)
     void LogUserSkyStar() throws InterruptedException, IOException {

        driver.findElement(By.xpath("//input[@id='Login']")).sendKeys("kSabuz");
        Thread.sleep(2000);

        TakeSS("Login Name");

        driver.quit();
    }

    @Test(description = "Login Password", priority = 3)
     void LogPassSkyStar() throws InterruptedException, IOException {

        driver.findElement(By.id("Password")).sendKeys("s@buz123");
        Thread.sleep(5000);

        TakeSS("Login Password");

        driver.quit();
    }

    @Test(description = "Login Button Enable", priority = 4)
     void SkyStarLogBtnEnable() throws InterruptedException {

        WebElement logEnable = driver.findElement(By.id("btnLoginAction"));
        boolean isLogBtnEnable = logEnable.isEnabled();
        if (isLogBtnEnable) {
            System.out.println("Login button is Enable");
        } else {
            System.out.println("Login button is not Enable");
        }
        Thread.sleep(2000);

        driver.quit();
    }


    @Test(description = "Login Submit", priority = 5)
     void LogButtonSkyStar() throws InterruptedException, IOException {

        driver.findElement(By.id("btnLoginAction")).click();
        Thread.sleep(3000);

        TakeSS("LoginSubmit");

        driver.quit();
    }

    @Test(description = "Forget Password Enable", priority = 6)
     void SkyStarForgetPassEnable() throws InterruptedException, IOException {

        WebElement forgetEnable = driver.findElement(By.linkText("Forgot password"));
        boolean isForgetEnable = forgetEnable.isEnabled();
        if (isForgetEnable) {
            System.out.println("Forget link is Enable");
        } else {
            System.out.println("Forget link is not Enable");
        }
        Thread.sleep(5000);

        TakeSS("Enable Forger");

        driver.quit();
    }

    @Test(description = "Create a new  account Enable", priority = 7)
     void SkyStarNewAccEnable() throws InterruptedException, IOException {

        WebElement forgetEnable = driver.findElement(By.linkText("Create a new profile"));
        boolean isForgetEnable = forgetEnable.isEnabled();
        if (isForgetEnable) {
            System.out.println("Create a new profile is Enable");
        } else {
            System.out.println("Create a new profile is not Enable");
        }
        Thread.sleep(2000);

        TakeSS("New Account");

        driver.quit();
    }

    @Test(description = "Move to Signup as SkyStar", priority = 8)
     void MoveSignUpAsSkyStar() throws InterruptedException, IOException {

        driver.findElement(By.linkText("Create a new profile")).click();
        Thread.sleep(3000);

        TakeSS("Move to Signup page");

        driver.quit();
    }

    @Test(description = "Login Warning", priority = 9)
     void LogWarning() throws InterruptedException, IOException {

        driver.findElement(By.id("btnLoginAction")).click();
        Thread.sleep(3000);

        String warning = "The Login field is required.";
        String text = driver.findElement(By.id("Login-error")).getText();
        if (text.equals(warning)) {
            System.out.println("Show Warning Message");
        } else {
            System.out.println("Error! Warning Message Missing");
        }

        TakeSS("Login Warning");

        driver.quit();
    }


}
