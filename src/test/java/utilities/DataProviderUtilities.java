package utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    @DataProvider(name = "faker")
    public Object[][] getFormDataFaker() {
        Faker faker = new Faker();
        return new Object[][]{
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName()},
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName()},
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName()},
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName()}
        };
    }
}
