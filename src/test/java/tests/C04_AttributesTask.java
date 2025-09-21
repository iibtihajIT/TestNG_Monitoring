package tests;

import org.testng.annotations.Test;

public class C04_AttributesTask {
//        Create 5 test methods with different priorities (1, 3, 2, 5, 4)

//        Create one test method with enabled = false

//        Create a test method with timeout of 3 seconds that includes Thread.sleep(2000)

//        Create a test method with timeout of 1 second that includes Thread.sleep(2000) (should fail)

//        Add meaningful descriptions to all test methods

//        Create test methods with groups: "smoke", "regression", "api"

    @Test(priority = 1, description = "This is test 01", groups = {"smoke", "api"})
    void test01() {

    }

    @Test(priority = 3, description = "This is test 02", groups = "regression")
    void test02() {

    }

    @Test(priority = 2, timeOut = 3000, description = "This is test 03", groups = "api")
    void test03() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(priority = 5, timeOut = 1000, description = "This is test 04. This will fail intentionally.", groups = "regression")
    void test04() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(priority = 4, description = "This is test 05", groups = "smoke")
    void test05() {

    }

}
