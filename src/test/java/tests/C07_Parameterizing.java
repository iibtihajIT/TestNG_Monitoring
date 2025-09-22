package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C07_Parameterizing extends TestBase {

    @Test
    @Parameters({"todo"})
    void paramsTest(@Optional("Study Selenium") String todo) {

        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        driver.findElement(By.tagName("input")).sendKeys(todo, Keys.ENTER);
        String lastToDo = driver.findElements(By.tagName("li")).getLast().getText();
        Assert.assertEquals(lastToDo, todo);

    }


}
