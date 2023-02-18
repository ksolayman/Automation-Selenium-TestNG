package XYZBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Home {
    WebDriver driver;
    String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeMethod
    public void browserSetup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(url);
        Thread.sleep(2000);
    }

    @AfterMethod
    public  void quitBrowser(){
        driver.quit();
    }

    public void TakeSS(String fileName) throws IOException {

    //    String date = new SimpleDateFormat("MMM-dd-yyyy").format(new Date());
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/SQA/Project/Selenium/Project/XYZBank/ScreenShots/XYZBank.Home/"+fileName+".png");
        FileUtils.copyFile(src,dest);

        System.out.println("Screenshot is captured");

    }
    @Test(description = "Launched Browser", priority = 0)
    public void launchedBrowser() throws IOException, InterruptedException {
        //
        Thread.sleep(5000);
        TakeSS("Launched Browser");
    }

    @Test(description = "Check Title", priority = 1)
    public void checkTitle() throws IOException, InterruptedException {

        String expTitle = "XYZ Bank";

        String  actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expTitle);

        if(expTitle.equals(actualTitle)){
            System.out.println("Title is matched");
        }else {
            System.out.println("Title is not matched");
        }

        Thread.sleep(2000);
        TakeSS("Check Title");
    }

    @Test(description = "Check URL", priority = 2)
    public void checkUrl() throws IOException, InterruptedException {
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,url);

        if (currentUrl.equals(url)){
            System.out.println("URL is matched");
        }else {
            System.out.println("URL is not matched");
        }

        Thread.sleep(2000);
        TakeSS("Check URL");
    }

    @Test(description = "Hme Button Displayed", priority = 3)
    public void isHomeButtonDisplayed() throws IOException, InterruptedException {
        WebElement homeButton = driver.findElement(By.xpath("//button[normalize-space()='Home']"));
        boolean isDisplayed = homeButton.isDisplayed();

        if(isDisplayed){
            System.out.println("XYZBank.Home button is displayed");
        }else {
            System.out.println("XYZBank.Home button is not displayed");
        }

        Thread.sleep(2000);
        TakeSS("XYZBank.Home Button Displayed");

    }

    @Test(description = "Hme Button Enabled", priority = 4)
    public void isHomeButtonEnabled(){
        WebElement homeButton = driver.findElement(By.xpath("//button[normalize-space()='Home']"));
        boolean isEnabled = homeButton.isEnabled();

        if(isEnabled){
            System.out.println("XYZBank.Home button is enabled");
        }else {
            System.out.println("XYZBank.Home button is not enabled");
        }

    }

    @Test(description = "Customer Login Button Displayed", priority = 5)
    public void  isCustomerLoginButtonDisplayed() throws InterruptedException, IOException {
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Customer Login']"));
        boolean isDisplayed = loginButton.isDisplayed();

        if(isDisplayed){
            System.out.println("Customer login button is displayed");
        }else {
            System.out.println("Customer login button is not displayed");
        }

        Thread.sleep(2000);
        TakeSS("Customer Login Button Displayed");
    }

    @Test(description = "Customer Login Button Enabled", priority = 6)
    public void isCustomerLoginButtonEnabled(){
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Customer Login']"));
        boolean isEnabled = loginButton.isEnabled();

        if(isEnabled){
            System.out.println("Customer login button is enabled");
        }else {
            System.out.println("Customer login button is not enabled");
        }
    }


    @Test(description = "Bank Manager Login Button Displayed", priority = 7)
    public void isBankManagerLoginButtonDisplayed() throws InterruptedException, IOException {
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        boolean isEnabled = loginButton.isEnabled();

        if(isEnabled){
            System.out.println("Bank Manager login button is enabled");
        }else {
            System.out.println("Bank Manager login button is not enabled");
        }

        Thread.sleep(2000);
        TakeSS("Bank Manager Login Button Displayed");
    }


    @Test(description = "Bank Manager Login Button Enabled", priority = 8)
    public void isBankManagerLoginButtonEnabled(){
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        boolean isEnabled = loginButton.isEnabled();

        if(isEnabled){
            System.out.println("Bank Manager login button is enabled");
        }else {
            System.out.println("Bank Manager login button is not enabled");
        }
    }

    @Test(description = "Navigation", priority = 9)
    public void navigationBack() throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);
        TakeSS("Navigate Back");
    }

    @Test(description = "Navigation", priority = 10)
    public void navigationForward() throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        TakeSS("Navigate Forward");
    }


}
