import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 1. Visit the URL Konga
 2. Sign in to Konga Successfully
 3. From the Categories, click on the “Computers and Accessories”
 4. Click on the Laptop SubCategory
 5. Click on the Apple MacBooks
 6. Add an item to the cart
 7. Select Address
 8. Continue to make payment
 9. Select a Card Payment Method
 10. Input invalid card details
 11. Print Out the error message: Invalid card number
 12. Close the iFrame that displays the input card Modal
 13. Quit the browser
 */

public class KongaWebOrderFlowTest {
    //Import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate chrome driver
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        //Open Chrome browser
        driver = new ChromeDriver();
        //Input Konga url
        driver.get("https://www.konga.com/");
        //Maximize window
        driver.manage().window().maximize();
        //Locate and click the Login/Signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
    }

    @Test (priority = 1)
    public void login() throws InterruptedException {
        System.out.println("Account login");
        //Locate the Email Address or Phone Number field and input email address
        driver.findElement(By.id("username")).sendKeys("@gmail.com");
        //Locate the Password field and input password
        driver.findElement(By.id("password")).sendKeys("SAMPLEadmin");
        //Locate and click the Login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @Test (priority = 2)
    public void selectItem() throws InterruptedException {
        System.out.println("Begin order flow");
        //Locate and select the “Computers and Accessories” button from the all categories section
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Locate and select the Laptop button from the browse categories section
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/label/span")).click();
        Thread.sleep(3000);
        //Select the Apple MacBooks from the dropdown menu
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(3000);
        //Locate and select the Add to cart button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @Test (priority = 3)
    public void myCart() throws InterruptedException {
        System.out.println("Open my cart");
        //Locate and select the my cart button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(3000);
        System.out.println("Begin checkout");
        //Locate and select the checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 4)
    public void checkout() throws InterruptedException {
        //Locate and select the change address button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(3000);
        System.out.println("Select address");
        //Locate and select the Add Delivery Address button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //Select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
        //Select the use this address button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(3000);
        System.out.println("Begin payment");
        //Locate and select the pay now option
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(3000);
        //Locate and select the continue to payment button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(13000);
    }

    @Test (priority = 5)
    public void selectCardMethod() throws InterruptedException {
        //Change from default to iframe
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);
        System.out.println("Payment Method");
        //Select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("Select card method");
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void inputCardDetails() throws InterruptedException {
        //Input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("123405067890");
        Thread.sleep(3000);
        //Input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1224");
        Thread.sleep(3000);
        //Input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("357");
        Thread.sleep(5000);
        System.out.println("Input card details");
        //Input card pin in its field
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 7)
    public void displayErrorMessage() throws InterruptedException {
        //Print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(3000);
    }

    @Test (priority = 8)
    public void closeFrame() throws InterruptedException {
        //Close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("Exit payment method iframe");
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void exitIFrame() throws InterruptedException {
        //Exit iFrame web
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        System.out.println("Restore default page");
    }

    @AfterTest
    public void end(){
        //Close Web Driver
        driver.quit();
    }
}
