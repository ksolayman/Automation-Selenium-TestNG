package CustomerLoginFunctionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class CustomerLogin {

    WebDriver driver;
    String homeUrl = "https://ajkerdeal.com/";

    @BeforeMethod
    public void getDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get(homeUrl);
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//a[contains(text(),'লগইন')])[1]")).click();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    public void takeSS(String fileName) {
        try {
            // Open the current date and time
            //String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File trg = new File( System.getProperty("user.dir")+"/ScreenShots/HomePage/" +fileName+".png");
            FileUtils.copyFile(src, trg);

            System.out.println("ScreenShot Captured");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test(description = "Move Login Page", priority = 1)
    public void MoveToRegistrationPage() throws IOException, InterruptedException {
        //
        Thread.sleep(3000);
        takeSS("Move to Login");

    }

    @Test(description = "Hover LoginButton", priority = 2)
    public void HoverLoginButton() throws InterruptedException, IOException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.id("hover-Id"))).build().perform();
        Thread.sleep(3000);

        takeSS("LoginButton Hover");

    }
    @Test(description = "Verify Login using valid Credentials", priority = 3)
    public void LoginValidCredentials() throws InterruptedException, IOException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.id("hover-Id"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.id("Email")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='লগইন']")).click();
        Thread.sleep(3000);

        takeSS("login using valid Credentials");
    }


    @Test(description = "Verify Login using Invalid Email and Valid Password", priority = 4)
    public void OneInvalidCredentials() throws InterruptedException, IOException, AWTException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.id("hover-Id"))).build().perform();
        Thread.sleep(2000);

        //Invalid Email or Password
        driver.findElement(By.id("Email")).sendKeys("ksolayman911gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='লগইন']")).click();
        Thread.sleep(3000);

        //takeSS("Login using invalid email");

        driver.switchTo().alert();
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("F:\\Learn SQA\\Automation\\AjkerDeal\\ScreenShots\\LoginPage\\Login using invalid email.png"));

        driver.switchTo().alert().accept();
    }

    @Test(description = "Verify Login using Invalid credentials", priority = 5)
    public void LoginInvalidCredentials() throws InterruptedException, IOException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.id("hover-Id"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.id("Email")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='লগইন']")).click();
        Thread.sleep(3000);

        takeSS("Verify Login using Invalid credentials");
    }


    @Test(description = "Navigate Back", priority = 6)
    public void NavigateBack() throws InterruptedException, IOException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
        Thread.sleep(1000);

        driver.findElement(By.id("Email")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='লগইন']")).click();
        Thread.sleep(3000);

        takeSS("Before Navigate Back");

        driver.navigate().back();
        Thread.sleep(3000);

        takeSS("After Navigate Back");

        driver.navigate().forward();
        Thread.sleep(3000);
        takeSS("Again Before Navigate Back");

        String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Matched");
        }else {
            System.out.println("Not Matched");
        }


    }
    @Test(description = "Verify Login and Logout", priority = 7)
    public void LogOut() throws InterruptedException, IOException {
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.id("Email")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("Password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='লগইন']")).click();
        Thread.sleep(3000);

        takeSS("Before Logout");

        hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Solayman আপনার অ্যাকাউন্ট')]"))).build().perform();
        Thread.sleep(2000);

        String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Logged Out");
        }else {
            System.out.println("Not Logged Out");
        }

        hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Solayman আপনার অ্যাকাউন্ট')]"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'সাইন আউট')]")).click();
        Thread.sleep(2000);

        takeSS("After Logout");
    }



}
