package XYZBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CustomerLogin {
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

        driver.findElement(By.cssSelector("button[ng-click='customer()']")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public  void quitBrowser(){
        driver.quit();
    }

    public void TakeSS(String fileName) throws IOException {

        //    String date = new SimpleDateFormat("MMM-dd-yyyy").format(new Date());
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/ScreenShots/XYZBank.CustomerLogin/"+fileName+".png");
        FileUtils.copyFile(src,dest);

        System.out.println("Screenshot is captured");

    }

    @Test(description = "Launched Browser", priority = 1)
    public void launchedBrowser() throws IOException, InterruptedException {
        //
        Thread.sleep(5000);
        TakeSS("Launched Browser");
    }

    @Test(description = "Customer Name", priority = 2)
    public void customerName() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(5000);

        TakeSS("Select User");
    }

    @Test(description = "Customer Login", priority = 3)
    public void userLogin() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(5000);
        TakeSS("Customer Login");
    }



    @Test(description = "Customer Login Successfully", priority = 4)
    public void isCustomerLoginSuccessfully() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        String customerName = "Harry Potter";
        String welcomeUser = driver.findElement(By.xpath("(//span[@class='fontBig ng-binding'])[1]")).getText();
        Assert.assertEquals(welcomeUser,customerName);

        if(welcomeUser.equals(customerName)){
            System.out.println("Customer is Logged in Successfully");
        }else {
            System.out.println("Customer is not  Logged in Successfully");
        }

        Thread.sleep(5000);
        TakeSS("Logged in Successfully");
    }


    @Test(description = "Select Account Number", priority = 5)
    public void selectCustomerAccount() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        TakeSS("Select Account Number");
    }


    @Test(description = "Deposit Amount", priority = 6)
    public void depositAmount() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        TakeSS("Deposit Amount");
    }


    @Test(description = "Amount Credited", priority = 7)
    public void amountCredited() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        String balance = driver.findElement(By.xpath("(//strong[normalize-space()])[4]")).getText();
        int initialBalance = Integer.parseInt(balance);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        String addBalance = driver.findElement(By.xpath("(//strong[normalize-space()])[4]")).getText();
        int finalBalance = Integer.parseInt(addBalance);

        if(finalBalance>initialBalance){
            System.out.println("Account is Credited");
            TakeSS("Amount Credited");
        }else {
            System.out.println("Account is not Credited");
        }

    }


    @Test(description = "Deposit Successful", priority = 8)
    public void isDepositSuccessful() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        String message = "Deposit Successful";
        String text = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(text, message);

        if(text.equals(message)){
            System.out.println("Deposit Successfully");
            Thread.sleep(5000);
            TakeSS("Deposit Successfully");
        }else {
            System.out.println("Deposit Failed");
        }

    }

    @Test(description = "Withdraw Amount", priority = 9)
    public void withdrawAmount() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        TakeSS("Before Withdraw Amount");

        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("350");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();
        Thread.sleep(5000);

        TakeSS("After Withdraw Amount");
    }


    @Test(description = "Amount Debited", priority = 10)
    public void amountDebited() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String iniBalance = driver.findElement(By.xpath("(//strong[normalize-space()])[4]")).getText();
        int initialBalance = Integer.parseInt(iniBalance);

        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("350");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();
        Thread.sleep(5000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        String addBalance = driver.findElement(By.xpath("(//strong[normalize-space()])[4]")).getText();
        int finalBalance = Integer.parseInt(addBalance);

        if(finalBalance<initialBalance){
            System.out.println("Account is Debited");
            TakeSS("Amount Debited");
        }else {
            System.out.println("Account is not Debited");
        }

    }


    @Test(description = "Transaction Successful", priority = 11)
    public void isWithdrawSuccessful() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        Thread.sleep(5000);
        TakeSS("Before Transaction Amount");

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("350");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();
        Thread.sleep(5000);

        String message = "Transaction Successful";
        String text = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();

        if(text.equals(message)){
            System.out.println("Transaction Successfully");
            Thread.sleep(5000);
            TakeSS("Transaction Successful");
        }else {
            System.out.println("Transaction Failed. You can not withdraw amount more than the balance.");
            Thread.sleep(5000);
            TakeSS("Transaction Failed");
        }
    }


    @Test(description = "View Transactions", priority = 12)
    public void transactionList() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("550");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("200");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("100.50");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        TakeSS("Cant Deposit Fraction Value");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(5000);

        TakeSS("View Transactions");
    }


    @Test(description = "Back Navigation", priority = 13)
    public void navigationBack() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        TakeSS("Back Navigation");
    }


    @Test(description = "Forward Navigation", priority = 14)
    public void navigationForward() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Back']")).click();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        TakeSS("Forward Navigation");
    }

    @Test(description = "Back to XYZBank.Home", priority = 15)
    public void backToHome() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
        Thread.sleep(5000);

        TakeSS("Back to Home");
    }


    @Test(description = "Customer Logout", priority = 16)
    public void customerLogout() throws InterruptedException, IOException {
        driver.findElement(By.id("userSelect")).click();

        WebElement element = driver.findElement(By.id("userSelect"));
        Select userName = new Select(element);
        userName.selectByVisibleText("Harry Potter");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//select[@id='accountSelect']")).click();
        WebElement accounts = driver.findElement(By.xpath("//select[@id='accountSelect']"));
        Select accNumber = new Select(accounts);
        accNumber.selectByVisibleText("1005");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
        Thread.sleep(5000);

        TakeSS("Customer Logout");
    }

}
