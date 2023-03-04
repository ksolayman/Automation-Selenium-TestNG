package CustomerRegistrationpageFunctionality;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CustomerRegistrationPage {

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
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[contains(text(),'রেজিস্টার')]")).click();
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    public void takeSS(String fileName) throws IOException {
        try {
            // Open the current date and time
            //String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh:mm:ss").format(new Date());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File trg = new File( System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/" +fileName+".png");
            FileUtils.copyFile(src, trg);

            System.out.println("ScreenShot Captured");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test(description = "Move Registration Page", priority = 1)
    public void MoveToRegistrationPage() throws IOException, InterruptedException {
        //

        Thread.sleep(3000);
        takeSS("Move to Registration Page");

    }

    @Test(description = "Registration Without Credentials", priority = 2)
    public void  RegistrationWithoutCredentials() throws InterruptedException, IOException, AWTException {
        //submit
        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(3000);

        //takeSS("Verify Registration Without Credentials");

        driver.switchTo().alert();
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/Verify Registration Without Credentials.png"));

        driver.switchTo().alert().accept();
    }



    @Test(description = "Registration Using Invalid Name", priority = 3)
    public void  RegistrationUsingInvalidName() throws InterruptedException, IOException, AWTException {

        //Invalid Name
        driver.findElement(By.id("NameTextBox")).sendKeys("123456");
        Thread.sleep(2000);

        driver.findElement(By.id("MobileTextBox")).sendKeys("01704782560");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);

        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(15000);

        //takeSS("Invalid Name");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image,"jpg" ,new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/egistration Using Invalid Name.png"));
    }

    @Test(description = "Registration Using Invalid Mobile Number", priority = 4)
    public void  RegistrationUsingInvalidMobileNumber() throws InterruptedException, IOException, AWTException {

        driver.findElement(By.id("NameTextBox")).sendKeys("Robert");
        Thread.sleep(2000);

        //Invalid Mobile Number
        driver.findElement(By.id("MobileTextBox")).sendKeys("0170478257");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);

        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(15000);

        //takeSS("Invalid Mobile");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image,"jpg" ,new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/Registration Using Invalid Mobile.png"));

    }

    @Test(description = "Registration Using Invalid Password", priority = 5)
    public void  RegistrationUsingInvalidPassword() throws InterruptedException, IOException, AWTException {

        driver.findElement(By.id("NameTextBox")).sendKeys("Robert");
        Thread.sleep(2000);

        driver.findElement(By.id("MobileTextBox")).sendKeys("01704782561");
        Thread.sleep(2000);

        //Invalid Password
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456789");
        Thread.sleep(2000);

        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(15000);

        //takeSS("Invalid Password");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image,"jpg" ,new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/Registration Using Invalid Password.png"));

    }

    @Test(description = "Registration Using Invalid Email",priority = 6)
    public void  RegistrationUsingInvalidEmail() throws InterruptedException, IOException, AWTException {

        driver.findElement(By.id("NameTextBox")).sendKeys("Robert");
        Thread.sleep(2000);

        driver.findElement(By.id("MobileTextBox")).sendKeys("01704782562");
        Thread.sleep(2000);

        //Invalid Email
        driver.findElement(By.id("EmailTextBoxs")).sendKeys("salman911gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);

        //submit
        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(3000);

        //takeSS("Invalid Email");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image,"jpg" ,new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/Registration Using Invalid Email.png"));

    }

    @Test(description = "Registration Using All Valid Credentials", priority = 7)
    public void  RegistrationUsingAllValidCredentials() throws InterruptedException, IOException {
        driver.findElement(By.id("NameTextBox")).sendKeys("Solayman");
        Thread.sleep(2000);
        driver.findElement(By.id("MobileTextBox")).sendKeys("01515210371");
        Thread.sleep(2000);
        driver.findElement(By.id("EmailTextBoxs")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("MaleRadioButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(3000);

        takeSS("Verify Registration using All Valid Credentials");
    }


    @Test(description = "Registration Using Mandatory Credentials", priority = 8)
    public void  RegistrationUsingMandatoryCredentials() throws InterruptedException, IOException, AWTException {
        driver.findElement(By.id("NameTextBox")).sendKeys("Solayman");
        Thread.sleep(2000);
        driver.findElement(By.id("MobileTextBox")).sendKeys("01998499222");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(3000);

        //takeSS("Verify Registration using Mandatory Credentials");
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image,"jpg" ,new File(System.getProperty("user.dir")+"/ScreenShots/RegistrationPage/Registration Using Mandatory Credentials.png"));

    }

    @Test(description = "isRegister Button Displayed", priority = 9)
    public void isSearchButtonDisplayed() throws InterruptedException, IOException {
        WebElement isDisplayed = driver.findElement(By.id("SignupButton"));
        boolean isButtonDisplayed = isDisplayed.isDisplayed();

        if(isButtonDisplayed){
            System.out.println("Search button is displayed");
        }
        else {
            System.out.println("Search button is not displayed");
        }
        Thread.sleep(3000);
        takeSS("isRegister Button Displayed");
    }

    @Test(description = "isRegister Button Enabled", priority = 10)
    public void isSearchButtonEnabled() throws InterruptedException, IOException {
        WebElement isEnabled = driver.findElement(By.id("SignupButton"));
        boolean isButtonEnabled = isEnabled.isEnabled();

        if(isButtonEnabled){
            System.out.println("Search button is enabled");
        }
        else {
            System.out.println("Search button is not enabled");
        }
        Thread.sleep(3000);
        takeSS("isRegister Button Enabled");
    }

    @Test(description = "Registration Again With Same Credentials", priority = 11)
    public void  RegistrationAgainWithSameCredentials() throws InterruptedException, IOException {
        driver.findElement(By.id("NameTextBox")).sendKeys("Solayman");
        Thread.sleep(2000);
        driver.findElement(By.id("MobileTextBox")).sendKeys("01515210371");
        Thread.sleep(2000);
        driver.findElement(By.id("EmailTextBoxs")).sendKeys("ksolayman911@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("againPassowrd")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.id("MaleRadioButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("SignupButton")).click();
        Thread.sleep(3000);

        takeSS("Registration Again With Same Credentials");
    }

}
