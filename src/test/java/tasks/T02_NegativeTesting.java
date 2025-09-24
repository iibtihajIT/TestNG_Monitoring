package tasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class T02_NegativeTesting extends TestBase {

    @Test
    public void negativeTesting() {
        // Navigate to the login page
        driver.get("https://claruswaysda.github.io/signIn.html");

        // Scenario 1: incorrect username & password
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.id("password")).sendKeys("wrongPass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Handle the alert that appears for incorrect credentials
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();  // Close the alert

        // Verify that the error message is displayed on the page
        Assert.assertTrue(driver.findElement(By.id("msg")).isDisplayed());

        // Scenario 2: incorrect username only
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Handle the alert
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.id("msg")).isDisplayed());

        // Scenario 3: incorrect password only
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("wrongPass");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Handle the alert
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.id("msg")).isDisplayed());

        // Scenario 4: empty username & password
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Handle the alert
        alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.id("msg")).isDisplayed());
    }
}
