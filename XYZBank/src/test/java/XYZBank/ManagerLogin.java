package XYZBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.awt.Robot;


public class ManagerLogin {
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

        driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public  void quitBrowser(){
        driver.quit();
    }

    public void TakeScreenShot(String fileName) throws IOException {

        //    String date = new SimpleDateFormat("MMM-dd-yyyy").format(new Date());
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/ScreenShots/XYZBank.ManagerLogin/"+fileName+".png");
        FileUtils.copyFile(src,dest);

        System.out.println("Screenshot is captured");

    }

    @Test(description = "Launched Browser", priority = 1)
    public void launchedBrowser() throws IOException, InterruptedException {
        //
        Thread.sleep(5000);
        TakeScreenShot("Launched Browser");
    }

    @Test(description = "Add Customer", priority = 2)
    public void addCustomer() throws IOException, InterruptedException, AWTException {
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Solayman");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Khan");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("U12300");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);


// Robot class for Screenshot for popup
//        try {
//            Robot robot = new Robot();
//            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//            Rectangle screenRect = new Rectangle(dim);
//            BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
//            ImageIO.write(bufferedImage,"png", new File("/Users/SQA/Project/Selenium/Project/XYZBank/ScreenShots/XYZBank.ManagerLogin/Add Customer.png"));
//
//        }catch (AWTException | IOException e) {
//            e.printStackTrace();
//        }
        driver.switchTo().alert().accept();
    }

    @Test(description = "Open Account", priority = 3)
    public void openAccount() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Solayman");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Khan");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("U12300");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        Alert alt = driver.switchTo().alert();
        alt.accept();

        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='userSelect']")).click();
        WebElement user = driver.findElement(By.xpath("//select[@id='userSelect']"));
        Select selectUser = new Select(user);
        selectUser.selectByVisibleText("Solayman Khan");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='currency']")).click();
        WebElement currency = driver.findElement(By.xpath("//select[@id='currency']"));
        Select selectCurrency = new Select(currency);
        selectCurrency.selectByVisibleText("Pound");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Process']")).click();

        Thread.sleep(3000);
       // TakeScreenShot("Open Account");

    }


    @Test(description = "view Customers", priority = 4)
    public void viewCustomers() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);

        TakeScreenShot("View Customers");
    }


    @Test(description = "Total Customer", priority = 5)
    public void totalCustomer() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Total Customer: "+rows.size());

        Thread.sleep(3000);
        TakeScreenShot("Total Customers");
    }


    @Test(description = "Search Customer by Account", priority = 6)
    public void searchCustomerByAccount() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("1010");
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        TakeScreenShot("Search Customers by Account");
    }

    @Test(description = "Search Customer by FirstName", priority = 7)
    public void searchCustomerByFirstName() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        TakeScreenShot("Search Customers by FirstName");
    }


    @Test(description = "Search Customer by LastName", priority = 8)
    public void searchCustomerByLastName() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Weasly");
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        TakeScreenShot("Search Customers by LastName");
    }


    @Test(description = "Delete Customer", priority = 9)
    public void deleteCustomer() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(3000);
        TakeScreenShot("Before Delete Customer");

        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("1010");
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();

        driver.navigate().refresh();
        Thread.sleep(5000);

        TakeScreenShot("After Delete Customer");
    }

}
