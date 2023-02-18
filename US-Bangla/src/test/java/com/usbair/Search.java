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
import java.util.List;

public class Search {

    WebDriver driver;

    @BeforeMethod
    public void SetupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://usbair.com/");
        Thread.sleep(3000);
    }

    public void TakeScreenShot(String fileName) throws IOException {
        // Open the current date and time
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trg = new File("/Users/SQA/Project/Selenium/Project/US-Bangla/ScreenShots/Search/" +fileName+ " " +timeStamp+".png");
        FileUtils.copyFile(src, trg);

    }

    @Test(description = "Search From", priority = 1)
    public void SearchFrom() throws InterruptedException, IOException {

        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal false'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys("Rajshahi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        TakeScreenShot("Search From");
        driver.quit();
    }

    @Test(description = "Search To", priority = 2)
    public void SearchTo() throws InterruptedException, IOException {

        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal text-black/30'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys("doha");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        TakeScreenShot("Search To");
        driver.quit();
    }

    @Test(description = "Trip Type", priority = 3)
    public void TripType() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(),'Round Trip')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[normalize-space()='One Way']")).click();
        Thread.sleep(2000);

        TakeScreenShot("Trip Type");
        driver.quit();
    }

    String dDate = "25";
    String dMonthYear = "May 2023";
    @Test(description = "Departing Date", priority = 4)
    public void DepartingDate() throws IOException {
        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal'])[1]")).click();

        while (true){
            String currentMonth = driver.findElement(By.className("rdrMonthName")).getText();
            if (currentMonth.equals(dMonthYear)){
                break;
            }else {
                driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
            }
        }

        List<WebElement> dayList = driver.findElements(By.xpath("(//div[@class='rdrDays'])[1]//button"));
        for (WebElement day: dayList ) {
            String date = day.getText();
            if (date.equals(dDate)){
                day.click();
                day.sendKeys(Keys.ENTER);
                break;
            }
        }

        TakeScreenShot("Departing Date");
        driver.quit();
    }

    String rMonthYear = "Jun 2023";
    String rDate = "1";
    @Test(description = "Returning Date", priority = 5)
    public void ReturningDate() throws IOException {
        driver.findElement(By.cssSelector("div[class='w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg border-l-0 rounded-r md:rounded-r lg:rounded-none']")).click();

        while (true){
            String currentMonth = driver.findElement(By.className("rdrMonthName")).getText();
            if (currentMonth.equals(rMonthYear)){
                break;
            }else {
                driver.findElement(By.cssSelector("button[class='rdrNextPrevButton rdrNextButton']")).click();
            }
        }

        List<WebElement> dayList = driver.findElements(By.xpath("(//div[@class='rdrDays'])[1]//button"));
        for (WebElement day: dayList) {
            String date = day.getText();
            if (date.equals(rDate)){
                day.click();
                break;
            }
        }
        TakeScreenShot("Returning Date");
        driver.quit();

    }

    @Test(description = "Passenger List", priority = 6)
    public void PassengerList() throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();

        int adult = 3;
        int child = 2;
        int infant = 1;

        //Adult
        for (int i = 1; i<= adult; i++){
            driver.findElement(By.xpath("(//div[@class='border border-secondary-light rounded p-0.5 hover:bg-secondary hover:text-white hover:cursor-pointer'])[2]")).click();
        }
        Thread.sleep(2000);
        TakeScreenShot("Adult Passenger");

        //Child
        for (int i = 1; i<= child; i++){
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3)")).click();
        }
        Thread.sleep(2000);
        TakeScreenShot("Child Passenger");

        //Infant
        for (int i = 1; i<= infant; i++){
            driver.findElement(By.xpath("(//div[contains(@class,'border border-secondary-light rounded p-0.5 hover:bg-secondary hover:text-white hover:cursor-pointer')])[6]")).click();
        }

        Thread.sleep(2000);
        TakeScreenShot("Infant Passenger");

        driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();

        Thread.sleep(2000);
        TakeScreenShot("Passenger List");

        driver.quit();
    }

    @Test(description = "Search Flight", priority = 7)
    public void SearchFlight() throws InterruptedException, IOException {
        //from
        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal false'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys("Rajshahi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //to
        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal text-black/30'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys("doha");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@id='auto_com'])[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //trip type
        driver.findElement(By.xpath("//div[contains(text(),'Round Trip')]")).click();
        Thread.sleep(2000);

        //departing date
        driver.findElement(By.xpath("(//div[@class='font-roboto text-[#333333] text-navBarTitle font-normal'])[1]")).click();

        while (true){
            String currentMonth = driver.findElement(By.className("rdrMonthName")).getText();
            if (currentMonth.equals(dMonthYear)){
                Thread.sleep(2000);
                break;
            }else {
                driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
            }
        }

        List<WebElement> dayList = driver.findElements(By.xpath("(//div[@class='rdrDays'])[1]//button"));
        for (WebElement day: dayList ) {
            String date = day.getText();
            if (date.equals(dDate)){
                day.click();
                Thread.sleep(2000);
                day.sendKeys(Keys.ENTER);
                break;
            }
        }

        //returning date
        driver.findElement(By.cssSelector("div[class='w-full h-[60px] px-4 flex flex-col justify-center border border-[#D7D7D7] hover:bg-input-bg hover:cursor-pointer bg-input-bg border-l-0 rounded-r md:rounded-r lg:rounded-none']")).click();

        while (true){
            String currentMonth = driver.findElement(By.className("rdrMonthName")).getText();
            if (currentMonth.equals(rMonthYear)){
                Thread.sleep(2000);
                break;
            }else {
                driver.findElement(By.cssSelector("button[class='rdrNextPrevButton rdrNextButton']")).click();
            }
        }

        List<WebElement> daysList = driver.findElements(By.xpath("(//div[@class='rdrDays'])[1]//button"));
        for (WebElement day: daysList) {
            String date = day.getText();
            if (date.equals(rDate)){
                Thread.sleep(2000);
                day.click();
                break;
            }
        }

        //passenger
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).click();

        int adult = 3;
        int child = 2;
        int infant = 1;

        //Adult passenger
        for (int i = 1; i< adult; i++){
            driver.findElement(By.xpath("(//div[@class='border border-secondary-light rounded p-0.5 hover:bg-secondary hover:text-white hover:cursor-pointer'])[2]")).click();
        }
        Thread.sleep(2000);

        //Child passenger
        for (int i = 1; i<= child; i++){
            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3)")).click();
        }
        Thread.sleep(2000);

        //Infant passenger
        for (int i = 1; i<= infant; i++){
            driver.findElement(By.xpath("(//div[contains(@class,'border border-secondary-light rounded p-0.5 hover:bg-secondary hover:text-white hover:cursor-pointer')])[6]")).click();
        }
        Thread.sleep(2000);

        //confirm passenger
        driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
        Thread.sleep(2000);

        //Search Button
        driver.findElement(By.xpath("//button[normalize-space()='Search Flights']")).click();

        //Take ScreenShot
        TakeScreenShot("Search Flight");

        driver.quit();
    }

}
