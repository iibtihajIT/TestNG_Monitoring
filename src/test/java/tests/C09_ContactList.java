package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class C09_ContactList {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Parameters({"email", "password", "firstName", "lastName"})
    @Test(groups = {"CL"})
    void contactListTest(
            @Optional("johndoeSDA@yahoo.com") String email,
            @Optional("John.123") String password,
            @Optional("John") String firstName,
            @Optional("Doe") String lastName) {

        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        // login
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

        // add new contact
        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("submit")).click();

        // wait for the new contact to appear in the table
        String fullName = firstName + " " + lastName;
        WebElement addedContact = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + fullName + "')]"))
        );

        // assert
        Assert.assertTrue(addedContact.isDisplayed(), "Contact was not added successfully!");
    }
}
