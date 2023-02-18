package com.usbair;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test(description = "Check Setup", priority = 0)
public class Home {

    public  void SetupDriver() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //quit
        driver.quit();
    }


    @Test(description = "Check Title", priority = 1)
    public void Title_Check() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //Check Title
        String ExpectedTitle = "US-Bangla Airlines | US-Bangla Airlines";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle,ExpectedTitle);

        //Quit
        driver.quit();
    }

    @Test(description = "Check Url", priority = 2)
    public void Check_Url() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //Check Url
        String ExpectedUrl = "https://usbair.com/";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl, ExpectedUrl);

        //Quit
        driver.quit();
    }

    @Test(description = "isDisplay Flight To", priority = 3)
    public void isDisplayFlightTo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Flight To
        WebElement flightTo = driver.findElement(By.xpath("(//div[contains(@class,'font-roboto text-[#333333] text-navBarTitle font-normal text-black/30')])[1]"));
        boolean isDesplayedFlightTo = flightTo.isDisplayed();
        if (isDesplayedFlightTo){
            System.out.println("Flight to is Displayed");
        }else {
            System.out.println("Flight to is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "isDisplay Trip Type", priority = 4)
    public void isDisplayTripType() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Trip Type
        WebElement tripType = driver.findElement(By.xpath("(//div[contains(@class,'w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg rounded md:rounded-r lg:rounded-none md:border-r')])[1]"));
        boolean isDesplayedTripType = tripType.isDisplayed();
        if (isDesplayedTripType){
            System.out.println("Trip type is Displayed");
        }else {
            System.out.println("Trip type is not Displayed");
        }
        //Quit
        driver.quit();
    }


    @Test(description = "isDisplay Departing Date", priority = 5)
    public void isDisplayDepartingDate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Departing Date
        WebElement departingDate = driver.findElement(By.xpath("(//div[contains(@class,'w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg rounded-l lg:rounded-none md:rounded-l sm:rounded-none')])[1]"));
        boolean isDesplayedDepartingDate = departingDate.isDisplayed();
        if (isDesplayedDepartingDate){
            System.out.println("Departing date is Displayed");
        }else {
            System.out.println("Departing date is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "isDisplay Returning Date", priority = 6)
    public void isDisplayReturningDate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Returning Date
        WebElement returningDate = driver.findElement(By.xpath("(//div[@class='w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg border-l-0 rounded-r md:rounded-r lg:rounded-none'])[1]"));
        boolean isDesplayedReturningDate = returningDate.isDisplayed();
        if (isDesplayedReturningDate){
            System.out.println("Returning date is Displayed");
        }else {
            System.out.println("Returning date is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "isDisplay passenger", priority = 7)
    public void isDisplayPassenger() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Flight From
        WebElement passanger = driver.findElement(By.xpath("(//div[contains(@class,'font-roboto text-[#333333] text-navBarTitle font-normal false')])[1]"));
        boolean isDesplayedPassenger = passanger.isDisplayed();
        if (isDesplayedPassenger){
            System.out.println("Passenger is Displayed");
        }else {
            System.out.println("Passenger is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "isDisplay_Search Button", priority = 8)
    public void isDisplay_Search() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplay Search Button
        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='Search Flights']"));
        boolean isDesplayedSearch = searchButton.isEnabled();
        if (isDesplayedSearch){
            System.out.println("Search Button is Displayed");
        }else {
            System.out.println("Search Button is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "isSearch Button Enable", priority = 9)
    public void isSearchButtonEnable() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Flight From
        WebElement searchButton = driver.findElement(By.xpath("(//div[contains(@class,'font-roboto text-[#333333] text-navBarTitle font-normal false')])[1]"));
        boolean isSearchButtonEnable = searchButton.isEnabled();
        if (isSearchButtonEnable){
            System.out.println("Search button is Enabled");
        }else {
            System.out.println("Search button is not Enabled");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "Logo", priority = 10)
    public void isDisplayLogo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //isDisplayed Flight From
        WebElement logo = driver.findElement(By.xpath("//img[@alt='US-Bangla Airlines']"));
        boolean isDesplayedLogo = logo.isDisplayed();
        if (isDesplayedLogo){
            System.out.println("Logo is Displayed");
        }else {
            System.out.println("Logo is not Displayed");
        }
        //Quit
        driver.quit();
    }

    @Test(description = "Click Logo", priority = 11)
    public void isClickLogo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //max window
        driver.manage().window().maximize();

        //get url
        driver.get("https://usbair.com/");
        Thread.sleep(5000);

        //Click Logo
        driver.findElement(By.xpath("//img[@alt='US-Bangla Airlines']")).click();
        String ExpectedTitle = "US-Bangla Airlines";
        if (driver.getTitle().equals(ExpectedTitle)){
            System.out.println("We are back at US Babgla's homepage");
        }else {
            System.out.println("We are not at US Babgla's homepage");
        }
        //Quit
        driver.quit();
    }


}
