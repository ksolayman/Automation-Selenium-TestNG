package HomepageFunctionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class HomePage {
    WebDriver driver;
    String url = "https://ajkerdeal.com/";

    @BeforeMethod
    public void getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get(url);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
    public void takeSS(String fileName) {
        try {
            // Open the current date and time
            //String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());
            ///Users/SQA/Project/Selenium/Project/AjkerDeal/ScreenShots/LoginPage

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File trg = new File( System.getProperty("user.dir")+"/ScreenShots/LoginPage/" +fileName+".png");
            FileUtils.copyFile(src, trg);

            System.out.println("ScreenShot Captured");

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    @Test(description = "Verify Title is valid", priority = 1)
    public void CheckTitle() throws InterruptedException, IOException {
        String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(3000);

        takeSS("Check Title");
    }
    @Test(description = "Verify Logo", priority = 2)
    public void VerifyLogo() throws IOException, InterruptedException {

        WebElement logo = driver.findElement(By.xpath("//img[@alt='logo']"));
        if (logo.isDisplayed()) {
            System.out.println("Logo is Displayed");
        } else {
            System.out.println("Logo is not Displayed");
        }
        Thread.sleep(3000);
        takeSS("Verify Logo");

    }

    @Test(description = "Verify SearchBox", priority = 3)
    public void CheckSearchBox() throws InterruptedException, IOException {
        WebElement search = driver.findElement(By.name("search"));
        if (search.isDisplayed()) {
            System.out.println("Search Bar is Displayed");
        } else {
            System.out.println("Search Bar  not Displayed");
        }

        Thread.sleep(3000);
        takeSS("Verify SearchBox");
    }

    @Test(description = "Check Product Category", priority = 4)
    public void CheckProduct() throws InterruptedException, IOException {

        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("(//a[@href='https://ajkerdeal.com/category/gadgets'][contains(text(),'গ্যাজেটস')])[1]"))).build().perform();
        Thread.sleep(2000);
        takeSS("Check Product Category 01");

        hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'টেলিভিশন')]"))).build().perform();
        Thread.sleep(2000);
        takeSS("Check Product Sub-Category 02");

        driver.findElement(By.xpath("//a[normalize-space()='Sony']")).click();
        Thread.sleep(3000);

        takeSS("Check Product 03");
    }

    @Test(description = "isSearch button Enabled", priority = 5)
    public void isSearchButtonEnabled() throws InterruptedException, IOException {
        WebElement isEnabled = driver.findElement(By.xpath("//button[@type='button']"));
        boolean isButtonEnabled = isEnabled.isEnabled();

        if(isButtonEnabled){
            System.out.println("Search button is enabled");
        }
        else {
            System.out.println("Search button is not enabled");
        }
        Thread.sleep(3000);
        takeSS("isSearch Button Enabled");
    }

    @Test(description = "Search Product", priority = 6)
    public void SearchProduct() throws InterruptedException, IOException {
        driver.findElement(By.id("txtName")).sendKeys("mobile");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        String expectedTitle = "আজকেরডিল.কম| বাংলাদেশী অনলাইন শপিং সাইট | অনুসন্ধান";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(3000);
        takeSS("Search Product");

    }

    @Test(description = "Back to Home via click logo", priority = 7)
    public void BackToHome() throws InterruptedException, IOException {
        driver.findElement(By.id("txtName")).sendKeys("candle");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(2000);
        takeSS("Before BackToHome");

        driver.findElement(By.xpath("//img[@alt='logo']")).click();
        Thread.sleep(1000);
        takeSS("After BackToHome");
    }

    @Test(description = "Change Language BAN To ENG", priority = 8)
    public void LanguageChange() throws InterruptedException, IOException {

        driver.findElement(By.xpath("//a[normalize-space()='ENG']")).click();
        Thread.sleep(2000);
        takeSS("Before Change Language");

        String expectedTitle = "Online Shopping BD - Clothing & Gadget Shop | Ajkerdeal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(3000);
        takeSS("Change Language");

    }

    @Test(description = "Product Order",priority = 9)
    public void ProductOrder() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//div[@id='NewHotDealBlock']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//img[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='Button1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='FreeGiftSizeValue']//input[@id='L']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='Button1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='Button1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='placeOrder']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Thread.sleep(3000);

        takeSS("Product Order");

    }

}
