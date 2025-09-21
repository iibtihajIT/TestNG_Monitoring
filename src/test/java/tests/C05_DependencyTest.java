package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependencyTest {

    WebDriver driver;
//    . Create a class called DependencyTest
// 2. Create a @BeforeClass method to set up WebDriver
// 3. Create the following dependent test chain: openYahoo() - Navigate to Yahoo

//    openBing() - Navigate to Bing (depends on Yahoo test)
//    openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
// 4. Add intentional failure in Yahoo test and observe behavior
// 5. Create @AfterClass method to close driver

    @BeforeClass
    void setUp(){
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    void openYahoo(){
        driver.get("https://yahoo.com");
        Assert.fail();


    }
   @Test(dependsOnMethods = "openYahoo")
    void openBing(){
        driver.get("https://Bing.com");



    }
   @Test(dependsOnMethods = "openBing")
    void openDuckDuckGo(){
        driver.get("https://DuckDuckGo.com");



    }

    @AfterClass
     void tearDown() {
        driver.quit();
    }
}



