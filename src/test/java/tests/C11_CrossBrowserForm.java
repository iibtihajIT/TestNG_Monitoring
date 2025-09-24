package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;

public class C11_CrossBrowserForm extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
    Do this test with Chrome, Edge and Firefox
    */

    @Test
    @Parameters({"name", "age", "department"})
    void crossBrowserFormTest(@Optional("John") String name, @Optional("35") String age, @Optional("IT Department") String department) {

//        Go to https://claruswaysda.github.io/ActionsForm.html
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill form and submit
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("age")).sendKeys(age);
        new Select(driver.findElement(By.id("options"))).selectByVisibleText(department);
        driver.findElement(By.xpath("//input[@value='coding']")).click();
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//*[.='Generate Passcode']")).click();
        String passcode = driver.switchTo().alert().getText().replaceAll("\\D", "");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(passcode);
        driver.switchTo().alert().accept();
        driver.switchTo().frame("iframeSubmit");
        driver.findElement(By.id("submitButton")).click();

//        Do all actions and assert
        String secondPagesHandle = new ArrayList<>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(secondPagesHandle);
        new Actions(driver)
                .dragAndDrop(driver.findElement(By.id("drag1")), driver.findElement(By.id("drop1")))
                .contextClick(driver.findElement(By.id("showSuccessButton")))
                .doubleClick(driver.findElement(By.id("doubleClickButton")))
                .moveToElement(driver.findElement(By.id("hoverButton")))
                .perform();
        assert driver.findElement(By.id("info")).getText().contains("The Selenium WebDriver");

//        Do this test with Chrome, Edge and Firefox
    }
}