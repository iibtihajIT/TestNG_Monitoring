package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C08_SwagLabsParameters extends TestBase {

    /*
    Go to https://www.saucedemo.com/v1/index.html
    Enter username by taking it as parameter
    Enter password by taking it as parameter
    Assert login
     */

    @Test
    @Parameters({"username", "password"})
    void swagLabsParametersTest(@Optional("performance_glitch_user") String username, @Optional("secret_sauce") String password) {

      //Go to https://www.saucedemo.com/v1/index.html
        driver.get("https://www.saucedemo.com/v1/index.html");

       //Enter username by taking it as parameter
        driver.findElement(By.id("user-name")).sendKeys(username);

      // Enter password by taking it as parameter
        driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);

       //Assert login
        assert driver.findElement(By.xpath("//*[.='Products']")).isDisplayed();

    }

}
