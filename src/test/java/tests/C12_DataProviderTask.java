package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C12_DataProviderTask extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Fill the form
    Do it with all 3 ways
    (Same class Data Provider, Data Provider with Faker, Data Provider with Excel)
    */

    @Test(dataProvider = "form")
    void dataProviderTaskTest01(String ssn, String firstname, String lastname) {
//        Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");
//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }

    @Test(dataProvider = "faker", dataProviderClass = utilities.DataProviderUtilities.class)
    void dataProviderTaskTest02(String ssn, String firstname, String lastname) {
//        Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");
//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }

    //Do it with all 3 ways (Same class Data Provider, Data Provider with Faker, Data Provider with Excel)
    @Test(dataProvider = "excel", dataProviderClass = utilities.ExcelUtilities.class)
    void dataProviderTaskTest03(String ssn, String firstname, String lastname, String dropdown){//        Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");
//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }



    @DataProvider(name = "form")
    public Object[][] getFormData() {
        return new Object[][]{
                {"123-66-4567", "John", "Doe"},
                {"654-66-9876", "Tom", "Stark"},
                {"456-55-8799", "Wayne", "Krank"}
        };
    }

}