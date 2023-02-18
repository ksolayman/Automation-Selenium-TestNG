package com.usbair;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccount {

    WebDriver driver;

    @BeforeMethod
    public void LunchBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://usbair.com/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//p[@class='font-normal font-roboto text-footerDescriptionBottomPart'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[normalize-space()='Sky Star'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Create a new profile")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void EndSession() {
        driver.quit();
    }
    public void TakeSS(String fileName) throws IOException {
        // Open the current date and time
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trg = new File("/Users/SQA/Project/Selenium/Project/US-Bangla/ScreenShots/Signup/" +fileName+ " " +timeStamp+".png");
        FileUtils.copyFile(src, trg);

    }

    @Test(description = "Setup Browser", priority = 1)
    public  void SetupBrowser() throws InterruptedException, IOException {
        driver.navigate().back();
        Thread.sleep(2000);

        TakeSS("Setup Browser");
    }

    @Test(description = "Reg as SkyStar", priority = 2)
    public  void RegSS() throws InterruptedException, IOException {

        TakeSS("Reg as SkyStar");
    }

    @Test(description = "SkyStar Login", priority = 3)
    public  void SSLogin() throws InterruptedException, IOException {


// Your login may not exceed 20 characters
        //only alphabate
        driver.findElement(By.id("Login")).sendKeys("Kabir Koirala");
        //alphanumeric
//        driver.findElement(By.id("Login")).sendKeys("Kabir123");
//        //alphanumeric
//        driver.findElement(By.id("Login")).sendKeys("123Kabir");
//        //only numeric
//        driver.findElement(By.id("Login")).sendKeys("123456");
//        //with special char
//        driver.findElement(By.id("Login")).sendKeys("abc123@@!");
//        //error input
//        driver.findElement(By.id("Login")).sendKeys("123456789qwertyuiopasdfghjkl");

        Thread.sleep(3000);

        TakeSS("SkyStar Login");
    }

    @Test(description = "SkyStar Password", priority = 4)
    public  void SSPassword() throws InterruptedException, IOException {

// Your password
        //only alphabate
//        driver.findElement(By.id("Password")).sendKeys("KabirKoirala");
//        //alphanumeric
//        driver.findElement(By.id("Password")).sendKeys("Kabir123");
//        //alphanumeric
//        driver.findElement(By.id("Password")).sendKeys("123Kabir");
//        //only numeric
//        driver.findElement(By.id("Password")).sendKeys("123456");
//        //with special char
        driver.findElement(By.id("Password")).sendKeys("abc123@@!");

        Thread.sleep(3000);

        TakeSS("Skystar Password");
    }

    @Test(description = "SkyStar Password Confirm", priority = 5)
    public  void SSCPassword() throws InterruptedException, IOException {

// Your Password Confirm
//        //only alphabate
//        driver.findElement(By.id("PasswordConfirm")).sendKeys("KabirKoirala");
//        //alphanumeric
//        driver.findElement(By.id("PasswordConfirm")).sendKeys("Kabir123");
//        //alphanumeric
//        driver.findElement(By.id("PasswordConfirm")).sendKeys("123Kabir");
//        //only numeric
//        driver.findElement(By.id("PasswordConfirm")).sendKeys("123456");
//        //with special char
        // password
        driver.findElement(By.id("Password")).sendKeys("abc123@@!");
        // confirm password
        driver.findElement(By.id("PasswordConfirm")).sendKeys("abc123@@!");
        //error password
//        driver.findElement(By.id("PasswordConfirm")).sendKeys("fakirkoirala");

        Thread.sleep(3000);

        TakeSS("Confirm Password");
    }

    @Test(description = "SkyStar Title", priority = 6)
    public  void SSTitle() throws InterruptedException, IOException {

// Your Title
//        String t1 = "Mr.";
//        String t2 = "Mrs.";
//        String t3 = "Miss";
//        String t4 = "Child";
//        String t5 = "Ms.";
        String t6 = "Mstr.";

        WebElement element = driver.findElement(By.id("Civility"));
        Select title = new Select(element);
        title.selectByVisibleText(t6);

        Thread.sleep(5000);

        TakeSS("Skystar Title");
    }

    @Test(description = "SkyStar Surname", priority = 7)
    public  void SSSurname() throws InterruptedException, IOException {

// Your Surname
        driver.findElement(By.id("Surname")).sendKeys("Koirala");
        Thread.sleep(5000);

        TakeSS("Skystar  Surname");
    }

    @Test(description = "SkyStar FirstName", priority = 8)
    public  void SSFirstName() throws InterruptedException, IOException {

// Your FristName
        driver.findElement(By.name("FirstName")).sendKeys("Kabir");
        Thread.sleep(5000);

        TakeSS("Skystar FirstNane");
    }

    @Test(description = "SkyStar EmailAddress", priority = 9)
    public  void SSEmailAddress() throws InterruptedException, IOException {

// Your EmailAddress

//        //invalid email format
//        driver.findElement(By.id("EmailAddress")).sendKeys("koilaragmail.com");
//        driver.findElement(By.id("EmailAddress")).sendKeys("koilara@gmail");
//        driver.findElement(By.id("EmailAddress")).sendKeys("koilara@gmailcom");
//        //valid email format
        driver.findElement(By.id("EmailAddress")).sendKeys("koilara@gmail.com");

        Thread.sleep(5000);

        TakeSS("Email Address");
    }


    @Test(description = "SkyStar BirthDate", priority = 10)
    public  void SSBirthDate() throws InterruptedException, IOException {

// Your BirthDate
        driver.findElement(By.id("BirthDate")).sendKeys("29/02/1996");
        driver.findElement(By.id("BirthDate")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        TakeSS("Birthday");

    }

    @Test(description = "SkyStar Phone", priority = 11)
    public  void SSPhone() throws InterruptedException, IOException {

// Your phone
        driver.findElement(By.id("PhoneNumberMobile")).sendKeys("01711122233");
        Thread.sleep(5000);

        TakeSS("Phone");
    }

    @Test(description = "SkyStar CheckBox", priority = 12)
    public  void SSCheckBox() throws InterruptedException, IOException {

// Your Checkbox
        driver.findElement(By.xpath("(//div[@class='col-md-1 col-sm-1 col-xs-1 mt-10'])[1]")).click();
        Thread.sleep(5000);

        TakeSS("Check Box");
    }

    @Test(description = "SkyStar Enable Submit", priority = 13)
    public  void SSSubmitEnable() throws InterruptedException, IOException {

// Your Submit Button Enable

        WebElement submitButton = driver.findElement(By.id("btnCreateAction"));
        boolean isSubmitButtonEnable = submitButton.isEnabled();
        if (isSubmitButtonEnable){
            System.out.println("Search button is Enabled");
        }else {
            System.out.println("Search button is not Enabled");
        }
        Thread.sleep(5000);

        TakeSS("Enable Submit Button");
    }

    @Test(description = "Check Link", priority = 14)
    public  void SSSignupLink() throws InterruptedException, IOException {

        //Check SignUp Link
        String ExpectedTitle1 = "Sign Up";
        String ExpectedTitle2 = "Create Account";
        String ExpectedTitle3 = "Signup";
        String ExpectedTitle4 = "Create a new account";
        if (driver.getTitle().equalsIgnoreCase(ExpectedTitle1)|| driver.getTitle().equalsIgnoreCase(ExpectedTitle2) ||
                driver.getTitle().equalsIgnoreCase(ExpectedTitle3)|| driver.getTitle().equalsIgnoreCase(ExpectedTitle4)){
            System.out.println("Link is expected");
        }else {
            System.out.println("Link is not expected");
        }

        TakeSS("Check Link");
    }

    @Test(description = "SkyStar SubmitFrom", priority = 15)
    public  void SSSubmitFrom() throws InterruptedException, IOException {

//Login
        driver.findElement(By.id("Login")).sendKeys("kSabuz");
        Thread.sleep(2000);
//passwoed
        driver.findElement(By.id("Password")).sendKeys("s@buz123");
        Thread.sleep(2000);
//confirm passwoed
        driver.findElement(By.id("PasswordConfirm")).sendKeys("s@buz123");
        Thread.sleep(2000);
//Title
        String t1 = "Mr.";
        WebElement element = driver.findElement(By.id("Civility"));
        Select title = new Select(element);
        title.selectByVisibleText(t1);
        Thread.sleep(2000);
//SurName
        driver.findElement(By.id("Surname")).sendKeys("Khan");
        Thread.sleep(2000);
//First Name
        driver.findElement(By.name("FirstName")).sendKeys("Sabuz");
        Thread.sleep(2000);
//Email
        driver.findElement(By.id("EmailAddress")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
//BirthDay
        driver.findElement(By.id("BirthDate")).sendKeys("29/02/1996");
        driver.findElement(By.id("BirthDate")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
//phone
        driver.findElement(By.id("PhoneNumberMobile")).sendKeys("01515210371");
        Thread.sleep(2000);
//Checkbox
        driver.findElement(By.xpath("(//div[@class='col-md-1 col-sm-1 col-xs-1 mt-10'])[1]")).click();
        Thread.sleep(2000);
//  Submit Button
        driver.findElement(By.id("btnCreateAction")).click();
        Thread.sleep(15000);

        TakeSS("Submit From");
    }

    @Test(description = "Move to Login as SkyStar", priority = 16)
    public  void MoveLoginAsSS() throws InterruptedException, IOException {

        driver.findElement(By.linkText("Login with an existing profile")).click();
        Thread.sleep(5000);

        TakeSS("Move to Login");
    }

}
