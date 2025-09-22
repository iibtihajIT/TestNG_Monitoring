package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T01_HardAssertLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void positiveLoginTest() {
        // 1. Navigate
        driver.get("https://claruswaysda.github.io/signIn.html");

        // 2. Enter username
        driver.findElement(By.id("username")).sendKeys("admin");

        // 3. Enter password
        driver.findElement(By.id("password")).sendKeys("123");

        // 4. Click Submit
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Sign In']"));

        // 5a. Hard Assertion URL (الآن صحيح)
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://claruswaysda.github.io/signIn.html"; // الرابط الصحيح
        Assert.assertEquals(actualUrl, expectedUrl, "URL check failed!");

        // 5b. Hard Assertion نص Employee Table
        Assert.assertTrue(driver.getPageSource().contains("Employee Table"), "Text not found!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}