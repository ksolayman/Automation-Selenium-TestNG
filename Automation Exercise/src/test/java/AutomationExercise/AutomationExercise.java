package AutomationExercise;

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
import java.time.Duration;

public class AutomationExercise {

    WebDriver driver;
    String url = "https://automationexercise.com/";
    //String ssLoc = System.getProperty("user.dir")+"\\src\\test\\ScreenShots\\";

    @BeforeMethod
    public void getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(url);
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


//    public void takeSS(String fileName) {
//        try {
//            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File trg = new File( ssLoc + fileName + ".png");
//            FileUtils.copyFile(src, trg);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }

    @Test(description = "launchBrowser and NavigateToURL", priority = 1)
    public void launchBrowser() {
     //
    }

    @Test(description = "isHomePageVisible", priority = 2)
    public void isHomePageVisible() {
        String expTitle = "Automation Exercise";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expTitle);
        if (actTitle.equals(expTitle)){
            System.out.println("home page is visible");
        }else {
            System.out.println("home page is not visible");
        }

    }

    @Test(description = "addProductToCart and ViewCart", priority = 3)
    public void addProductToCart() throws InterruptedException {

        driver.findElement(By.cssSelector("a[href='/product_details/2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);


    }

    @Test(description = "clickCartButton", priority = 4)
    public void clickCartButton() throws InterruptedException {
        driver.findElement(By.xpath("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);

    }


    @Test(description = "isCartPageDisplayed", priority = 5)
    public void isCartPageDisplayed() throws InterruptedException {

        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);

        String cartPageTitle = "Automation Exercise - Checkout";
        String currentPageTitle = driver.getTitle();
        Assert.assertEquals(currentPageTitle, cartPageTitle);

        if (currentPageTitle.equals(cartPageTitle)){
            System.out.println("cart page is displayed");
        }else {
            System.out.println("cart page is not displayed");
        }
    }


    @Test(description = "Proceed To Checkout", priority = 6)
    public void proceedToCheckout() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='text-center']//a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(8000);

    }

    @Test(description = "Click Register/Login", priority = 7)
    public void clickRegOrLogin() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='text-center']//a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
        Thread.sleep(3000);

    }

    @Test(description = "Click Signup with details", priority = 8)
    public void clickSignUp() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='text-center']//a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        Thread.sleep(5000);

    }

    @Test(description = "Registration With Details", priority = 9)
    public void registrationWithDetails() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        WebElement bDate = driver.findElement(By.xpath("//select[@id='days']"));
        Select dropdownDate = new Select(bDate);
        dropdownDate.selectByVisibleText("29");
        Thread.sleep(2000);
        WebElement bMonth = driver.findElement(By.xpath("//select[@id='months']"));
        Select dropdownMonth = new Select(bMonth);
        dropdownMonth.selectByVisibleText("February");
        Thread.sleep(2000);
        WebElement bYear = driver.findElement(By.xpath("//select[@id='years']"));
        Select dropdownYear = new Select(bYear);
        dropdownYear.selectByVisibleText("1996");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("khan");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("mohammadpur");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("dhaka");
        Thread.sleep(2000);

        WebElement countryName = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDropdown = new Select(countryName);
        countryDropdown.selectByVisibleText("Canada");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("mohammadpur");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("dhaka");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("1212");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("01811111111");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        Thread.sleep(5000);

    }

    @Test(description = "verify Account Created", priority = 10)
    public void verifyAccountCreated() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        WebElement bDate = driver.findElement(By.xpath("//select[@id='days']"));
        Select dropdownDate = new Select(bDate);
        dropdownDate.selectByVisibleText("29");
        Thread.sleep(2000);
        WebElement bMonth = driver.findElement(By.xpath("//select[@id='months']"));
        Select dropdownMonth = new Select(bMonth);
        dropdownMonth.selectByVisibleText("February");
        Thread.sleep(2000);
        WebElement bYear = driver.findElement(By.xpath("//select[@id='years']"));
        Select dropdownYear = new Select(bYear);
        dropdownYear.selectByVisibleText("1996");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("khan");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("mohammadpur");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("dhaka");
        Thread.sleep(2000);

        WebElement countryName = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDropdown = new Select(countryName);
        countryDropdown.selectByVisibleText("Canada");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("mohammadpur");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("dhaka");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("1212");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("01811111111");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        Thread.sleep(3000);

        String title = "Automation Exercise - Account Created";
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle,title);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(5000);

    }


    @Test(description = "Logged in as username", priority = 11)
    public void loggedInAsUserName() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        String userName = "sabuz";
        String logUser = driver.findElement(By.xpath("//b[normalize-space()='sabuz']")).getText();
        System.out.println(logUser);
        Assert.assertEquals(logUser,userName);

        if(logUser.equals(userName)) {
            System.out.println("Logged in as username");
        }else{
            System.out.println("Error! Logged in as unknown username");
        }

    }

    @Test(description = "Click Cart Button", priority = 12)
    public void clickCartBtn() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(8000);

    }

    @Test(description = "Proceed To Checkout", priority = 13)
    public void checkoutProcess() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(5000);

    }


    @Test(description = "Verify Address & Review", priority = 14)
    public void verifyAddressAndReview() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[href='/product_details/2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(5000);

        String addName = "Mr. sabuz khan";
        String addArea = "mohammadpur";
        String addCity = "dhaka";
        String addCode = "dhaka mohammadpur 1212";
        String addCountry = "Canada";
        String addPhone = "01811111111";

        String actAddName = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_firstname address_lastname'][normalize-space()='Mr. sabuz khan']")).getText();
        String actAddArea = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][normalize-space()='mohammadpur']")).getText();
        String actAddCity = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][normalize-space()='dhaka']")).getText();
        String actAddCode = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode'][contains(text(),'dhaka mohammadpur')]")).getText();
        String actAddCountry = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_country_name'][normalize-space()='Canada']")).getText();
        String actAddPhone = driver.findElement(By.xpath("//ul[@id='address_delivery']//li[@class='address_phone'][normalize-space()='01811111111']")).getText();

        Assert.assertEquals(actAddName,addName);
        Assert.assertEquals(actAddArea,addArea);
        Assert.assertEquals(actAddCity,addCity);
        Assert.assertEquals(actAddCode,addCode);
        Assert.assertEquals(actAddCountry,addCountry);
        Assert.assertEquals(actAddPhone,addPhone);

        if(actAddName == addName && actAddArea == addArea && actAddCity == addCity &&
        actAddCode == addCode && actAddCountry == addCountry && actAddPhone == addPhone){
            System.out.println("Address Verified & Reviewed");
        }else{
            System.out.println("Addres  Verified & Reviewed");
        }

    }

    @Test(description = "description in text area and click Place Order", priority = 15)
    public void checkPlaceOrder() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Color: White & Green");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
        Thread.sleep(5000);
    }


    @Test(description = "Payment Details", priority = 16)
    public void paymentDetails() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(
                "Material:100% Cotton", "Technics: Plain Dyed",
                "Sleeve Style: Short sleeve", "Fabric Type: Jersey");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Md Sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1023651023645");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("903");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("02");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("1996");
        Thread.sleep(2000);

    }


    @Test(description = "Pay and Confirm Order", priority = 17)
    public void payAndConfirmOrder() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(
                "Material:100% Cotton", "Technics: Plain Dyed",
                "Sleeve Style: Short sleeve", "Fabric Type: Jersey");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Md Sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1023651023645");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("903");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("02");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("1996");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(5000);
    }


    @Test(description = "Success Message", priority = 18)
    public void successMessage() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("sabuz@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(
                "Material:100% Cotton", "Technics: Plain Dyed",
                "Sleeve Style: Short sleeve", "Fabric Type: Jersey");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Md Sabuz");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1023651023645");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("903");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("02");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("1996");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        String text = "Congratulations! Your order has been confirmed!";
        String actText = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']")).getText();

        if(actText.equals(text)){
            System.out.println("Order Placed");
        }else{
            System.out.println("Error! Order is not placed");
        }
        Thread.sleep(5000);
        Assert.assertEquals(actText, text);



    }
}
